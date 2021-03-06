package com.protection.data.controllers.Formatters;


import com.protection.data.models.YesnoEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class YesNoFormatter implements Formatter<YesnoEntity> {

    @Override
    public YesnoEntity parse(String s, Locale locale) throws ParseException {
        YesnoEntity authority = new YesnoEntity();
        String[] data = s.split("_");
        authority.setIdYesNo(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(YesnoEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdYesNo()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}