package com.protection.data.Exel;

import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;
import com.protection.data.models.UsersEntity;
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

public class ExelFinancing {

    public void writeFinancingIntoExcel(List<FinancingEntity> financings) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Текущее и планируемое финансирование мероприятий(тыс. рублей)"});
        data.put("2", new Object[] {"","", "На защиту информации, содержащей \nсведения, составляющие государственную тайну","",
                "На защиту информации ограниченного \nдоступа, не содержащей сведения, составляющие государственную тайну","",
                "На защиту персональных данных в \nинформационных системах персональных данных","",
                "Всего",""});
        data.put("3", new Object[] {"","","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год"});
        int k=4;
        for (int i=0;i<financings.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{financings.get(i).getUser().getSubject().getTitleSubject(),financings.get(i).getUser().getAuthority().getTitleAuthorities(),
                    financings.get(i).getsSThisYear(),financings.get(i).getsSNextYear(),
                    financings.get(i).getNosSThisYear(),financings.get(i).getNosSNextYear(),
                    financings.get(i).getPersonalInformationThisYear(),financings.get(i).getPersonalInformationNextYear(),
                    financings.get(i).getsSThisYear(),financings.get(i).getPersonalInformationNextYear()});
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
                    new FileOutputStream(new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFinancingIntoExcel(List<FinancingEntity> financings, UsersEntity user) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Текущее и планируемое финансирование мероприятий(тыс. рублей)"});
        data.put("2", new Object[] {"","", "На защиту информации, содержащей \nсведения, составляющие государственную тайну","",
                "На защиту информации ограниченного \nдоступа, не содержащей сведения, составляющие государственную тайну","",
                "На защиту персональных данных в \nинформационных системах персональных данных","",
                "Всего",""});
        data.put("3", new Object[] {"","","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год"});
        int k=4;
        for (int i=0;i<financings.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{user.getSubject().getTitleSubject(),user.getAuthority().getTitleAuthorities(),
            financings.get(i).getsSThisYear(),financings.get(i).getsSNextYear(),
                    financings.get(i).getNosSThisYear(),financings.get(i).getNosSNextYear(),
                    financings.get(i).getPersonalInformationThisYear(),financings.get(i).getPersonalInformationNextYear(),
                    financings.get(i).getsSThisYear(),financings.get(i).getPersonalInformationNextYear()});
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
                    new FileOutputStream(new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFinancingHistoryIntoExcel(List<FinancinghistoryEntity> financings,UsersEntity user) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Текущее и планируемое финансирование мероприятий(тыс. рублей)"});
        data.put("2", new Object[] {"","", "На защиту информации, содержащей \nсведения, составляющие государственную тайну","",
                "На защиту информации ограниченного \nдоступа, не содержащей сведения, составляющие государственную тайну","",
                "На защиту персональных данных в \nинформационных системах персональных данных","",
                "Всего","","Дата обновления"});
        data.put("3", new Object[] {"","","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год"});
        int k=4;
        for (int i=0;i<financings.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{user.getSubject().getTitleSubject(),user.getAuthority().getTitleAuthorities(),
                    financings.get(i).getsSThisYear(),financings.get(i).getsSNextYear(),
                    financings.get(i).getNosSThisYear(),financings.get(i).getNosSNextYear(),
                    financings.get(i).getPersonalInformationThisYear(),financings.get(i).getPersonalInformationNextYear(),
                    financings.get(i).getsSThisYear(),financings.get(i).getPersonalInformationNextYear(),
            financings.get(i).getUpdateDate().toString()});
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
                    new FileOutputStream(new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFinancingHistoryIntoExcel(List<FinancinghistoryEntity> financings,FinancingEntity financingEntity) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Financings");
        short w =500;
        sheet.setDefaultRowHeight(w);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Субъект РФ", "Наименование органа \nвласти(самоуправления)","Текущее и планируемое финансирование мероприятий(тыс. рублей)"});
        data.put("2", new Object[] {"","", "На защиту информации, содержащей \nсведения, составляющие государственную тайну","",
                "На защиту информации ограниченного \nдоступа, не содержащей сведения, составляющие государственную тайну","",
                "На защиту персональных данных в \nинформационных системах персональных данных","",
                "Всего","","Дата обновления"});
        data.put("3", new Object[] {"","","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год","Текущий год","Следующий год"});
        int k=4;
        for (int i=0;i<financings.size();i++ ) {
            data.put(String.valueOf(k), new Object[]{financingEntity.getUser().getSubject().getTitleSubject(),financingEntity.getUser().getAuthority().getTitleAuthorities(),
                    financings.get(i).getsSThisYear(),financings.get(i).getsSNextYear(),
                    financings.get(i).getNosSThisYear(),financings.get(i).getNosSNextYear(),
                    financings.get(i).getPersonalInformationThisYear(),financings.get(i).getPersonalInformationNextYear(),
                    financings.get(i).getsSThisYear(),financings.get(i).getPersonalInformationNextYear(),
                    financings.get(i).getUpdateDate().toString()});
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
                    new FileOutputStream(new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls"));
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
