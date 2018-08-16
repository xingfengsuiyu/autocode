package demo;

/**
 * @author zc
 * @create 2018-08-15 22:48
 **/
public class ApiServiceError implements ApiService {
	@Override
	public String index() {
		return "服务发生故障！";
	}
}
