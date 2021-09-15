package org.iesf.instituto.jdbc.dao;

import org.iesf.instituto.jdbc.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAO {
    private final static String SELECT_STUDENT = "SELECT * FROM student";
    private final  static String LIST_STUDENT = "";

    private final static String INSERT_STUDENT = "INSERT INTO student" +
            "(nif, " +
            "student_name,  " +
            "student_surname, " +
            "zipCode, " +
            "address, " +
            "email " +
            ") " +
            "VALUES(" +
            "   :nif," +
            "   :name," +
            "   :surname," +
            "   :zipcode," +
            "   :address," +
            "   :email" +
            ")";

    private final static RowMapper<Student> STUDENT_ROW_MAPPER = (rs, rowNum) -> new Student(
            rs.getString("nif"),
            rs.getString("student_name"),
            rs.getString("student_surname"),
            rs.getInt("zipcode"),
            rs.getString("address"),
            rs.getString("email")
    );
    private NamedParameterJdbcTemplate jdbc;

    public StudentDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insertar(Student student) {

        Map<String, Object> params = new HashMap<>();
        params.put("nif", student.getNif());
        params.put("name", student.getName());
        params.put("surname", student.getSurname());
        params.put("zipcode", student.getZipCode());
        params.put("address", student.getAddress());
        params.put("email", student.getEmail());
        jdbc.update(INSERT_STUDENT, params);

    }

    public List<Student> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_STUDENT,
                params,
               STUDENT_ROW_MAPPER);
    }
}
