package Config;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Vidhi Chapanera
 * @date 11 September 2021
 */
public class WriteUtils {

        public static XSSFWorkbook workbook;
        public static XSSFSheet sheet;


    /**
     * @author Vidhi Chapanera
     * @date 20 October 2021
     * @param name
     * @return
     * @throws Exception
     */
    @Step("Write Data in excel"+"\n"+"path:{0}"+"\n"+"name:{1}")
    public static boolean writeCountInExstingExcel(String path,String name) throws Exception {
        File f = new File(path);
        try {
            FileInputStream inputStream = new FileInputStream(new File(String.valueOf(f)));
            Workbook workbook = WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
            Object[][] bookData = {{name}};
            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                for (Object field : aBook) {
                    //cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 20 October 2021
     * @param name
     * @return
     * @throws Exception
     */
    @Step("Write Data in excel"+"\n"+"path:{0}"+"\n"+"sheetName:{1}"+"\n"+"name:{2}")
    public static boolean writeCountInExstingExcel(String path,String sheetName,String name) throws Exception {
        File f = new File(path);
        try {
            FileInputStream inputStream = new FileInputStream(new File(String.valueOf(f)));
            Workbook workbook = WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
            Object[][] bookData = {{name}};
            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                for (Object field : aBook) {
                    //cell = row.createCell(columnCount++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 20 October 2021
     * @param name
     * @return
     * @throws Exception
     */
    @Step("Write Data in excel"+"\n"+"sheetName:{0}"+"\n"+"path:{1}"+"\n"+"name:{2}")
    public static boolean writeRosterDataInExstingExcel(String sheetName,String path,String name) throws Exception {
        File f = new File(path);
        try {
            FileInputStream inputStream = new FileInputStream(new File(String.valueOf(f)));
            Workbook workbook = WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
            Object[][] bookData = {{name}};
            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                for (Object field : aBook) {
                    //cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            FileInputStream inputStream = new FileInputStream(new File(String.valueOf(f)));
            Workbook workbook = WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet(sheetName);
            Object[][] bookData = {{name}};
            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                for (Object field : aBook) {
                    //cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            return true;
        }
    }



}
