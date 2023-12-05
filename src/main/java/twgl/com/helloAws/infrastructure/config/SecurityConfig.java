package twgl.com.helloAws.infrastructure.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import twgl.com.helloAws.domain.services.security.JwtConfigurer;
import twgl.com.helloAws.domain.services.security.JwtTokenProvider;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

        @Autowired
        private JwtTokenProvider tokenProvider;

        @Bean
        PasswordEncoder passwordEncoder() {

                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
                return bCryptPasswordEncoder;
        }

        @Bean
        AuthenticationManager authenticationManagerBean(
                        AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .httpBasic(basic -> basic.disable())
                                .csrf(AbstractHttpConfigurer::disable)
                                .sessionManagement(
                                                session -> session
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(
                                                authorizeHttpRequests -> authorizeHttpRequests
                                                                .requestMatchers(
                                                                                "/auth/signin",
                                                                                "/auth/refresh/**",
                                                                                "/swagger-ui/**",
                                                                                "/v3/api-docs/**",
                                                                                "/api/v1/hello/**",
                                                                                "/api/v1/auth/**",
                                                                                "/actuator/**")
                                                                .permitAll()
                                                                .requestMatchers("/api/**").authenticated()
                                                                .requestMatchers("/users").denyAll())
                                .apply(new JwtConfigurer(tokenProvider));

                return http.build();

        }
}