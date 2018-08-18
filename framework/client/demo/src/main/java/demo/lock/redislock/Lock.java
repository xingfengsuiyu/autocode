package demo.lock.redislock;

/**
 * 分布式全局锁--被枷锁对象
 *
 * @author zc
 * @create 2018-07-22 15:53
 **/
public class Lock {

	private String name;
	private String value;

	public Lock(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
