package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell col;
	public static FileInputStream fis;
	public static FileOutputStream fout;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rowNum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rowNum,int colNum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		col = row.getCell(colNum);
		String Data;
		
		String cellData;
		try 
		{
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(col);
			return cellData;
		} 
		catch (Exception e) 
		{
			Data="";
		}
		
		wb.close();
		fis.close();
		return Data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rowNum,int colNum,String Data) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rowNum);
		col = row.createCell(colNum);
		col.setCellValue(Data);
		fout = new FileOutputStream(xlfile);
		wb.write(fout);
		wb.close();
		fis.close();
		fout.close();
	}
		

}
