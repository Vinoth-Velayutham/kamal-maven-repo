package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sql.rowset.RowSetWarning;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	@Test
	public void iReadDataFromExcel() throws IOException {

		System.out.println(System.getProperty("user.dir"));

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\phpTravelTestData.xlsx";

		System.out.println(excelPath);

		File excelFile = new File(excelPath);

		FileInputStream excelFileInput = new FileInputStream(excelFile);

		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFileInput);

		XSSFSheet excelSheet = excelWorkBook.getSheet("PHPTestData");

		// String value = row.getCell(1).getStringCellValue();

		for (int i = 0; i <= excelSheet.getLastRowNum(); i++) {
			Row row = excelSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				String value = row.getCell(j).getStringCellValue();
				System.out.println(value);
			}

		}

	}

}
