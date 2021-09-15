package org.iesf.instituto.jdbc.program;

import org.iesf.instituto.jdbc.Student;
import org.iesf.instituto.jdbc.dao.StudentDAO;
import org.iesf.instituto.jdbc.scannerRead.StudentScannerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentProgram {
    private final static Logger log = LoggerFactory.getLogger(StudentProgram.class);

    private StudentScannerReader studentScannerReader;
    private StudentDAO studentDAO;

    public StudentProgram(StudentScannerReader studentScannerReader, StudentDAO studentDAO) {
        this.studentScannerReader = studentScannerReader;
        this.studentDAO = studentDAO;
    }

    public  void insert(){
        Student student = studentScannerReader.readScanStudent();

        studentDAO.insertar(student);
    }

    public void list(){
        List<Student> listStudent = studentDAO.list();
        for (Student student : listStudent) {
            log.info(student.toString());
        }
    }
}
