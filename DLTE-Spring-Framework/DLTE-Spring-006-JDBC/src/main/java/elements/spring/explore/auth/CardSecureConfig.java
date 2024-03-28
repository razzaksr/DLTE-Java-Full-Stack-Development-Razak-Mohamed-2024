package elements.spring.explore.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class CardSecureConfig {

    @Autowired
    MyBankOfficialsService service;

    AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails1= User.withDefaultPasswordEncoder().username("elroy").password("monis").roles("admin").build();
//        UserDetails userDetails2= User.withDefaultPasswordEncoder().username("akshira").password("hegde").roles("manager").build();
//        List<UserDetails> userDetailsList= Stream.of(userDetails1,userDetails2).collect(Collectors.toList());
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.formLogin();
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().antMatchers("/profile/register").permitAll();

        httpSecurity.authorizeRequests().antMatchers("/credit/view").hasAuthority("manager");
        httpSecurity.authorizeRequests().antMatchers("/credit/one/*").hasAnyAuthority("cashier","clerk");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST).hasAuthority("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE).hasAuthority("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT).hasAuthority("manager");

        httpSecurity.authorizeRequests().anyRequest().authenticated();


        AuthenticationManagerBuilder builder=httpSecurity.
                getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}
