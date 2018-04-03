package com.selenium.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static FileInputStream excelFile;
	private static String filePath;

	// This method is used to set the File path and to open the Excel file
	public static void setExcelFile() {

		try {
			String workingDir = System.getProperty("user.dir");
			filePath = workingDir + File.separator + "src" + File.separator + "agent_registration.xlsx";
			excelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet("agent");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// This method is used to read the test data from the Excel cell, in this we
	// are passing parameters as Row number and Column number and return the
	// cell value

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			// fill the code here
			String cellVal = "";
			// FormulaEvaluator evaluator = ExcelWBook.getCreationHelper()
			// .createFormulaEvaluator();
			CellReference cellRef = new CellReference(RowNum, ColNum);
			Row = ExcelWSheet.getRow(cellRef.getRow());
			Cell = Row.getCell(cellRef.getCol());
			if (Cell != null) {
				switch (Cell.getCellType()) {
				case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:
					cellVal = String.valueOf(Cell.getBooleanCellValue());
					break;
				case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
					cellVal = String.valueOf(Cell.getNumericCellValue());
					break;
				case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
					cellVal = Cell.getStringCellValue();
					break;
				default:
					break;

				}
			}
			return cellVal;
		} catch (Exception e) {
			throw e;
		}
	}

	public static void writeCell(int RowNum, int ColNum, String message) throws Exception {
		// CellReference cellRef = new CellReference(RowNum, ColNum);
		Row = ExcelWSheet.getRow(RowNum);
		Cell = Row.getCell(ColNum);
		if (Cell == null) {
			Cell = Row.createCell(ColNum);
		}
		Cell.setCellValue(message);
		try {
			FileOutputStream outStream = new FileOutputStream(filePath);
			ExcelWBook.write(outStream);
			outStream.close();
			ExcelWBook = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			throw e;
		}
	}

}