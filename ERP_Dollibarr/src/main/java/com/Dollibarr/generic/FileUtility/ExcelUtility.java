package com.Dollibarr.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
public String getDataFromExcel(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./resources/Excel_Dollibarr_TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheet);
    String data = sh.getRow(rowNum).getCell(cellNum).toString();
    wb.close();
    return data;
}
public int getLastRowNum(String sheet) throws Exception
{
	FileInputStream fis=new FileInputStream("./resources/Excel_Dollibarr_TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheet);
    int num = sh.getLastRowNum();
    wb.close();
    return num;
}
public void setDataIntoExcel(String sheet,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./resources/Excel_Dollibarr_TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheet);
    Row row = sh.getRow(rowNum);
    Cell cel = row.createCell(cellNum);
    cel.setCellValue(data);
    FileOutputStream fos=new FileOutputStream("./resources/Excel_Dollibarr_TestData.xlsx");
    wb.write(fos);
    wb.close();
    
}

public short getLastCellNum(String sheet,int row) throws Exception
{
	FileInputStream fis=new FileInputStream("./resources/Excel_Dollibarr_TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	short data = wb.getSheet(sheet).getRow(row).getLastCellNum();
	wb.close();
	return data;
}
}
