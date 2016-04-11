package com.dao;

import com.models.JournalEntity;
import com.models.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDAO {

    EntityManager entityManager = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public void addStudent(StudentEntity studentEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(studentEntity);
        transaction.commit();
    }

    public void removeStudent(StudentEntity studentEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(studentEntity);
        transaction.commit();
    }

    public List<StudentEntity> getAllStudents() {
        return entityManager.createQuery("SELECT student_alias FROM JournalEntity student_alias ").getResultList();
    }
}
