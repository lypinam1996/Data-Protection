package com.protection.data.Exel;

import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExelStates {

    public void writeOfficialIntoExcel(List<StateinformationsystemEntity> o) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Officials");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Государственная информационная система"});
        data.put("2", new Object[] {"","","","","","","","","","","","","","Классификация информационной системы","","Модель угроз безопасности","","Аттестация информационной системы",""});
        data.put("3", new Object[] {"","","Наименование ГИС","Наименование оператора ГИС","Цель и назначение ГИС",
                "Структурное подразделение или должностное лицо (работник), ответственный за защиту информации",
                "Нормативный правовой акт о создании ГИС, номер и дата","Нормативный правовой акт о порядке и сроках ввода в эксплуатацию ГИС, номер и дата ",
                "Дата ввода в эксплуатацию", "Налиие информации ограниченного доступа","Тип криптозащиты",
                "Сведения об отдельных частях ГИС","Включение в Единый реестр государственных информационных систем Воронежской области, дата и реестровый номер",
                "Класс защищённости","Акт классификации, номер и дата","Результаты рассмотрения ФСТЭК России",
                "Номер и дата ответа","Название органа проводившего аттестацию, №лицензии ФСТЭК России", "Аттестат соответствия, номер и дата"});
        int k=4;
        for (int i=0;i<o.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{o.get(i).getUser().getSubject().getTitleSubject(),o.get(i).getUser().getAuthority().getTitleAuthorities(),
                    o.get(i).getTitle(), o.get(i).getOperator(),o.get(i).getPurpose(),o.get(i).getName()+" "+o.get(i).getSurname()+" "+o.get(i).getPatronimyc()+" \n"+o.get(i).getPost()+" "+o.get(i).getSubdivision(),
                    o.get(i).getLegalActAboutCreating()+"\n "+ o.get(i).getNumberAboutCreating()+" "+o.get(i).getDateAboutCreating().toString(),
                    o.get(i).getLegalActAboutExploitation()+"\n "+o.get(i).getNumberAboutExploitation()+" "+ o.get(i).getDateAboutExploitation().toString(),
                    o.get(i).getCommissioning().toString(),o.get(i).getRestrictedAccessInformation(),
                    o.get(i).getCryptoProtection(),o.get(i).getSeparateParts(),
                    o.get(i).getLegalActRegister()+"\n "+o.get(i).getDateRegister().toString()+" "+o.get(i).getNumberRegister(),
                    o.get(i).getTypeofcryptoprotectionByTypeofcryptoprotection().getTitle(),
                    o.get(i).getNumberClassification()+"\n "+o.get(i).getNumberClassification()+" "+o.get(i).getDateClassification().toString(),
                    o.get(i).getThreatsResults(),
                    o.get(i).getThreatsResultsDate().toString()+" "+ o.get(i).getThreatsResultsNumber(),
                    o.get(i).getAttestationName()+" "+o.get(i).getAttestationNumberLisence(),
                    o.get(i).getActAttestation()+" "+o.get(i).getActNumberAttestation()+" "+o.get(i).getActDateAttestation().toString(),
                   });
            k++;
        }
        int rownum = 0;
        Set<String> keyset = data.keySet();
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                CellStyle cs = workbook.createCellStyle();
                cs.setWrapText(true);
                cell.setCellStyle(cs);
                if(obj instanceof Date)
                    cell.setCellValue((Date)obj);
                else if(obj instanceof Boolean)
                    cell.setCellValue((Boolean)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
                sheet.autoSizeColumn(cellnum);
                sheet.autoSizeColumn(0);
            }
        }
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,2,18);
        sheet.addMergedRegion(cellRangeAddress1);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1,1,13,14);
        sheet.addMergedRegion(cellRangeAddress2);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,15,16);
        sheet.addMergedRegion(cellRangeAddress3);
        CellRangeAddress cellRangeAddress4 = new CellRangeAddress(1,1,17,18);
        sheet.addMergedRegion(cellRangeAddress4);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("states.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHistoryExcel(List<StateinformationsystehistoryEntity> o, StateinformationsystemEntity b) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Officials");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Государственная информационная система"});
        data.put("2", new Object[] {"","","","","","","","","","","","","","Классификация информационной системы","","Модель угроз безопасности","","Аттестация информационной системы",""});
        data.put("3", new Object[] {"","","Наименование ГИС","Наименование оператора ГИС","Цель и назначение ГИС",
                "Структурное подразделение или должностное лицо (работник), ответственный за защиту информации",
                "Нормативный правовой акт о создании ГИС, номер и дата","Нормативный правовой акт о порядке и сроках ввода в эксплуатацию ГИС, номер и дата ",
                "Дата ввода в эксплуатацию", "Налиие информации ограниченного доступа","Тип криптозащиты",
                "Сведения об отдельных частях ГИС","Включение в Единый реестр государственных информационных систем Воронежской области, дата и реестровый номер",
                "Класс защищённости","Акт классификации, номер и дата","Результаты рассмотрения ФСТЭК России",
                "Номер и дата ответа","Название органа проводившего аттестацию, №лицензии ФСТЭК России", "Аттестат соответствия, номер и дата","Дата обновления"});
        int k=4;
        for (int i=0;i<o.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{b.getUser().getSubject().getTitleSubject(),b.getUser().getAuthority().getTitleAuthorities(),
                    o.get(i).getTitle(), o.get(i).getOperator(),o.get(i).getPurpose(),o.get(i).getName()+" "+o.get(i).getSurname()+" "+o.get(i).getPatronimyc()+" \n"+o.get(i).getPost()+" "+o.get(i).getSubdivision(),
                    o.get(i).getLegalActAboutCreating()+"\n "+ o.get(i).getNumberAboutCreating()+" "+o.get(i).getDateAboutCreating().toString(),
                    o.get(i).getLegalActAboutExploitation()+"\n "+o.get(i).getNumberAboutExploitation()+" "+ o.get(i).getDateAboutExploitation().toString(),
                    o.get(i).getCommissioning().toString(),o.get(i).getRestrictedAccessInformation(),
                    o.get(i).getCryptoProtection(),o.get(i).getSeparateParts(),
                    o.get(i).getLegalActRegister()+"\n "+o.get(i).getDateRegister().toString()+" "+o.get(i).getNumberRegister(),
                    o.get(i).getTypeofcryptoprotectionByTypeofcryptoprotection().getTitle(),
                    o.get(i).getNumberClassification()+"\n "+o.get(i).getNumberClassification()+" "+o.get(i).getDateClassification().toString(),
                    o.get(i).getThreatsResults(),
                    o.get(i).getThreatsResultsDate().toString()+" "+ o.get(i).getThreatsResultsNumber(),
                    o.get(i).getAttestationName()+" "+o.get(i).getAttestationNumberLisence(),
                    o.get(i).getActAttestation()+" "+o.get(i).getActNumberAttestation()+" "+o.get(i).getActDateAttestation().toString(),
            o.get(i).getDateUpdate()});
            k++;
        }
        int rownum = 0;
        Set<String> keyset = data.keySet();
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                CellStyle cs = workbook.createCellStyle();
                cs.setWrapText(true);
                cell.setCellStyle(cs);
                if(obj instanceof Date)
                    cell.setCellValue((Date)obj);
                else if(obj instanceof Boolean)
                    cell.setCellValue((Boolean)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
                sheet.autoSizeColumn(cellnum);
                sheet.autoSizeColumn(0);
            }
        }
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,2,18);
        sheet.addMergedRegion(cellRangeAddress1);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1,1,13,14);
        sheet.addMergedRegion(cellRangeAddress2);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,15,16);
        sheet.addMergedRegion(cellRangeAddress3);
        CellRangeAddress cellRangeAddress4 = new CellRangeAddress(1,1,17,18);
        sheet.addMergedRegion(cellRangeAddress4);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("states.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }
