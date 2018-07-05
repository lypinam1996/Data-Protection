package com.protection.data.Exel;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
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

public class ExelOfficial {

    public void writeOfficialIntoExcel(List<OfficialEntity> officials) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Officials");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Почтовый адрес","Должностные лица"});
        data.put("2", new Object[] {"","","","","","","","","","","Образование"});
        data.put("3", new Object[] {"","","","Наименование должности","Фамилия","Имя","Отчество","Дата рождения","Контактный телефон",
            "e-mail","Наименование высшего учебного заведения","Специальность по диплому","Год окончания","Примечание"});
        int k=4;
        for (int i=0;i<officials.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{officials.get(i).getUser().getSubject().getTitleSubject(),officials.get(i).getUser().getAuthority().getTitleAuthorities(),
                    officials.get(i).getUser().getMailingAddress(), officials.get(i).getTitle(), officials.get(i).getSurname(),
                    officials.get(i).getName(), officials.get(i).getPatronymic(),officials.get(i).getBirth().toString(),officials.get(i).getPhone(),
                    officials.get(i).getEmail(),officials.get(i).getInstitution(),officials.get(i).getSpecialty(),officials.get(i).getYear(),
                    officials.get(i).getRemark()});
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
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,3,13);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1,1,0,9);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,10,12);
        sheet.addMergedRegion(cellRangeAddress1);
        sheet.addMergedRegion(cellRangeAddress2);
        sheet.addMergedRegion(cellRangeAddress3);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("officials.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHistoryIntoExcel(List<OfficialhistoryEntity> officials, OfficialEntity officialEntity) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Почтовый адрес","Должностные лица"});
        data.put("2", new Object[] {"","","","","","","","","","","Образование","swertyj"});
        data.put("3", new Object[] {"","","","Наименование должности","Фамилия","Имя","Отчество","Дата рождения","Контактный телефон",
                "e-mail","Наименование высшего учебного заведения","Специальность по диплому","Год окончания","Примечание","Дата обновления"});
        int k=4;
        for (int i=0;i<officials.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{officialEntity.getUser().getSubject().getTitleSubject(),officialEntity.getUser().getAuthority().getTitleAuthorities(),
                    officialEntity.getUser().getMailingAddress(), officials.get(i).getTitle(), officials.get(i).getSurname(),
                            officials.get(i).getName(), officials.get(i).getPatronymic(),officials.get(i).getBirth().toString(),officials.get(i).getPhone(),
                            officials.get(i).getEmail(),officials.get(i).getInstitution(),officials.get(i).getSpecialty(),officials.get(i).getYear(),
                            officials.get(i).getRemark(), officials.get(i).getUpdateDate().toString()});
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
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,2,9);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1,1,2,3);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,4,5);
        CellRangeAddress cellRangeAddress4 = new CellRangeAddress(1,1,6,7);
        CellRangeAddress cellRangeAddress5 = new CellRangeAddress(1,1,8,9);
        sheet.addMergedRegion(cellRangeAddress1);
        sheet.addMergedRegion(cellRangeAddress2);
        sheet.addMergedRegion(cellRangeAddress3);
        sheet.addMergedRegion(cellRangeAddress4);
        sheet.addMergedRegion(cellRangeAddress5);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("officialHistory.xls"));
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
