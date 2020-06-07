package DataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

	public class ExcelDataProvider {

		public static XSSFWorkbook wb;
		public static XSSFSheet sh;
		public static XSSFRow row;
	
		public ExcelDataProvider()
		{
			File src = new File("C:\\Users\\Shahzad\\eclipse-workspace\\RestAssuredAPITesting\\src\\test\\java\\DataDrivenTest\\DDT_API_BY_PAVN.xlsx");
			
			try {
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
				} 
			catch (Exception e) 
				{
				System.out.println("Unable to Read Excel File"+e.getMessage());
				}
		}
		public String getExcelData(int SheetIndex,int row,int col)
		{
			return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
		}
		public static Object getExcelData(String SheetName,int row,int col)
		{
			return wb.getSheet(SheetName).getRow(row).getCell(col).toString();	
		}
		public double getNumExcelData(String SheetName,int row,int col)
		{
			return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
		}
		
		
		public int getRowCount(String SheetName) 
		{
			return wb.getSheet(SheetName).getLastRowNum();
		}
		
		public int getCellCount(String SheetName,int rowNum)
		{
			row = wb.getSheet(SheetName).getRow(rowNum);
			return row.getLastCellNum();
		}
		
		
}
