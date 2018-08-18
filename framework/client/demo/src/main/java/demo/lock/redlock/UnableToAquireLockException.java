package demo.lock.redlock;

/**
 * 异常类
 *
 * @author zc
 * @create 2018-07-22 16:22
 **/
public class UnableToAquireLockException extends  RuntimeException {
	public UnableToAquireLockException() {
	}

	public UnableToAquireLockException(String message) {
		super(message);
	}

	public UnableToAquireLockException(String message, Throwable cause) {
		super(message, cause);
	}
}
