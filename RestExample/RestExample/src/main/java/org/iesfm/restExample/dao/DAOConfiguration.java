package org.iesfm.restExample.dao;

import org.iesfm.restExample.Department;
import org.iesfm.restExample.dao.inmemory.InMemorDepartmentDAO;
import org.iesfm.restExample.dao.jdbc.JDBCDepartmentDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DAOConfiguration {
    @Bean
    public JDBCDepartmentDAO jdbcDepartmentDAO ( NamedParameterJdbcTemplate jdbc){
        return jdbcDepartmentDAO(jdbc);
    }

    @Bean
    public DepartmentDAO departmentDAO(NamedParameterJdbcTemplate jdbc){
        return new JDBCDepartmentDAO( jdbc);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbc(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource mysqlDataSource(
            //placeholder
            @Value("${database.driver}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
