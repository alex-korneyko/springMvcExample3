package ua.in.dris4ecoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import ua.in.dris4ecoder.Model.Services.UserRegistrationService;
import ua.in.dris4ecoder.Model.Services.UserRegistrationServiceImpl;
import ua.in.dris4ecoder.Model.dao.Dao;

import javax.sql.DataSource;

/**
 * Created by Alex Korneyko on 12.10.2016 11:01.
 */
@Configuration
//@ComponentScan("ua.in.dris4ecoder")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, JdbcDaoImpl jdbcDao) throws Exception {

        auth.userDetailsService(jdbcDao);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/adminPage").hasRole("ADMIN")
                .antMatchers("/userPage").hasRole("USER")
                .and().formLogin().loginPage("/customLoginPage").successForwardUrl("/")
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/")
                .and().rememberMe().rememberMeParameter("rememberMe")
                .and().csrf().disable();
    }


    @Bean
    JdbcDaoImpl jdbcDao (DataSource dataSource) {

        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setEnableGroups(true);
        jdbcDao.setEnableAuthorities(false);
        jdbcDao.setDataSource(dataSource);

        return jdbcDao;
    }
}
