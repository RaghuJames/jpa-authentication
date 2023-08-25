package org.security;

import org.security.model.Authorities;
import org.security.model.User;
import org.security.repository.UserNameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.server.WebFilter;

/**
 * Implemented custom JPA authentication using Spring Boot 3 and H2 database
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class,args);
    }

    /**
     * Insert user details to H2 database
     * @param userNameRepository
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(UserNameRepository userNameRepository){
        return (a)->{
            Authorities authorities = new Authorities("ROLE_USER");
            User user = new User("raghu","12345",0);
            authorities.setUser(user);
            user.setAuthorities(authorities);

            Authorities authorities1 = new Authorities("ROLE_ADMIN");
            User user1 = new User("admin","12345",0);
            authorities1.setUser(user1);
            user1.setAuthorities(authorities1);


            userNameRepository.save(user);
            userNameRepository.save(user1);
            System.out.println("commandLineRunner worked");
        };
    }
}
