package com.protection.data.controllers.Formatters;

import com.protection.data.models.SubjectrfEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class LevelFormatter implements Formatter<SubjectrfEntity> {

    @Override
    public SubjectrfEntity parse(String s, Locale locale) throws ParseException {
        SubjectrfEntity statusEntity = new SubjectrfEntity();
        String[] data = s.split("_");
        statusEntity.setIdSubject(Integer.parseInt(data[0]));
        statusEntity.setTitleSubject(data[1]);
        return statusEntity;

    }

    @Override
    public String print(SubjectrfEntity statusEntity, Locale locale) {
        String res;
        res = String.valueOf(statusEntity.getIdSubject()) + "_" + statusEntity.getTitleSubject();
        return res;
    }
}