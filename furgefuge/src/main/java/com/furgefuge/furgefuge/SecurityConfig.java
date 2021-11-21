
package com.furgefuge.furgefuge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
        //Roleok hozzáadása
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER", "REPORT");
        auth.inMemoryAuthentication().withUser("report").password(passwordEncoder().encode("report")).roles("REPORT");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pw")).roles("USER", "REPORT","ADMIN");
        
    }
    
    protected void configure(HttpSecurity http)throws Exception {
        http.authorizeRequests()
            .antMatchers("/add", "/update", "/delete", "/addgarden", "/updategarden", "/deletegarden", "/addOpenwork", "/updateOpenwork", "/deleteOpenwork").access("hasRole('USER')")
            .antMatchers("/addusers", "/getallusers", "/updateusers", "/deleteusers", "/getuseronname", "/getuserbyidentitycard", "/findbystatus").access("hasRole('ADMIN')")
            .antMatchers("/getall", "/getbyname", "/getallgarden", "/getgardenbyname", "/getallOpenwork", "/getopenwork", "/findbygardencode").access("hasRole('REPORT')")
            .and().formLogin().loginPage("/login").permitAll();
    }
}
