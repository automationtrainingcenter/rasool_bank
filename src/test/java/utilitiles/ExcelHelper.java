package utilitiles;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	Workbook book;
	Sheet sh;

	// open excel to read the data
	public void openExcel(String folderName, String fileName, String sheetName) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(GenericHelper.getFilePath(folderName, fileName));
			if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook(fis);
			}
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// row count
	public int rowCount() {
		return sh.getLastRowNum();
	}

	// column count
	public int columnCount() {
		return sh.getRow(0).getLastCellNum();
	}

	// read the data
	public String readData(int rnum, int cnum) {
		String data = null;
		Cell cell = sh.getRow(rnum).getCell(cnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			data = cell.getStringCellValue();
			break;
		case NUMERIC:
			data = Integer.toString((int) cell.getNumericCellValue());
			break;
		default:
			data = "";
			break;
		}
		return data;
	}

	public String[][] getSheetData(String folderName, String fileName, String sheetName) {
		openExcel(folderName, fileName, sheetName);
		int nor = rowCount();
		int noc = columnCount();
		String[][] data = new String[nor][noc];
		for (int i = 1; i < nor + 1; i++) {
			for (int j = 0; j < noc; j++) {
				data[i - 1][j] = readData(i, j);
			}
		}
		return data;
	}
}
