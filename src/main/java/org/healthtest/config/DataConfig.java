package org.healthtest.config;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.jdbc.*;
import org.springframework.security.provisioning.*;

@Configuration
@PropertySource("classpath:util.properties")
@PropertySource("classpath:auth.properties")
public class DataConfig {
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    // NON FOR PRODUCTION!!!
    // ONLY EXAMPLE
//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("admin").password("admin").roles("ADMIN").build());
//        manager.createUser(users.username("user").password("user").roles("USER").build());
//        return manager;
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl dao = new JdbcDaoImpl();
        dao.setDataSource(dataSource());
        dao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        dao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return dao;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
