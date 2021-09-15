package org.iesf.instituto.jdbc.dao;

import org.iesf.instituto.jdbc.Title;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TitleDAO {
    private static Scanner scan;

    private final static String SELECT_TITLE = "SELECT * FROM title";

    private final static String SELECT_FAMILY = "SELECT DISTINCT family FROM title";
    private final static String SELECT_TITLE_BY_FAMILY = "SELECT * FROM title WHERE family = :family ";
    private final static String SELECT_TITLE_BY_NAME = "SELECT * FROM title WHERE title_name = :title_name ";
    private final static RowMapper<Title> TITLE_ROW_MAPPER =
            (rs, rowNum) -> new Title(
                    rs.getInt("title_id"),
                    rs.getString("title_name"),
                    rs.getString("title_level"),
                    rs.getString("family"),
                    rs.getString("title_description")
            );

    private final static String INSERT_TITLE = "INSERT INTO title" +
            "(title_name, " +
            "title_level,  " +
            "family, " +
            "title_description" +
            ") " +
            "VALUES(" +
            "   :name," +
            "   :level," +
            "   :family," +
            "   :description" +
            ")";

    private NamedParameterJdbcTemplate jdbc;

    public TitleDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insertar(Title title) {

        Map<String, Object> params = new HashMap<>();
        params.put("name", title.getName());
        params.put("level", title.getLevel());
        params.put("family", title.getFamily());
        params.put("description", title.getDescription());
        jdbc.update(INSERT_TITLE, params);

    }

    public List<Title> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_TITLE,
                params,
                TITLE_ROW_MAPPER);
    }

    public List<String> listFamily() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(SELECT_FAMILY,
                params,
                (rs, rowNum) ->
                        rs.getString("family")
        );
    }

    public List<Title> listTitleByFamily(String family) {
        Map<String, Object> params = new HashMap<>();
        params.put("family", family);
        return jdbc.query(SELECT_TITLE_BY_FAMILY,
                params,
                (rs, rowNum) -> new Title(
                        rs.getInt("title_id"),
                        rs.getString("title_name"),
                        rs.getString("title_level"),
                        rs.getString("family"),
                        rs.getString("title_description")
                ));
    }


    public Title get(String  name) {
        Map<String, Object> params = new HashMap<>();
        params.put("title_name", name);
        try {
            return jdbc.queryForObject(SELECT_TITLE_BY_NAME,
                    params,
                    TITLE_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e){
            return  null;
        }

    }


}

