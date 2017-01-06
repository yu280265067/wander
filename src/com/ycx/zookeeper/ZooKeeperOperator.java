package com.ycx.zookeeper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperOperator extends AbstractZooKeeper {
    
    private static Log log = LogFactory.getLog(ZooKeeperOperator.class.getName());  
  
    /** 
     *  
     *<b>function:</b>创建持久态的znode,比支持多层创建.比如在创建/parent/child的情况下,无/parent.无法通过 
     *@author cuiran 
     *@createDate 2013-01-16 15:08:38 
     *@param path 
     *@param data 
     *@throws KeeperException 
     *@throws InterruptedException 
     */  
    public void create(String path,byte[] data)throws KeeperException, InterruptedException{  
        /** 
         * 此处采用的是CreateMode是PERSISTENT  表示The znode will not be automatically deleted upon client's disconnect. 
         * EPHEMERAL 表示The znode will be deleted upon the client's disconnect. 
         */   
        this.zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);  
    }  
    /** 
     *  
     *<b>function:</b>获取节点信息 
     *@author cuiran 
     *@createDate 2013-01-16 15:17:22 
     *@param path 
     *@throws KeeperException 
     *@throws InterruptedException 
     */  
    public void getChild(String path) throws KeeperException, InterruptedException{     
        try{  
            List<String> list=this.zooKeeper.getChildren(path, false);  
            if(list.isEmpty()){  
                log.debug(path+"中没有节点");  
            }else{  
                log.debug(path+"中存在节点");  
                for(String child:list){  
                    log.debug("节点为："+child);  
                }  
            }  
        }catch (KeeperException.NoNodeException e) {  
            // TODO: handle exception  
             throw e;     
  
        }  
    }  
      
    public byte[] getData(String path) throws KeeperException, InterruptedException {     
        return  this.zooKeeper.getData(path, false,null);     
    }    
      
     public static void main1(String[] args) {
         try {     
                ZooKeeperOperator zkoperator             = new ZooKeeperOperator();     
                zkoperator.connect("101.200.91.48:4180");  
                  
                byte[] data = new byte[]{'a','b','c','d'};     
                     
//              zkoperator.create("/root",null);     
//              System.out.println(Arrays.toString(zkoperator.getData("/root")));     
//                   
//              zkoperator.create("/root/child1",data);     
//              System.out.println(Arrays.toString(zkoperator.getData("/root/child1")));     
//                   
//              zkoperator.create("/root/child2",data);     
//              System.out.println(Arrays.toString(zkoperator.getData("/root/child2")));     
                     
               /* String zktest="ZooKeeper的Java API测试";  
                zkoperator.create("/root/child3", zktest.getBytes());  
                log.debug("获取设置的信息："+new String(zkoperator.getData("/root/child3")));  
                  
                System.out.println("节点孩子信息:");     
                zkoperator.getChild("/root");   */  
                  
                  
                  
            } catch (Exception e) {     
                e.printStackTrace();     
            }     
  
    }  
     
     
     public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
    	// 创建一个与服务器的连接 需要(服务端的 ip+端口号)(session过期时间)(Watcher监听注册) 
         ZooKeeper zk = new ZooKeeper("101.200.91.48:4180", 
                30000, new Watcher() { 
                    // 监控所有被触发的事件
                    public void process(WatchedEvent event) {
                        // TODO Auto-generated method stub
                        System.out.println("已经触发了" + event.getType() + "事件！"); 
                    } 
          });

         // 创建一个目录节点
         /**
          * CreateMode:
          * 	PERSISTENT (持续的，相对于EPHEMERAL，不会随着client的断开而消失)
          *		PERSISTENT_SEQUENTIAL（持久的且带顺序的）
          *		EPHEMERAL (短暂的，生命周期依赖于client session)
          *		EPHEMERAL_SEQUENTIAL  (短暂的，带顺序的)
          */
         String serverData = "101.200.91.48:8080";
         zk.create("/wifi", serverData.getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
         // 创建一个子目录节点
         zk.create("/wifi/one", serverData.getBytes(),Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
         System.out.println(new String(zk.getData("/testRootPath",false,null))); 
         
         // 取出子目录节点列表
         System.out.println(zk.getChildren("/testRootPath",true)); 	
         
         // 创建另外一个子目录节点
         //zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 		 
         System.out.println(zk.getChildren("/testRootPath",true)); 	
         
        // 修改子目录节点数据
         /*zk.setData("/testRootPath/testChildPathOne","hahahahaha".getBytes(),-1); 	 		 
         byte[] datas = zk.getData("/testRootPath/testChildPathOne", true, null);
         String str = new String(datas,"utf-8");
         System.out.println(str); 	*/
         
         //删除整个子目录   -1代表version版本号，-1是删除所有版本
        // zk.delete("/testRootPath/testChildPathOne", -1);	 
         System.out.println(zk.getChildren("/testRootPath",true)); 
        // System.out.println(str);
         
        
         
         
	}
}  
