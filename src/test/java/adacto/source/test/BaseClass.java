package adacto.source.test;

import java.io.File.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	WebDriver driver;
	
	public	static String  ExceTestData(int rows , int colms ) {
		String value = null;
		String file = "C:\\Users\\Karth\\eclipse-workspace\\AdactinApp.Demo.testing\\ExcelSource\\AdeccoTest.xlsx";
		try {
		//FileInputStream file2 = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowSize = sheet.getPhysicalNumberOfRows();
		long lastCell = (long) sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < rowSize; i++) {
			XSSFRow row = sheet.getRow(rows);	
			for (int j = 0; j < lastCell; j++) {
				XSSFCell cell = row.getCell(colms);
				DataFormatter data = new DataFormatter();
				value = data.formatCellValue(cell);
			}}
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Exception Handled");
		}	
		return value;	
	}
	String getUrl(String URl) {
		 driver = new ChromeDriver ();
		 driver.get(URl);
		 return URl;
	}
	
	
	
	public static void main(String[] args) {
		ExceTestData(2,1);	
	}

}
