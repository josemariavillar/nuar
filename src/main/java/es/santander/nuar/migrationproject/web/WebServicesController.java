package es.santander.nuar.migrationproject.web;

import es.santander.nuar.util.interceptorslibrary.EmptyInterceptor;
import es.santander.nuar.util.interceptorslibrary.InterceptorsFactory;
import es.santander.nuar.util.interceptorslibrary.service.EndPointSelectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservices")
public class WebServicesController {

	@Autowired
	EndPointSelectorService endPointService;

	final String USER_NAME_VALID_VALUE = "defaultValue";

	String var1 = InterceptorsFactory.USER_NAME_VALID_VALUE;

	@GetMapping("/empty-interceptor")
	public EmptyInterceptor getEmptyInterceptor() {
		return new EmptyInterceptor();
	}

	@GetMapping("/marco-channel")
	public String getMarcoChannel() {
		return endPointService.getMarcoChannel();
	}

	private String getUserNameValidValue() {
		return InterceptorsFactory.USER_NAME_VALID_VALUE;
	}

}
