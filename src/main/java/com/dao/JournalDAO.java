package com.dao;

import com.models.JournalEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JournalDAO {

    EntityManager entityManager = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public void addJournal(JournalEntity journalEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(journalEntity);
        transaction.commit();
    }

    public void removeJournal(JournalEntity journalEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(journalEntity);
        transaction.commit();
    }

    public List<JournalEntity> getAllJournals() {
        return entityManager.createQuery("SELECT jornal_alias FROM JournalEntity jornal_alias").getResultList();
    }
}
