package utils;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private File file;
	private Workbook workbook;
	private Sheet sheet;

	public ExcelReader(String path, String sheetName) throws EncryptedDocumentException, IOException {
		this.file = new File(path);
		this.workbook = WorkbookFactory.create(this.file);
		this.sheet = this.workbook.getSheet(sheetName);
	}

	/**
	 * This method is used to get last row of the sheet.
	 * @return <code>String</code>
	 */
	public int lastRowNumber() {
		return sheet.getLastRowNum();
	}

	/**
	 * This method is used to get last cell number of given of row.
	 * @param rowNumber         <code>int</code>
	 * @return lastColumnNumber <code>int</code>
	 */
	public int lastColunmNumberOfRow(int rowNumber) {
		return sheet.getRow(rowNumber).getLastCellNum();
	}

	/**
	 * This method is used to get string value of row and column of sheet.
	 * @param row        <code>int</code>
	 * @param column     <code>int</code>
	 * @return cellValue <code>int</code>
	 */
	public String getCellValue(int row, int column) {
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}

	/**
	 * This method is used to get all the cell value of the given particular row.
	 * @param rowNumber   <code>int</code>
	 * @return cellValues <code>List</code>
	 */
	public java.util.List<String> getAllValuesOfColumnOfRow(int rowNumber){
		java.util.List<String> cellValues = new ArrayList<String>();
		Row row = sheet.getRow(rowNumber);
		for(int i = 1; i <= row.getLastCellNum() ; i++) {
			cellValues.add(row.getCell(i).getStringCellValue());
		}
		return cellValues;
	}
	
	/**
	 * This method is used to get all the row value of the given particular column.
	 * @param rowNumber   <code>int</code>
	 * @return cellValues <code>List</code>
	 */
	public java.util.List<String> getAllValuesOfRowOfAnyColumn(int columnNumber){
		java.util.List<String> cellValues = new ArrayList<String>();
		int lastRow = sheet.getLastRowNum();
		for(int i = 1; i <= lastRow ; i++) {
			cellValues.add(sheet.getRow(i).getCell(columnNumber).getStringCellValue());
		}
		return cellValues;
	}
}