package demo.lock.redlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redlock测试类
 *
 * @author zc
 * @create 2018-07-22 16:38
 **/
@RestController
public class RedLockController {

	@Autowired
	private DistributedLocker distributedLocker;

	@RequestMapping("redlock")
	public String index() throws Exception{
		distributedLocker.lock("test", new AquiredLockWorker<Object>() {

			@Override
			public Object invokeAfterLockAquire() throws Exception {
				try {
					System.out.println("执行方法！");
					Thread.sleep(5000);
				}catch (Exception e){
					e.printStackTrace();
				}
				return null;
			}
			});
		return "hello, world";
	}
}
