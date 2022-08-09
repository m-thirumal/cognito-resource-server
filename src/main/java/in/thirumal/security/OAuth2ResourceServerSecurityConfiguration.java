package in.thirumal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 * @author Thirumal
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class OAuth2ResourceServerSecurityConfiguration {//extends ResourceServerConfigurerAdapter {

//	private final ResourceServerProperties resource;
//
//	public OAuth2ResourceServerSecurityConfiguration(ResourceServerProperties resource) {
//		this.resource = resource;
//	}
//	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
        http.cors().and().csrf().disable()
                .authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                        .anyRequest().authenticated())
                .oauth2ResourceServer().jwt();
        return http.build();
    }
}
