package com.protection.data.controllers;


import com.protection.data.models.PersonaldataEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class PersonalDataFormatter implements Formatter<PersonaldataEntity> {

    @Override
    public PersonaldataEntity parse(String s, Locale locale) throws ParseException {
        PersonaldataEntity authority = new PersonaldataEntity();
        String[] data = s.split("_");
        authority.setIdPersonalData(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(PersonaldataEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdPersonalData()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}