package com.protection.data.controllers;

import com.protection.data.models.OfficialEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class OfficialsFormatter implements Formatter<OfficialEntity> {

    @Override
    public OfficialEntity parse(String s, Locale locale) throws ParseException {
        OfficialEntity statusEntity = new OfficialEntity();
        String[] data = s.split("_");
        statusEntity.setIdOfficial(Integer.parseInt(data[0]));
        statusEntity.setTitle(data[1]);
        statusEntity.setSurname(data[2]);
        statusEntity.setName(data[3]);
        statusEntity.setPatronymic(data[4]);
        statusEntity.setBirth(Timestamp.valueOf(data[5]));
        statusEntity.setPhone(data[6]);
        statusEntity.setEmail(data[7]);
        statusEntity.setInstitution(data[8]);
        statusEntity.setSpecialty(data[9]);
        statusEntity.setYear(data[10]);
        statusEntity.setRemark(data[11]);
        return statusEntity;

    }

    @Override
    public String print(OfficialEntity statusEntity, Locale locale) {
        String res;
        res = String.valueOf(statusEntity.getIdOfficial()) + "_" + statusEntity.getTitle()+"_"+statusEntity.getSurname()+"_"+statusEntity.getName()+"_"+statusEntity.getPatronymic()+"_"+statusEntity.getBirth()+"_"+statusEntity.getPhone()+"_"+statusEntity.getEmail()+"_"+statusEntity.getInstitution()+"_"+statusEntity.getSpecialty()+"_"+statusEntity.getYear()+"_"+statusEntity.getRemark();
        return res;
    }
}