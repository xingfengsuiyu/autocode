package demo.lock.redislock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zc
 * @create 2018-07-22 15:59
 **/
@RestController
public class RedisLockController {


	@Autowired
	private DistributedLockHandler distributedLockHandler;

	@RequestMapping("distribute")
	public String index(){
		Lock lock=new Lock("lynn","min");
		if(distributedLockHandler.tryLock(lock)){
			try {
				//为了演示锁的效果，这里睡眠5000毫秒
				System.out.println("执行方法");
				Thread.sleep(5000);
			}catch (Exception e){
				e.printStackTrace();
			}
			distributedLockHandler.releaseLock(lock);
		}
		return "hello world!";
	}
}
