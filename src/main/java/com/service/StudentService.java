package com.service;


import com.dao.StudentDAO;
import com.models.StudentEntity;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        synchronized (JournalService.class) {
            if (studentDAO == null) {
                studentDAO = new StudentDAO();
            }
        }
        return studentDAO;
    }

    public void addStudent(StudentEntity studentEntity) {
        getStudentDAO().addStudent(studentEntity);
    }

    public List<StudentEntity> getStudents() {
        return getStudentDAO().getAllStudents();
    }
}
