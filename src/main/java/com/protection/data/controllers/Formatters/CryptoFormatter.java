package com.protection.data.controllers.Formatters;

import com.protection.data.models.StateinformationsystemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class CryptoFormatter implements Formatter<StateinformationsystemEntity> {

    private static final Logger logger = LoggerFactory.getLogger(CryptoFormatter.class);

    @Override
    public StateinformationsystemEntity parse(String s, Locale locale) throws ParseException {
        StateinformationsystemEntity statusEntity = new StateinformationsystemEntity();
        String[] data = s.split("_");
        statusEntity.setDateAct(Date.valueOf(data[12]));
        statusEntity.setDateAboutCreating(Date.valueOf(data[16]));
        statusEntity.setDateAboutExploitation(Date.valueOf(data[19]));
        statusEntity.setCommissioning(Date.valueOf(data[20]));
        statusEntity.setDateRegister(Date.valueOf(data[26]));
        statusEntity.setDateClassification(Date.valueOf(data[28]));
        statusEntity.setThreatsResultsDate(Date.valueOf(data[30]));
        statusEntity.setDateOfAttestation(Date.valueOf(data[32]));
        statusEntity.setAttestationDate(Date.valueOf(data[35]));
       return statusEntity;

    }

    @Override
    public String print(StateinformationsystemEntity statusEntity, Locale locale) {
        String res="";
        //res = String.valueOf(statusEntity.getIdOfficial()) + "_" + statusEntity.getTitle() + "_" + statusEntity.getSurname() + "_" + statusEntity.getName() + "_" + statusEntity.getPatronymic() + "_" + statusEntity.getBirth() + "_" + statusEntity.getPhone() + "_" + statusEntity.getEmail() + "_" + statusEntity.getInstitution() + "_" + statusEntity.getSpecialty() + "_" + statusEntity.getYear() + "_" + statusEntity.getRemark();
        return res;
    }
}