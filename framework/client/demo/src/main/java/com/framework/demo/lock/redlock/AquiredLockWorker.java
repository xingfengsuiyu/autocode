package com.framework.demo.lock.redlock;

/**   
 * @author zc  
 * @date 2018/7/22 16:19  
 * @description 获取锁后需要处理的逻辑
 */  
public interface AquiredLockWorker<T> {
	T invokeAfterLockAquire() throws Exception;
}
