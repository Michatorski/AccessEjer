package iesfm.org.dao;

import iesfm.org.Department;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAO {
    private final static String SELECT_DEPARTMENT = "SELECT * FROM Department";

    private final static String INSERT_DEPARTMENT = "INSERT INTO Department" +
            "(name, " +
            "description " +
            ") " +
            "VALUES(" +
            "  :name," +
            "  :description" +
            ")";

    private NamedParameterJdbcTemplate jdbc;

    public DepartmentDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert (Department department){
        Map<String, Object> params = new HashMap<>();
        params.put("name", department.getName());
        params.put("description", department.getDescription());
        jdbc.update(INSERT_DEPARTMENT, params);
    }

    public List<Department> list(){
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_DEPARTMENT, params,
                (rs, rowNum) -> new Department(
                        rs.getString("name"),
                        rs.getString("description")
                ));
    }
}
