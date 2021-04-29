package com.markthedev.weekly_view.config;

//@Configuration
//@AllArgsConstructor
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private WebSecurityConfiguration webSecurityConfiguration;
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .antMatchers("/sign-up/**", "/sign-in/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(webSecurityConfiguration)
//                .passwordEncoder(bCryptPasswordEncoder());
//    }
//}
