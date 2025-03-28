package ru.hollow.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import ru.hollow.security.properties.SimpleBasicProperty;

@Configuration
public class SecurityConf {

    private final SimpleBasicProperty property;

    @Autowired
    public SecurityConf(SimpleBasicProperty property) {
        this.property = property;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session  // конфигурация сессии. добавляет куки в которой хранится securitycontext
//                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                        .sessionFixation().migrateSession()
//                        .maximumSessions(1)
//                        .maxSessionsPreventsLogin(false)
//                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(property.getUrlForAdmins()).hasRole("ADMIN")
                                .requestMatchers(property.getUrlForUsers()).hasRole("USER")
                                .requestMatchers(property.getOpenUrlPattern()).permitAll()
                                .anyRequest().authenticated()
                ).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
