package com.protection.data.DAO;


import com.protection.data.models.SubjectrfEntity;

import java.util.List;

public interface SubjectDAO {
    SubjectrfEntity findById(int id);
    SubjectrfEntity FindByLTitle(String title);
    List<SubjectrfEntity> findAllSubjects();
    void saveSubject(SubjectrfEntity subject);
}
