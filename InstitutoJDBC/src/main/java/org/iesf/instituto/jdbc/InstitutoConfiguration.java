package org.iesf.instituto.jdbc;

import org.iesf.instituto.jdbc.dao.GroupDAO;
import org.iesf.instituto.jdbc.dao.StudentDAO;
import org.iesf.instituto.jdbc.dao.TitleDAO;
import org.iesf.instituto.jdbc.program.GroupProgram;
import org.iesf.instituto.jdbc.program.StudentProgram;
import org.iesf.instituto.jdbc.program.TitleProgram;
import org.iesf.instituto.jdbc.scannerRead.GroupScannerReader;
import org.iesf.instituto.jdbc.scannerRead.StudentScannerReader;
import org.iesf.instituto.jdbc.scannerRead.TitleScannerReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class InstitutoConfiguration {
    @Bean
    public MainMenu mainMenu (Scanner scanner, TitleProgram titleProgram, StudentProgram studentProgram, GroupProgram groupProgram){
        return new MainMenu(scanner, titleProgram, studentProgram, groupProgram);
    }

    @Bean
    public GroupProgram groupProgram (GroupScannerReader groupScannerReader, GroupDAO groupDAO){
        return new GroupProgram(groupScannerReader, groupDAO);
    }

    @Bean
    public GroupDAO groupDAO (NamedParameterJdbcTemplate jdbc){
        return new GroupDAO(jdbc);
    }

    @Bean
    public GroupScannerReader groupScannerReader(Scanner scanner){
        return new GroupScannerReader(scanner);
    }

    @Bean
    public StudentProgram studentProgram(StudentScannerReader studentScannerReader, StudentDAO studentDAO){
        return new StudentProgram(studentScannerReader, studentDAO);
    }

    @Bean
    public StudentScannerReader studentScannerReader (Scanner scanner){
        return new StudentScannerReader(scanner);
    }

    @Bean
    public StudentDAO studentDAO (NamedParameterJdbcTemplate jdbc){
        return new StudentDAO(jdbc);
    }


    @Bean
    public TitleProgram titleProgram (TitleScannerReader titleScannerReader, TitleDAO titleDAO){
        return  new TitleProgram(titleScannerReader, titleDAO);
    }

   @Bean
    public TitleDAO titleDAO(NamedParameterJdbcTemplate jdbc){
        return new TitleDAO(jdbc);
    }

    @Bean
    public TitleScannerReader titleScannerReader(Scanner scanner){
        return new TitleScannerReader(scanner);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource){
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

    @Bean
    public Scanner scanner(){return new Scanner(System.in);}
}
