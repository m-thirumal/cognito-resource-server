package in.thirumal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */

/**
 * @author Thirumal
 *
 */
@RestController
public class HelloController {

	@GetMapping("hello")
	public String hello() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		return "hello";
	}
	
}
