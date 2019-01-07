package com.example.jwt.demo.configuration;



import com.example.jwt.demo.jwt.JwtTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@ComponentScan("com.example.jwt.demo")
@Order(3)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    private JwtAuthenticationConfig config;
    private String prfix = "goviapi/v1";

    @Bean
    public JwtAuthenticationConfig jwtConfig() {
        return new JwtAuthenticationConfig();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().disable()
                .csrf().disable()
                .logout().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .anonymous()
                .and()
                .exceptionHandling().authenticationEntryPoint(
                (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .addFilterAfter(new JwtTokenAuthenticationFilter(config),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(config.getUrl()).permitAll()
                .antMatchers("/mobile/login").permitAll()
                .antMatchers("/mobile/getaccesstoken").permitAll()
                .antMatchers("/mobile/users/**").permitAll()
                .antMatchers("users/**").hasRole("Farmer")
                .antMatchers("check/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/reports/**").hasRole("Admin")
                .antMatchers("/crop_categories/**").hasRole("Admin")
                .antMatchers("/agent/**").hasRole("Admin")
                .antMatchers("/content/**").hasRole("Admin")
                .antMatchers("/content_details/**").hasRole("Admin")
                .antMatchers("/crop/save").hasRole("Admin")
                .antMatchers("/crop/get-all-crops").hasRole("Admin")
/*                .antMatchers("/crop/**").hasRole("Admin")
                .antMatchers("/crop/**").hasRole("Farmer")*/
                .antMatchers("/crop/set-prices").hasRole("Admin")
                .antMatchers("/district/**").hasRole("Admin")
                .antMatchers("/parameter/**").hasRole("Admin")
                .antMatchers("/test_number/**").hasRole("Admin")
                .antMatchers("/cms_user/login").permitAll()
                .antMatchers("/cms_user/save").permitAll()
                .antMatchers("/mobile/menu/**").hasRole("Farmer")
                .antMatchers("/mobile/getAccessToken").permitAll()
                .antMatchers("/mobile/version/**").permitAll()
                .antMatchers("/mobile/content/**").hasRole("Farmer")
                .antMatchers("/reports/**").permitAll()
                .antMatchers("/reports/**").permitAll()
                .antMatchers("/uploads/**").permitAll()
                .antMatchers("/mobile/crop-params/**").hasRole("Farmer")
                .anyRequest().authenticated();
    }
}
