// 2. Http Basic Authentication
// Configuration file for security

package com.example.security1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(authorizeRequests ->
              authorizeRequests.anyRequest().authenticated()  );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}


/*
--> NOTES::
- @EnableWebSecurity: Spring Security ko application me enable + customize karne ke liye use hota hai, taaki custom security configuration (SecurityFilterChain, authentication rules, filters, etc.) apply ho sake.
- authorizeRequests.anyRequest().authenticated() :: Koi bhi request ko authenticate kardo
- http.httpBasic(Customizer.withDefaults()) :: http basic authentication ko enable kar rha hu with defaults
- Basic auth jab hit kroge postman mei to choose Basic Auth as Authorization option
- Us ans Pw set in properties file. Inspect krne par : Application mei cookies ke andar JSessionId show hoga
- We can create multiple 'users' using InMemory Authentication. InMemory Authentication means users code mei exist krega DB mei nhi
- Multi Users ke liye comment username and PW in properties file
 */
