package com.service;

import com.dao.JournalDAO;
import com.models.JournalEntity;

import java.util.List;

public class JournalService {
    private JournalDAO journalDAO;

    public JournalDAO getJournalDAO() {
        synchronized (JournalService.class) {
            if (journalDAO == null) {
                journalDAO = new JournalDAO();
            }
        }
        return journalDAO;
    }

    public void addJournal(JournalEntity journalEntity){
        getJournalDAO().addJournal(journalEntity);
    }

    public List<JournalEntity> getJournals() {
        return getJournalDAO().getAllJournals();
    }
}
