package org.iesfm.restExample.dao;

import org.iesfm.restExample.dao.inmemory.InMemoryDepartmentDAO;
import org.iesfm.restExample.dao.inmemory.InMemoryEmployeeDAO;
import org.iesfm.restExample.dao.jdbc.JDBCDepartmentDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfiguration {

    @Bean
    public DepartmentDAO departmentDAO() {

//        return new InMemoryDepartmentDAO();
        return new InMemoryDepartmentDAO();
    }

    @Bean
    public EmployeeDAO employeeDAO() {

//        return new InMemoryDepartmentDAO();
        return new InMemoryEmployeeDAO();
    }
}
