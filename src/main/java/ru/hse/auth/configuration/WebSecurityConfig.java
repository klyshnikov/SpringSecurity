package ru.hse.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/user").permitAll())
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/admin").hasRole("ADMIN"))
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
    }

    @Bean
    public UserDetailsManager getUserDetailsManager(PasswordEncoder passwordEncoder) {
        var admin =
                User.builder()
                        .username("admin")
                        .roles("ADMIN")
                        .password(passwordEncoder.encode("admin"))
                        .build();

        return new InMemoryUserDetailsManager(admin);
    }
}
//userdetailservice