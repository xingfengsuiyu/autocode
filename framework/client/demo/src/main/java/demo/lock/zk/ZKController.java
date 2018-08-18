package demo.lock.zk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式锁测试
 *
 * @author zc
 * @create 2018-07-22 17:27
 **/
@RestController
public class ZKController {

	@RequestMapping("zklock")
	public String index()throws Exception{
		DistributedLock lock   = new DistributedLock("localhost:2181","lock");
		lock.lock();
		//共享资源
		if(lock != null){
			System.out.println("执行方法");
			Thread.sleep(5000);
			lock.unlock();
		}
		return "hello world!";
	}
}
