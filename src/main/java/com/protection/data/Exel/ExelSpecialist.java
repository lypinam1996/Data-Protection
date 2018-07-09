package com.protection.data.Exel;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
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

public class ExelSpecialist {

    public void writeFinancingIntoExcel(List<SpecialistsEntity> specialists, QuantityEntity quantity) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Наименование подразделения по защите информации","Кол-во специалистов","","","Сведения о специалистах"});

        data.put("2", new Object[] {"","", "","По штату","В наличии(штатные)","Вналичии(нештатные)","","", "","","","","","", "",""});

        data.put("3", new Object[] {"","", "","","","","Наименование должности с указанием подразделения","Фамилия, имя, отчество",
                "Дата рождения","Телефон, e-mail","Дата назначения на должность","Согласование назначения на должность с Управлением ФСТЭК России по ЦФО, номер, дата",
                "Стаж работы в области ЗИ",
                "Образование (наименование учебного заведения, специальность по диплому, год окончания)",
                "Переподготовка по направлению Информационная безопасность (наименование учебного заведения, " +
                        "наименование программы обучения, период обучения,количество часов,наименование учебного заведения)",
                "Повышение квалификации (наименование программы обучения,период обучения,количество часов)"});
        int k=4;
        for (int i=0;i<specialists.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{quantity.getUser().getSubject().getTitleSubject(),quantity.getUser().getAuthority().getTitleAuthorities(),
                    quantity.getSubdivision(),quantity.getStaff(),quantity.getEstablished(),quantity.getNonStandard(),
                    specialists.get(i).getTitle(), specialists.get(i).getSurname()+" "+specialists.get(i).getName()+" "+specialists.get(i).getPatronymic(),
                    specialists.get(i).getBirth(), specialists.get(i).getPhone()+" "+specialists.get(i).getEmail(),
                    specialists.get(i).getDateOfAppointment(),
            specialists.get(i).getReconciliation()+" "+specialists.get(i).getReconciliationNumber()+" "+specialists.get(i).getReconciliationDate(),
            specialists.get(i).getWorkExperience(),
            specialists.get(i).getInstitution()+" "+specialists.get(i).getSpecialty()+" "+specialists.get(i).getYear(),
                    specialists.get(i).getInstitution2()+" "+specialists.get(i).getSpecialty2()+" "+specialists.get(i).getPeriodStudy()+" "+specialists.get(i).getHours(),
                    specialists.get(i).getInstitution3()+" "+specialists.get(i).getSpecialty3()+" "+specialists.get(i).getPeriodStudy3()+" "+specialists.get(i).getHours3()});
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
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,3,5);
        sheet.addMergedRegion(cellRangeAddress1);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(0,0,6,25);
        sheet.addMergedRegion(cellRangeAddress2);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,11,13);
        sheet.addMergedRegion(cellRangeAddress3);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("Specialist.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFinancingIntoExcel2(List<SpecialistshistoryEntity> specialists, QuantityEntity quantity) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Наименование подразделения по защите информации","Кол-во специалистов","","","Сведения о специалистах"});

        data.put("2", new Object[] {"","", "","По штату","В наличии(штатные)","Вналичии(нештатные)","","", "","","","","","", "",""});

        data.put("3", new Object[] {"","", "","","","","Наименование должности с указанием подразделения","Фамилия, имя, отчество",
                "Дата рождения","Телефон, e-mail","Дата назначения на должность","Согласование назначения на должность с Управлением ФСТЭК России по ЦФО, номер, дата",
                "Стаж работы в области ЗИ",
                "Образование (наименование учебного заведения, специальность по диплому, год окончания)",
                "Переподготовка по направлению Информационная безопасность (наименование учебного заведения, " +
                        "наименование программы обучения, период обучения,количество часов,наименование учебного заведения)",
                "Повышение квалификации (наименование программы обучения,период обучения,количество часов)","Дата обновления"});
        int k=4;
        for (int i=0;i<specialists.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{quantity.getUser().getSubject().getTitleSubject(),quantity.getUser().getAuthority().getTitleAuthorities(),
                    quantity.getSubdivision(),quantity.getStaff(),quantity.getEstablished(),quantity.getNonStandard(),
                    specialists.get(i).getTitle(), specialists.get(i).getSurname()+" "+specialists.get(i).getName()+" "+specialists.get(i).getPatronymic(),
                    specialists.get(i).getBirth(), specialists.get(i).getPhone()+" "+specialists.get(i).getEmail(),
                    specialists.get(i).getDateOfAppointment(),
                    specialists.get(i).getReconciliation()+" "+specialists.get(i).getReconciliationNumber()+" "+specialists.get(i).getReconciliationDate(),
                    specialists.get(i).getWorkExperience(),
                    specialists.get(i).getInstitution()+" "+specialists.get(i).getSpecialty()+" "+specialists.get(i).getYear(),
                    specialists.get(i).getInstitution2()+" "+specialists.get(i).getSpecialty2()+" "+specialists.get(i).getPeriodStudy()+" "+specialists.get(i).getHours(),
                    specialists.get(i).getInstitution3()+" "+specialists.get(i).getSpecialty3()+" "+specialists.get(i).getPeriodStudy3()+" "+specialists.get(i).getHours3(),specialists.get(i).getDateUpdate()});
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
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0,0,3,5);
        sheet.addMergedRegion(cellRangeAddress1);
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(0,0,6,16);
        sheet.addMergedRegion(cellRangeAddress2);
        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(1,1,11,13);
        sheet.addMergedRegion(cellRangeAddress3);
        for(int i=0;i<11;i++) {
            sheet.autoSizeColumn(i, true);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("Specialist.xls"));
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
