package org.iesfm.restExample.dao.jdbc;

import org.iesfm.restExample.Department;
import org.iesfm.restExample.dao.DepartmentDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDepartmentDAO implements DepartmentDAO {

    private final static String SELECT_DEPARTMENT = "SELECT * FROM Department";

    private final static String INSERT_DEPARTMENT = "INSERT INTO Department" +
            "(name, " +
            "description " +
            ") " +
            "VALUES(" +
            "  :name," +
            "  :description" +
            ")";

    private final static String DELETE_BY_DEPARTMENT_NAME = "DROP * FROM Department WHERE department_name = :department_name";
    private final static String SELECT_BY_DEPARTMENT_NAME = "SELECT * FROM Department WHERE department_name = :department_name";


    private NamedParameterJdbcTemplate jdbc;

    public JDBCDepartmentDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Department> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_DEPARTMENT, params,
                (rs, rowNum) -> new Department(
                        rs.getString("name"),
                        rs.getString("description")
                ));
    }

    @Override
    public void insert(Department department) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", department.getName());
        params.put("description", department.getDescription());
        jdbc.update(INSERT_DEPARTMENT, params);
    }

    @Override
    public Department get(String departmentName) {
        Map<String, Object> params = new HashMap<>();
        params.put("department_name", departmentName);
        return jdbc.queryForObject(SELECT_BY_DEPARTMENT_NAME,
                params,
                (rs, rowNum) -> new Department(
                        rs.getString("name"),
                        rs.getString("description")
                ));
    }

    @Override
    public void delete(String departmentName) {
        Map<String, Object> params = new HashMap<>();
        params.put("department_name", departmentName);
        jdbc.update(DELETE_BY_DEPARTMENT_NAME, params);

    }
}
