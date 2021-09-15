package iesfm.org.dao;

import iesfm.org.Employee;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {

    private final static String SELECT_EMPLOYEE_BY_DEPARTMENT_NAME = "SELECT * FROM Employee WHERE department_name = :department_name";

    private NamedParameterJdbcTemplate jdbc;

    public EmployeeDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Employee> listEmployeeByDepartment(String departmentName){
        Map<String, Object> params = new HashMap<>();
        params.put("department_name", departmentName);
        return jdbc.query(SELECT_EMPLOYEE_BY_DEPARTMENT_NAME,
                params,
                (rs, rowNum) -> new Employee(
                        rs.getString("nif"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("role"),
                        rs.getString("department_name")
                ));
    }
}

