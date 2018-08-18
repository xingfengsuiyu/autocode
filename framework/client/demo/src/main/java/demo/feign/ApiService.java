package demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * feign接口测试
 *
 * @author zc
 * @create 2018-08-15 20:38
 **/
@FeignClient(value = "user",fallback = ApiServiceError.class)
public interface ApiService {

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	String index();
}