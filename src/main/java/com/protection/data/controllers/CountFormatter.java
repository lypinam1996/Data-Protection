package com.protection.data.controllers;


import com.protection.data.models.CountsubjectsEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class CountFormatter implements Formatter<CountsubjectsEntity> {

    @Override
    public CountsubjectsEntity parse(String s, Locale locale) throws ParseException {
        CountsubjectsEntity authority = new CountsubjectsEntity();
        String[] data = s.split("_");
        authority.setIdCountSubjects(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(CountsubjectsEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdCountSubjects()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}