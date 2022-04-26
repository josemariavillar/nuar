package es.santander.nuar.migrationproject.web;

import es.santander.nuar.util.common.omnichannel.ContactPoint;
import es.santander.nuar.util.common.security.auth.SantanderUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token-management")
public class TokenManagementController {

	@GetMapping(value = "/get-jwt-token")
	public String getJWTToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String token = ((SantanderUserDetails) auth.getPrincipal()).getJwtToken();

		if (auth != null && auth.getPrincipal() instanceof SantanderUserDetails) {
			SantanderUserDetails santanderUD = (SantanderUserDetails) auth.getPrincipal();
			return santanderUD.getJwtToken();
		}
		return "";
	}

	@GetMapping(value = "/get-ocjwt-token")
	public String getOCJWTToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getPrincipal() instanceof SantanderUserDetails) {
			SantanderUserDetails santanderUD = (SantanderUserDetails) auth.getPrincipal();
			return santanderUD.getOCJwtToken();
		}
		return "";
	}

	@GetMapping(value = "/get-corp-token")
	public String getCorpToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getPrincipal() instanceof SantanderUserDetails) {
			SantanderUserDetails userDetails = (SantanderUserDetails) auth.getPrincipal();
			return userDetails.getCorpToken();
		}
		return "";
	}

	@GetMapping(value = "/get-contact-point")
	public ContactPoint getContactPoint() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getPrincipal() instanceof SantanderUserDetails) {
			SantanderUserDetails userDetails = (SantanderUserDetails) auth.getPrincipal();
			return userDetails.getContactPoint();
		}
		return null;
	}

	@GetMapping(value = "/get-was-called-with-token")
	public int getWasCalledWithToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getPrincipal() instanceof SantanderUserDetails) {
			SantanderUserDetails userDetails = (SantanderUserDetails) auth.getPrincipal();
			return userDetails.getWasCalledWithToken();
		}
		return 0;
	}

}