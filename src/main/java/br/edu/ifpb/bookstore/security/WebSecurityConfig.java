package br.edu.ifpb.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.edu.ifpb.bookstore.servico.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/images/**", "/css/**", "/js/**").permitAll()
                .antMatchers(HttpMethod.GET, "/", "/buscaLivro/**", "/detalhesLivro/**").permitAll()
                .antMatchers("/criarConta", "/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll())
                .csrf().disable()
            .logout(logout -> logout.logoutUrl("/logout"));
    }
    
}
