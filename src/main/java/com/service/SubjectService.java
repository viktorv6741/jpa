package com.service;

import com.dao.SubjectDAO;
import com.models.SubjectEntity;

import java.util.List;

public class SubjectService {
    private SubjectDAO subjectDAO;

    public SubjectDAO getSubjectDAO() {
        synchronized (SubjectService.class) {
            if (subjectDAO == null) {
                subjectDAO = new SubjectDAO();
            }
        }
        return subjectDAO;
    }

    public void addStudent(SubjectEntity subjectEntity) {
        getSubjectDAO().addSubject(subjectEntity);
    }

    public List<SubjectEntity> getSubjects() {
        return getSubjectDAO().getAllSubjects();
    }
}
