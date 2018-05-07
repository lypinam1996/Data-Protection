package com.protection.data.controllers;


import com.protection.data.models.AuthoritiesEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class AuthorityFormatter implements Formatter<AuthoritiesEntity> {

    @Override
    public AuthoritiesEntity parse(String s, Locale locale) throws ParseException {
        AuthoritiesEntity authority = new AuthoritiesEntity();
        String[] data = s.split("_");
        authority.setIdAuthorities(Integer.parseInt(data[0]));
        authority.setTitleAuthorities(data[1]);
        return authority;

    }

    @Override
    public String print(AuthoritiesEntity authoritiesEntity, Locale locale) {
        String res;
        res = String.valueOf(authoritiesEntity.getIdAuthorities()) + "_" + authoritiesEntity.getTitleAuthorities();
        return res;
    }
}