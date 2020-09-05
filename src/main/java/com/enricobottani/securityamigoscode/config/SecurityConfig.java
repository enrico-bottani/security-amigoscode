package com.enricobottani.securityamigoscode.config;

import com.enricobottani.securityamigoscode.secuirty.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.enricobottani.securityamigoscode.secuirty.UserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/index.html","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("anna@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .roles(STUDENT.name()) // ROLE_STUDENT
                .build();
        UserDetails lindaUser = User.builder()
                .username("linda@supsi.com")
                .password(passwordEncoder.encode("1234"))
                .roles(UserRole.ADMIN.name()) // ROLE_ADMIN
                .build();
        UserDetails tomUser = User.builder()
                .username("tom@trainee.supsi.com")
                .password(passwordEncoder.encode("1234"))
                .roles(UserRole.ADMIN_TRAINEE.name()) // ROLE_ADMIN_TRAINEE
                .build();
        return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
    }
}
