package br.jus.trece.regulusApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests (authorizeRequests -> authorizeRequests.requestMatchers("/api/**").permitAll());
                                                                          //.requestMatchers("/api/autenticar").permitAll()
                                                                          //.requestMatchers("/api/zonas").permitAll());
            /*.requestMatchers("/api/foos/**").authenticated()
            .requestMatchers("/api/async/**").permitAll()
            .requestMatchers("/api/admin/**").hasRole("ADMIN"))*/
            
        return http.build();
    }
    
}
