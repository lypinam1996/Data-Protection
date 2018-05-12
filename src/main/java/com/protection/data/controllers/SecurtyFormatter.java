package com.protection.data.controllers;


import com.protection.data.models.SecuritylevelEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class SecurtyFormatter implements Formatter<SecuritylevelEntity> {

    @Override
    public SecuritylevelEntity parse(String s, Locale locale) throws ParseException {
        SecuritylevelEntity authority = new SecuritylevelEntity();
        String[] data = s.split("_");
        authority.setIdSecuritylevel(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(SecuritylevelEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdSecuritylevel()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}