package ru.hse.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.hse.auth.repository.UserRepository;

import java.util.ArrayList;

@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((auth) -> auth.requestMatchers("/hello-all"));
        httpSecurity.authorizeHttpRequests((auth) -> auth.requestMatchers("/hello-user").hasRole("USER"));
        httpSecurity.authorizeHttpRequests((auth) -> auth.requestMatchers("/hello-admin").hasRole("ADMIN"));
        return httpSecurity.build();
    }

    @Bean
    public UserRepository getUserRepository(PasswordEncoder passwordEncoder) {
        UserRepository userRepository = new UserRepository();
        userRepository.allUsers = new ArrayList<UserDetails>();
        UserDetails user = User.withUsername("Misha").password(passwordEncoder.encode("Misha")).roles("USER").build();
        UserDetails admin = User.withUsername("Durov").password(passwordEncoder.encode("Durov")).roles("ADMIN").build();
        userRepository.allUsers.add(user);
        userRepository.allUsers.add(admin);
        return userRepository;
    }

    @Bean
    public CustomUserDetailsService getCustomUserDetailsService() {
        return new CustomUserDetailsService();
    }

    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(getCustomUserDetailsService());
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }
}
//userdetailservice