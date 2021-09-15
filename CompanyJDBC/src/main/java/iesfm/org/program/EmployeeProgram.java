package iesfm.org.program;

import iesfm.org.Employee;
import iesfm.org.dao.EmployeeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeProgram {
    private final static Logger log = LoggerFactory.getLogger(Employee.class);

    private EmployeeDAO employeeDAO;

    public EmployeeProgram(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void listByDeparment(String departmentName){
        List<Employee> listEmployee = employeeDAO.listEmployeeByDepartment( departmentName);

        for (Employee employee : listEmployee) {
            log.info(employee.toString());
        }
    }
}
