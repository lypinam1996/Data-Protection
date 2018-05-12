package com.protection.data.controllers;


import com.protection.data.models.TypethreatEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class ThreatFormatter implements Formatter<TypethreatEntity> {

    @Override
    public TypethreatEntity parse(String s, Locale locale) throws ParseException {
        TypethreatEntity authority = new TypethreatEntity();
        String[] data = s.split("_");
        authority.setIdTypeThreat(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(TypethreatEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdTypeThreat()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}