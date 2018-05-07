package com.protection.data.services;

import com.protection.data.DAO.SubjectDAO;
import com.protection.data.models.SubjectrfEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SubjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectDAO subject;

    @Override
    public SubjectrfEntity findById(int id) {
        return subject.findById(id);
    }

    @Override
    public SubjectrfEntity FindByLTitle(String title) {
        return subject.FindByLTitle(title);
    }

    @Override
    public List<SubjectrfEntity> findAllSubjects() {
        return subject.findAllSubjects();
    }

    @Override
    public void saveSubject(SubjectrfEntity subject1) {
        subject.saveSubject(subject1);
    }
}
