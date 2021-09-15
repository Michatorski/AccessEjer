package org.iesfm.restExample.dao;

import org.iesfm.restExample.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> list();

    /**
     * Inserta el empleado
     *
     * @param employee
     * @return Devuelve true si se ha insertado correctamente
     */
    boolean insert(Employee employee);

    /**
     * Elimina el empleado
     *
     * @param nif
     * @return Devuelve true si el empleado existía
     */
    boolean delete(String nif);

    List<Employee> list(String departmentName);

    Employee get(String nif);
}
