package es.santander.nuar.migrationproject.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mapper")
public class MapperController {

	ObjectMapper objectMapper;

	@GetMapping(value = "/print")
	public String printObjectMapper() {
		objectMapper = new ObjectMapper();
		return objectMapper.toString();
	}

	@GetMapping(value = "/print-o")
	public String printObjectMapperParam(ObjectMapper o) {
		objectMapper = o;
		return objectMapper.toString();
	}

	@GetMapping(value = "/print-new-o")
	public String printObjectMapperParam() {
		ObjectMapper o = new ObjectMapper();
		return o.toString();
	}

}