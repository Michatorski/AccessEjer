package iesfm.org;

import iesfm.org.dao.DepartmentDAO;
import iesfm.org.dao.EmployeeDAO;
import iesfm.org.program.DepartmentProgram;
import iesfm.org.program.EmployeeProgram;
import iesfm.org.reader.DepartamentoReader;
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
public class CompanyConfiguration {

    @Bean
    public MainMenu mainMenu (Scanner scanner, DepartmentProgram departmentProgram, EmployeeProgram employeeProgram){
        return new MainMenu(scanner, departmentProgram, employeeProgram);
    }

    @Bean
    public EmployeeProgram employeeProgram(EmployeeDAO employeeDAO){
        return  new EmployeeProgram(employeeDAO);
    }

    @Bean
    public EmployeeDAO employeeDAO(NamedParameterJdbcTemplate jdbc){
        return new EmployeeDAO(jdbc);
    }

    @Bean
    public DepartmentProgram departmentProgram(DepartamentoReader departamentoReader, DepartmentDAO departmentDAO){
        return new DepartmentProgram( departamentoReader,departmentDAO);
    }

    @Bean
    public DepartmentDAO departmentDAO(NamedParameterJdbcTemplate jdbc){
        return new DepartmentDAO(jdbc);
    }

    @Bean
    public DepartamentoReader departamentoReader (Scanner scanner){
        return new DepartamentoReader(scanner);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource mysqlDataSource(
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
    public Scanner scanner (){
        return new Scanner(System.in);
    }
}
