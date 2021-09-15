package org.iesfm.restExample.dao.inmemory;

import org.iesfm.restExample.Department;
import org.iesfm.restExample.dao.DepartmentDAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InMemorDepartmentDAO implements DepartmentDAO {

    private Map<String, Department> departments = new HashMap<>();

    @Override
    public List<Department> list() {
        return new LinkedList<>(departments.values());
    }

    @Override
    public void insert(Department department) {
        departments.put(department.getName(), department);
    }

    @Override
    public Department get(String departmentName) {
        return departments.get(departmentName);
    }

    @Override
    public void delete(String departmentName) {
        departments.remove(departmentName);
    }
}
