package com.protection.data.services;


import com.protection.data.models.SubjectrfEntity;

import java.util.List;

public interface SubjectService {
    SubjectrfEntity findById(int id);
    SubjectrfEntity FindByLTitle(String title);
    List<SubjectrfEntity> findAllSubjects();
    void saveSubject(SubjectrfEntity subject);
}
