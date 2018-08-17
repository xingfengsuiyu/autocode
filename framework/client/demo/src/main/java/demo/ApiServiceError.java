package demo;

import org.springframework.stereotype.Component;

/**
 * @author zc
 * @create 2018-08-15 22:48
 **/
@Component
public class ApiServiceError implements ApiService {
	@Override
	public String index() {
		return "服务发生故障！";
	}
}
