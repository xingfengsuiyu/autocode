package demo;

import org.jsondoc.core.annotation.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zc
 * @create 2018-08-15 21:29
 **/
@RestController
public class HelloWorldController {

	@Autowired
	private ApiService apiService;

	@RequestMapping("/hello")
	public String hello() {
		return	apiService.index();
	}
}
