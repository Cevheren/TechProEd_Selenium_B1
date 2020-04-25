package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        String path = "./src/test/resources/Capitals.xlsx";
        FileInputStream file = new FileInputStream(path);//opening the file

        Workbook workbook= WorkbookFactory.create(file);//opening the workbook
        Sheet sheet=workbook.getSheetAt(0);//getting the first sheet
        Row row = sheet.getRow(0);//getting the first row
        Cell cell=row.createCell(3);//creating a cell
        cell.setCellValue("POPULATION");


        //Opening a file to send data to the created cell
        FileOutputStream fileOutputStream=new FileOutputStream(path);

        //we are creating the cell on the 2nd row and 4th cell, setting the value at 200000
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("200000");

        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("123445");

        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("123445423");

        workbook.write(fileOutputStream);//writing on the cell and saving the workbook

       fileOutputStream.close();
       file.close();
       workbook.close();

    }

}
