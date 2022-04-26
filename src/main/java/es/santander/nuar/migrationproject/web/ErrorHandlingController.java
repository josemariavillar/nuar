package es.santander.nuar.migrationproject.web;

import es.santander.nuar.util.common.exceptions.GenericNuarException;
import es.santander.nuar.util.common.exceptions.NuarExceptionCode;
import es.santander.nuar.util.exceptions.controller.GlobalNuarExceptionHandlerController;
import es.santander.nuar.util.exceptions.exception.BadRequestNuarException;
import es.santander.nuar.util.exceptions.exception.ConflictNuarException;
import es.santander.nuar.util.exceptions.exception.ForbiddenNuarException;
import es.santander.nuar.util.exceptions.exception.HttpBaseNuarException;
import es.santander.nuar.util.exceptions.exception.InternalServerErrorNuarException;
import es.santander.nuar.util.exceptions.exception.NotFoundNuarException;
import es.santander.nuar.util.exceptions.exception.UnauthorizedNuarException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error-handling")
public class ErrorHandlingController {

	GlobalNuarExceptionHandlerController globalNuarExceptionHandlerController;

	@GetMapping(value = "/badrequest-exception")
	public ResponseEntity<String> badRequestException() {
		throw new BadRequestNuarException("error_name");
	}

	@GetMapping(value = "/conflict-exception")
	public ResponseEntity<String> throwConflictException() {
		throw new ConflictNuarException("error_name", "message_exception");
	}

	@GetMapping(value = "/forbidden-exception")
	public ResponseEntity<String> throwForbiddenException() {
		throw new ForbiddenNuarException("error_name", "message_exception");
	}

	@GetMapping(value = "/httpbase-exception")
	public ResponseEntity<String> throwHttpBaseException() {
		throw new HttpBaseNuarException("error_name", HttpStatus.BAD_REQUEST, "short message", "detail message");
	}

	@GetMapping(value = "/internalserver-exception")
	public ResponseEntity<String> throwInternalServerException() {
		throw new InternalServerErrorNuarException("error_name", "message_exception");
	}

	@GetMapping(value = "/notfound-exception")
	public ResponseEntity<String> throwNotFoundException() {
		throw new NotFoundNuarException("error_name", "message_exception");
	}

	@GetMapping(value = "/unauthorized-exception")
	public ResponseEntity<String> throwUnauthorizedException() {
		throw new UnauthorizedNuarException("error_name", "message_exception");
	}

	@GetMapping(value = "/generic-exception")
	public ResponseEntity<String> throwGenericException(Exception exception) {
		throw new GenericNuarException(exception);
	}

	@GetMapping(value = "/get-internalcode")
	public Integer getInternalCode() {
		return NuarExceptionCode.STS_CONVERSION_FAILED.getCode();
	}

}
