package com.protection.data.controllers;


import com.protection.data.models.CategoryofsubjectEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class CategoryFormatter implements Formatter<CategoryofsubjectEntity> {

    @Override
    public CategoryofsubjectEntity parse(String s, Locale locale) throws ParseException {
        CategoryofsubjectEntity authority = new CategoryofsubjectEntity();
        String[] data = s.split("_");
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(CategoryofsubjectEntity authoritiesEntity, Locale locale) {
        String res="";
       // res = String.valueOf(authoritiesEntity.getIdAuthorities()) + "_" + authoritiesEntity.getTitleAuthorities();
        return res;
    }
}