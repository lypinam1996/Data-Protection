package com.protection.data.controllers.Formatters;

import com.protection.data.models.PersonalinformationsystemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class PersonalInfFormatter implements Formatter<PersonalinformationsystemEntity> {

    private static final Logger logger = LoggerFactory.getLogger(PersonalInfFormatter.class);

    @Override
    public PersonalinformationsystemEntity parse(String s, Locale locale) throws ParseException {
        PersonalinformationsystemEntity statusEntity = new PersonalinformationsystemEntity();
        String[] data = s.split("_");
        statusEntity.setDateAct(data[12]);
        statusEntity.setDateAboutCreating(data[16]);
        statusEntity.setDateAboutExploitation(data[19]);
        statusEntity.setCommissioning(data[20]);
        statusEntity.setThreatsResultsDate(data[30]);
        statusEntity.setDateOfAttestation(data[32]);
        statusEntity.setAttestationDate(data[35]);
        statusEntity.setActDateAttestation(data[39]);
        return statusEntity;

    }

    @Override
    public String print(PersonalinformationsystemEntity statusEntity, Locale locale) {
        String res="";
        //res = String.valueOf(statusEntity.getIdOfficial()) + "_" + statusEntity.getTitle() + "_" + statusEntity.getSurname() + "_" + statusEntity.getName() + "_" + statusEntity.getPatronymic() + "_" + statusEntity.getBirth() + "_" + statusEntity.getPhone() + "_" + statusEntity.getEmail() + "_" + statusEntity.getInstitution() + "_" + statusEntity.getSpecialty() + "_" + statusEntity.getYear() + "_" + statusEntity.getRemark();
        return res;
    }
}