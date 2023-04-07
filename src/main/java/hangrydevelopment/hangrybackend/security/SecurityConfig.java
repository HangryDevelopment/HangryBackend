// package hangrydevelopment.hangrybackend.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// @Autowired
// private JwtAuthenticationFilter jwtAuthenticationFilter;

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable()
// .authorizeRequests()
// .antMatchers("/api/auth/**").permitAll()
// .anyRequest().authenticated()
// .and()
// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// http.addFilterBefore(jwtAuthenticationFilter,
// UsernamePasswordAuthenticationFilter.class);
// }

// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder
// authenticationManagerBuilder) throws Exception {
// authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// @Override
// public AuthenticationManager authenticationManagerBean() throws Exception {
// return super.authenticationManagerBean();
// }
// }
