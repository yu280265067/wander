package com.ycx.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/*
 * NIO 与 BIO（普通流） 区别： 
 * 	1. BIO使用流的方式处理io，处理的单位是字节，也就是一次只能传输一个字节，
 * 效率比较低，NIO是以块的形式来传输数据，效率相应提高一些。具体的实现方式是channnel管道加ByteBuffer
 * 缓冲的方式。从前是stream中直接读取数据源，NIO是管道从buffer读取或者写入，其实就是加了一层buffer缓冲
 * 而已，也叫做以块为单位。
 * 	2.NIO与BIO另一个区别是 同步异步阻塞非阻塞的区别，这几个概念看了很长时间也没理解，今天结合代码和资料
 * 终于有了自己的理解。现在NIOServer.java IOServer.java 的对应位置有详细的注解说明，总的来说，
 * NIO的read方法如果没有数据源返回0，代码（官方叫线程）可以向下执行，不会一直停在那，这就叫非阻塞，
 * 而IO的read（write也一样）如果没有数据源返回－1，但是代码停止在那，不会向下执行，这就叫阻塞。
 * 换句话说阻塞不阻塞就是线程向不向下执行。至于同步异步 NIO和BIO都是同步的,AIO是异步的，自己的理解，
 * 同步就是我发起io连接，io读取或者写入完成与否操作系统不会主动告诉我，需要我一直轮询，
 * 代码如下用while轮询。而异步的AIO在read的时候多了一个参数
 * CompletionHandler<Integer, AsynchronousSocketChannel> 来完成回调，也就是说当read或者
 * write完成以后会通知当前线程，执行completed方法，当然需要重写。
 * 	3.第三个区别是NIO加入了selector，也叫做reactor反应器模式，也叫做observer模式。简单说就是把
 * channel注册到selector上，当有连接进来时，io请求进来时，selector都能获得到这个信号，并且能把这
 * 几中信号区分开，这样的话，当有连接进来时可以先不管，只有io请求真的来了才去处理，这也是BIO达不到的
 * BIO只要有连接就建立一个线程。
 * 
*/
public class NIOServer {
	private static final int BUF_SIZE = 1024;
	private static final int PORT = 8080;
	private static final int TIMEOUT = 3000;

	public static void main(String[] args) {
		selector();
	}

	public static void handleAccept(SelectionKey key) throws IOException {
		ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
		SocketChannel sc = ssChannel.accept();
		sc.configureBlocking(false);
		sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
	}

	public static void handleRead(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = sc.read(buf);
		while (bytesRead > 0) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			System.out.println();
			buf.clear();
			bytesRead = sc.read(buf);
		}
		if (bytesRead == -1) {
			sc.close();
		}
	}

	public static void handleWrite(SelectionKey key) throws IOException {
		ByteBuffer buf = (ByteBuffer) key.attachment();
		buf.flip();
		SocketChannel sc = (SocketChannel) key.channel();
		while (buf.hasRemaining()) {
			sc.write(buf);
		}
		buf.compact();
	}

	public static void selector() {
		Selector selector = null;
		ServerSocketChannel ssc = null;
		ServerSocketChannel cha1 = null;
		ServerSocketChannel cha2 = null;

		try {
			selector = Selector.open();
			ssc = ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(PORT));
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			// SocketChannel sc = ssc.accept();
			// ByteBuffer buf = ByteBuffer.allocate(1024);
			// int n = sc.read(buf);

			while (true) {
				// 用于serversocketChannel
				// 没有read等方法，只能注册在selector上，不过selector是非阻塞的，
				// 所以也能从侧面证明NIO的非阻塞性。
				if (selector.select(TIMEOUT) == 0) {
					System.out.println("==");
					continue;
				}
//				这个地方实验的时候，两个client一起连接 selector还是只有一个channel，只是不停的切换
//				没有出现一个selector管理多个channel的情况，不知道是不是因为并发量不够的原因。
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				while (iter.hasNext()) {
					SelectionKey key = iter.next();
					if (cha1 == null) {
						cha1 = (ServerSocketChannel) key.channel();
					}
					System.out.println(cha1.equals(key.channel()));
					// selector 的意义在于selector可以获取信道的状态，例如一下几种，只有可读的或者可写的时候
					// 才会进行操作，之前的io是只要可连接的就会阻塞在那里等。
					if (key.isAcceptable()) {
						handleAccept(key);
					}
					if (key.isReadable()) {
						handleRead(key);
					}
					if (key.isWritable() && key.isValid()) {
						handleWrite(key);
					}
					if (key.isConnectable()) {
						System.out.println("isConnectable = true");
					}
					iter.remove();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (selector != null) {
					selector.close();
				}
				if (ssc != null) {
					ssc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
