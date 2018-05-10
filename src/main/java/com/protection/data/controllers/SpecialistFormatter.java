package com.protection.data.controllers;

import com.protection.data.models.SpecialistsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class SpecialistFormatter implements Formatter<SpecialistsEntity> {

    private static final Logger logger = LoggerFactory.getLogger(SpecialistFormatter.class);

    @Override
    public SpecialistsEntity parse(String s, Locale locale) throws ParseException {
        SpecialistsEntity statusEntity = new SpecialistsEntity();
        String[] data = s.split("_");
        statusEntity.setBirth(Date.valueOf(data[5]));
        statusEntity.setDateOfAppointment(Date.valueOf(data[11]));
        statusEntity.setDateOfAppointment(Date.valueOf(data[11]));
        statusEntity.setReconciliationDate(Date.valueOf(data[23]));
        return statusEntity;

    }

    @Override
    public String print(SpecialistsEntity statusEntity, Locale locale) {
        String res="";
        //res = String.valueOf(statusEntity.getIdOfficial()) + "_" + statusEntity.getTitle() + "_" + statusEntity.getSurname() + "_" + statusEntity.getName() + "_" + statusEntity.getPatronymic() + "_" + statusEntity.getBirth() + "_" + statusEntity.getPhone() + "_" + statusEntity.getEmail() + "_" + statusEntity.getInstitution() + "_" + statusEntity.getSpecialty() + "_" + statusEntity.getYear() + "_" + statusEntity.getRemark();
        return res;
    }
}