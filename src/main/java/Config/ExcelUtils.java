package Config;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class ExcelUtils {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    /**
     * @author Vidhi Chapanera
     * @date 22 January 2021
     */
    public ExcelUtils() {
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 22 January 2021
     */
    @Step("get All Cell DataString")
    public static List getAllCellDataString() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Users.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            itr.next();//iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @param sheetName
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 25 January 2021
     */
    @Step("get All Cell DataString For Role"+"\n"+"sheetName:{0}")
    public static List getAllCellDataStringForRole(String sheetName) throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Role.xlsx");
            sheet = workbook.getSheet(sheetName);
            Iterator<Row> itr = sheet.iterator();
            itr.next();//iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 29 January 2021
     */
    @Step("remove All Cell DataString "+"\n"+"path:{0}")
    public static boolean removeAllCellDataString(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheetAt(0);
        for(int i=0; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            deleteRow(sheet, row);
        }
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(path));
        workbook.write(outFile);
        outFile.close();
        return true;
    }

    /**
     * @author Vidhi Chapanera
     * @date 29 January 2021
     * @param sheet
     * @param row
     * @return
     */
    @Step("Delete Row"+"\n"+"sheet:{0}"+"\n"+"row:{1}")
    private static boolean deleteRow(XSSFSheet sheet, Row row) {
        if (row == null){
            return true;
        }else {
            int lastRowNum = sheet.getLastRowNum();
            int rowIndex = row.getRowNum();
            Row removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
                System.out.println("Deleting.... ");
            }
            System.out.println(rowIndex + "\n" + lastRowNum);
            return true;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 February 2021
     */
    @Step("get data String for Product"+"\n"+"SheetName:{0}")
    public static List getAllCellDataStringForProduct(String SheetName) throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Products.xlsx");
            sheet = workbook.getSheet(SheetName);
            Iterator<Row> itr = sheet.iterator();
            itr.next();//iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 February 2021
     */
    @Step("get data String for clock in out time")
    public static List getAllCellDataStringForClockInOutTime() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\ClockInOut.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
            //System.out.(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 February 2021
     */
    @Step("get data String for Transfers")
    public static List getAllCellDataStringForTransfers() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Transfers.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 19 January 2021
     */
    @Step("Remove all cell data string"+"\n"+"path:{0}"+"\n"+"sheetName:{1}")
    public static boolean removeAllCellDataString(String path,String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        for(int i=0; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            deleteRow(sheet, row);
        }
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(path));
        workbook.write(outFile);
        outFile.close();
        return true;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 February 2021
     */
    @Step("get all cell data string for Permission"+"\n"+"sheetName:{0}")
    public static List getAllCellDataStringForPermission(String sheetName) throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Permissions.xlsx");
            sheet = workbook.getSheet(sheetName);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 February 2021
     */
    @Step("Remove all cell data string for Roster"+"\n"+"path:{0}"+"\n"+"sheetName:{1}")
    public static boolean removeAllCellDataStringForRoster(String path,String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        for(int i=0; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            deleteRow(sheet, row);
        }
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(path));
        workbook.write(outFile);
        outFile.close();
        return true;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 February 2021
     */
    @Step("get all cell data string for Roster"+"\n"+"sheetName:{0}")
    public static List getAllCellDataStringForRoster(String sheetName) throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Roster.xlsx");
            sheet = workbook.getSheet(sheetName);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 March 2021
     */
    @Step("get all cell data string for CustomeReport"+"\n"+"sheetName:{0}")
    public static List getAllCellDataStringForCustomeReport(String sheetName) throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\CustomRepots.xlsx");
            sheet = workbook.getSheet(sheetName);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 March 2021
     */
    @Step("get all cell data string for CustomeReport")
    public static List getAllCellDataStringForCustomeReport01() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
                workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\CustomRepots.xlsx");
                int n = workbook.getNumberOfSheets();
                for (int i= 0 ; i<n ;i++){
                    sheet = workbook.getSheetAt(i);
                    System.out.println(workbook.getSheetAt(i).getSheetName());
                    Iterator<Row> itr = sheet.iterator();
                    while (itr.hasNext()) {
                        Row row = itr.next();
                        map.add(row.getCell(0).getStringCellValue());
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 April 2021
     */
    @Step("get all cell data string for Quickbooks")
    public static List getAllCellDataStringForQuickBooks() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\QuickBooksMapping.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 April 2021
     */
    @Step("get all cell data string for Xero")
    public static List getAllCellDataStringForXero() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Xero.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 27 October 2021
     */
    @Step("get all cell data string for Tax")
    public static List getAllCellDataStringForTax() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Tax.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
            //System.out.(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 01 December 2021
     */
    @Step("get all cell data string for Toal Item")
    public static List getAllCellDataStringFortotalItem() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\Totalitem.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
            //System.out.(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 24 December 2021
     */
    @Step("get all cell data string for sales Summery")
    public static List getAllCellDataStringSalesSummery() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\SalesSummery.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 29 December 2021
     */
    @Step("get all cell data string for Add Buttons")
    public static List getAllCellDataStringAddButtons() throws IOException {
        List<String> map = new ArrayList<String>();
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\xlsx File\\AddButtons.xlsx");
            sheet = workbook.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                map.add(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}