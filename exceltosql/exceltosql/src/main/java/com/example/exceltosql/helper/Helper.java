package com.example.exceltosql.helper;

import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.exceltosql.entity.Finance;

public class Helper {

    // checks weather the file is excel file or not 
    public static boolean checkFile(MultipartFile file){
        String contentType = file.getContentType();
        //String excelFiletype1 = "type=application/vnd.ms-excel";
        return contentType.equals("type=application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    // 1. Files created in Microsoft Excel will need their content type defined as

    // type=application/vnd.ms-excel


    // 2. Files created in Numbers or Open Office will need their content type defined as
    // type=application/vnd.openxmlformats-officedocument.spreadsheetml.sheet

    // excel to list
    public static List<Finance> convertExcelTOList(InputStream is){
        List<Finance> list = new ArrayList<>();

        try {
            XSSFWorkbook wb=  new  XSSFWorkbook(is);
            XSSFSheet sheet = wb.getSheet("sheet1");
            
            wb.close();
            int rowNum = 0;

            Iterator<Row> iterator =  sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }


               Iterator<Cell> cells =  row.iterator();
               int cellId = 0;

               Finance finance = new Finance();
               while (cells.hasNext()) {
                Cell cell = cells.next();
                switch (cellId) {
                    case 0:
                        finance.setSegment(cell.getStringCellValue());
                        break;
                    case 1:
                        finance.setFinanceId(cell.getNumericCellValue());
                        break;
                    case 2:
                        finance.setCountry(cell.getStringCellValue());
                        break;
                    case 3:
                        finance.setProduct(cell.getStringCellValue());
                        break;
                    case 4:
                        finance.setUnitsSole(cell.getNumericCellValue());
                        break;
                    case 5:
                        finance.setDate(cell.getDateCellValue());
                        break;
                                  
                    default:
                        break;
                }
                cellId++;
               }
               list.add(finance);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
