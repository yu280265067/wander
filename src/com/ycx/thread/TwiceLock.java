package com.ycx.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwiceLock implements Lock{
	private final Sync sync = new Sync(2);
	private static final class Sync extends AbstractQueuedSynchronizer{
		Sync(int count){
			if(count<=0){
				throw new IllegalArgumentException("mount must larger than zero");
			}
			setState(count);
		}
		public int tryAcquireShared(int reduceCount){
			for(;;){
				int current = getState();
				int newCount = current - reduceCount;
				if(newCount<0||compareAndSetState(current, newCount)){
					return newCount;
				}
			}
		}
		
		public boolean tryReleaseShared(int returnCount){
			for(;;){
				int current = getState();
				int newCount = current + returnCount;
				if(compareAndSetState(current, newCount)){
					return true;
				}
			}
		}
	}
	
	
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquireShared(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public void unlock() {
		// TODO Auto-generated method stub
		sync.releaseShared(1);
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
