package iesfm.org.program;

import iesfm.org.Department;
import iesfm.org.dao.DepartmentDAO;
import iesfm.org.reader.DepartamentoReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentProgram {
    private final static Logger log = LoggerFactory.getLogger(DepartmentProgram.class);

    private DepartamentoReader departamentoReader;
    private DepartmentDAO departmentDAO;

    public DepartmentProgram(DepartamentoReader departamentoReader, DepartmentDAO departmentDAO) {
        this.departamentoReader = departamentoReader;
        this.departmentDAO = departmentDAO;
    }

    public void insert(){
        Department department = departamentoReader.readScanDepartment();

        departmentDAO.insert(department);
    }

    public void list(){
        List<Department> listDepartment = departmentDAO.list();

        for (Department department : listDepartment) {
            log.info(department.toString());
        }
    }
}
