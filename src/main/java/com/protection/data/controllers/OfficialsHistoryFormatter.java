package com.protection.data.controllers;

import com.protection.data.models.OfficialhistoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class OfficialsHistoryFormatter implements Formatter<OfficialhistoryEntity> {

    private static final Logger logger = LoggerFactory.getLogger(OfficialsHistoryFormatter.class);

    @Override
    public OfficialhistoryEntity parse(String s, Locale locale) throws ParseException {
        OfficialhistoryEntity statusEntity = new OfficialhistoryEntity();
        String[] data = s.split("_");
        statusEntity.setIdOfficialHistory(Integer.parseInt(data[0]));
        statusEntity.setTitle(data[1]);
        statusEntity.setSurname(data[2]);
        statusEntity.setName(data[3]);
        statusEntity.setPatronymic(data[4]);
        statusEntity.setBirth(Timestamp.valueOf(data[5]));
        statusEntity.setPhone(data[6]);
        statusEntity.setEmail(data[7]);
        statusEntity.setInstitution(data[8]);
        statusEntity.setSpecialty(data[9]);
        statusEntity.setYear(data[10]);
        statusEntity.setRemark(data[11]);
        statusEntity.setUpdateDate(Date.valueOf(data[12]));
        return statusEntity;

    }

    @Override
    public String print(OfficialhistoryEntity statusEntity, Locale locale) {
        String res;
        res = String.valueOf(statusEntity.getIdOfficialHistory()) + "_" + statusEntity.getTitle() + "_" + statusEntity.getSurname() + "_" + statusEntity.getName() + "_" + statusEntity.getPatronymic() + "_" + statusEntity.getBirth() + "_" + statusEntity.getPhone() + "_" + statusEntity.getEmail() + "_" + statusEntity.getInstitution() + "_" + statusEntity.getSpecialty() + "_" + statusEntity.getYear() + "_" + statusEntity.getRemark()+ "_" + statusEntity.getUpdateDate();
        return res;
    }
}