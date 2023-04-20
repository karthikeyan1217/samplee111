package adacto.source.test;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileWritting {

	public static String  ExcelWritting (String sheet, int row, int cell, String Setvalue) {
		String value = null;
		try {
			File file = new File("C:\\Users\\Karth\\eclipse-workspace\\AdactinApp.Demo.testing\\ExcelSource\\AdeccoTest.xlsx");
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fis);
			
			Sheet createSheet = wb.createSheet(sheet);
			Row createRow = createSheet.createRow(row);

			Cell colm = createRow.createCell(cell);//colom
			//AdectoLogin obj = new AdectoLogin();
			colm.setCellValue(Setvalue);
			
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}
	public static void main(String[] args) {



	}
}