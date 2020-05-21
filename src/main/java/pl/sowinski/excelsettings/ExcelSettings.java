package pl.sowinski.excelsettings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSettings {

	private static String value;

	public static void generateExcel(List<String> list, String titleOfSheet, int fontHeight, String columnName,
			String nameOfFile) {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(titleOfSheet);
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) fontHeight);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);

		Cell cell = headerRow.createCell(0);
		cell.setCellValue(columnName);
		cell.setCellStyle(headerCellStyle);

		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i);
			int size = value.length();
			sheet.autoSizeColumn(size);
		}

		int rowNum = 1;

		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(list.get(i));
		}

		sheet.autoSizeColumn(columnName.length());

		Row row = sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(value);

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(LocalDate.now().toString() + nameOfFile + ".xlsx");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fileOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void generateExcelWithEmailsAndPhones(List<String> list1, List<String> list2, String titleOfSheet,
			int fontHeight, String columnName, String nameOfFile) {
		final String[] nameOfColumns = { "Phones", "Emails" };

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(titleOfSheet);
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) fontHeight);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < nameOfColumns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(nameOfColumns[i]);
			cell.setCellStyle(headerCellStyle);
		}

	}

}
