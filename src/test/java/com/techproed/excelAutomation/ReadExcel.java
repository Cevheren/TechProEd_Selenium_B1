package com.techproed.excelAutomation;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcelFile() throws Exception {
        String path ="./src/test/resources/Capitals.xlsx";
        //Opening the file
        FileInputStream fileInputStream=new FileInputStream(path);
        //Open the workbook using fileinputstream

        Workbook workbook=WorkbookFactory.create(fileInputStream);
        //Go to the first worksheet.(index of 0)
        Sheet sheet=workbook.getSheetAt(0);
        //Go to the first row (index of 0)
        Row row=sheet.getRow(0);
        //Now we can read the cell(test data)
        Cell cell1=row.getCell(0);
        System.out.println("PRINTING THE FIRST CELL : "+cell1);

        System.out.println("PRINTING THE SECOND CELL : "+row.getCell(1));

        //printing the second row and first cell
        Row row1=sheet.getRow(1);//getting the second row
        Cell cell2=row1.getCell(0);//getting the first cell
        System.out.println(cell2);

        //WE CAN CHAIN THE METHODS
        String france=workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(france);

        //how do you get the last row number?Index start at 0.
        int rowCount=sheet.getLastRowNum();
        System.out.println(rowCount);

        //how do you get the number of row that is used index start at 1.Gives only used # of cell
        int numberOfPhysicalRows=sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfPhysicalRows);


        Map<String,String> capitals=new HashMap<>();
        int countryColumn=0;
        int capitolColumn=1;

        for (int rowNumber=1;rowNumber<=rowCount;rowNumber++){
            String country=sheet.getRow(rowNumber).getCell(countryColumn).toString();
            System.out.println(country);
            String capitol = sheet.getRow(rowNumber).getCell(capitolColumn).toString();
            System.out.println(capitol);
            capitals.put(country,capitol);
        }

        System.out.println(capitals);



    }
}