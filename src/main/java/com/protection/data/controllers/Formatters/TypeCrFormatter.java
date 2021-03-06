package com.protection.data.controllers.Formatters;


import com.protection.data.models.TypeofcryptoprotectionEntity;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class TypeCrFormatter implements Formatter<TypeofcryptoprotectionEntity> {

    @Override
    public TypeofcryptoprotectionEntity parse(String s, Locale locale) throws ParseException {
        TypeofcryptoprotectionEntity authority = new TypeofcryptoprotectionEntity();
        String[] data = s.split("_");
        authority.setIdtypeOfCryptoProtection(Integer.parseInt(data[0]));
        authority.setTitle(data[1]);
        return authority;

    }

    @Override
    public String print(TypeofcryptoprotectionEntity authoritiesEntity, Locale locale) {
        String res="";
        res = String.valueOf(authoritiesEntity.getIdtypeOfCryptoProtection()) + "_" + authoritiesEntity.getTitle();
        return res;
    }
}