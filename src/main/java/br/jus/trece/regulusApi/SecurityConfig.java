package br.jus.trece.regulusApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.jus.trece.regulusApi.bean.SessaoBean;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*@Autowired
    SessaoBean sessaoBean;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = null;
        if (sessaoBean.getUsuario() != null) {
            user = User.withUsername("user")
            .password(encoder().encode("userPass"))
            .roles("ADMIN")
            .authorities("ADMIN")
            .build();    
        } else {
            user = User.withUsername("anonymous")
            .password(encoder().encode("userPass"))
            .roles("USER")
            .build();
        }
        
        return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }*/

/*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests (authorizeRequests -> authorizeRequests
            .requestMatchers(HttpMethod.POST, "/api/autenticar").permitAll()
            .anyRequest().authenticated());
            //.requestMatchers("/api/zonas").hasRole("ADMIN")
            
            //.csrf(AbstractHttpConfigurer::disable);
                                                                        
                                                                          //requestMatchers("/api/autenticar").permitAll()
                                                                          //.requestMatchers("/api/zonas").hasAuthority("ADMIN"));
                                                                          //.requestMatchers("/api/zonas").permitAll());
                                                                          //.requestMatchers("/api/zonas").permitAll());
            
            
        return http.build();
    }*/

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/api/**").permitAll()
                //.requestMatchers("/api/zonas").hasAuthority("ADMIN")
                .requestMatchers("/teste.html").permitAll()
                .requestMatchers("/**").permitAll()
				//.anyRequest().authenticated()
			)
            .cors(
                (cors) -> cors
				.configurationSource(corsConfigurationSource())
            )
            .csrf(AbstractHttpConfigurer::disable)
			.httpBasic(Customizer.withDefaults());
			//.formLogin(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
			.username("user")
			.password("123")
			.roles("ADMIN")
            .authorities("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
	}

    @Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}

    @Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
 
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
        //configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }
    
}
