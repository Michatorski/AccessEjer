package org.iesfm.restExample.dao;

import org.iesfm.restExample.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> list();

    void insert(Department department);

    Department get(String departmentName);

    void delete(String departmentName);
}
