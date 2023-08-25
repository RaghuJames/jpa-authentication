package org.security;


import org.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring security configuration class implemented authentication and authorization
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration  {

    private CustomUserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Registered custom UserDetailsService
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests( (authorize)->{
            authorize.requestMatchers("/admin").hasRole("ADMIN")
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/h2-console/**").permitAll()
                    .anyRequest().authenticated();
        }).userDetailsService(userDetailsService)
                .csrf((httpSecurityCsrfConfigurer ->httpSecurityCsrfConfigurer.disable()))
                .headers((h)->h.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public PasswordEncoder getInstance(){
        return NoOpPasswordEncoder.getInstance();
    }
}
