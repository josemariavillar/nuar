package es.santander.nuar.migrationproject.web;

import es.santander.nuar.util.common.annotation.NuarQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplateAux;

	@Autowired
	@NuarQualifier
	RestTemplate nuarRestTemplate;

	@GetMapping(value = "/get-resttemplate-interceptors")
	public List<ClientHttpRequestInterceptor> restTemplateInterceptors() {
		return restTemplateAux.getInterceptors();
	}

	@GetMapping(value = "/get-interceptors")
	public List<ClientHttpRequestInterceptor> restTemplateInterceptors(RestTemplate restTemp) {
		return restTemp.getInterceptors();
	}

	@GetMapping(value = "/get-accounts-interceptors")
	public List<ClientHttpRequestInterceptor> restTemplateQualifierInterceptors(
			@Qualifier("accounts") RestTemplate restTemplateCustomCall) {
		return restTemplateCustomCall.getInterceptors();
	}

	@Bean
	private RestTemplate getNewRestTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		factory.setConnectionRequestTimeout(5000);
		return new RestTemplate(factory);
	}

	@Bean
	@NuarQualifier
	private RestTemplate getNuarRestTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		factory.setConnectionRequestTimeout(5000);
		return new RestTemplate(factory);
	}

}