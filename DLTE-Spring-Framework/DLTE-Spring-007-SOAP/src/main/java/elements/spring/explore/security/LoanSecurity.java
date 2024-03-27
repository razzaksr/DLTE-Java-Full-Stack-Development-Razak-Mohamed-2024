package elements.spring.explore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class LoanSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails1= User.withDefaultPasswordEncoder().username("elroy").password("monis").roles("admin").build();
        UserDetails userDetails2= User.withDefaultPasswordEncoder().username("akshira").password("hegde").roles("manager").build();
        List<UserDetails> userDetailsList=Stream.of(userDetails1,userDetails2).collect(Collectors.toList());
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.formLogin();
        return httpSecurity.build();
    }
}
