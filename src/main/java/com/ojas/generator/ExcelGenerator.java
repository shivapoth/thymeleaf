package com.ojas.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ojas.entity.UserEntity;

public class ExcelGenerator {

	public static boolean excelReport(List<UserEntity> users) {

		HSSFWorkbook workbook = new HSSFWorkbook();

		boolean flag = false;

		try {
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\sp22282\\Documents\\userlistexcel.xls"));

			HSSFSheet sheet = workbook.createSheet("sheet1");
			int rownum = 0;
			for (UserEntity u : users) {
				Row row = sheet.createRow(rownum++);
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);
				Cell cell5 = row.createCell(4);
				cell1.setCellValue((String) u.getFisrtName());
				cell2.setCellValue((String) u.getLastName());
				cell3.setCellValue((String) u.getSurName());
				cell4.setCellValue(u.getDateOfBirth());
				cell5.setCellValue((String) u.getCityName());

			}

			try {
				workbook.write(out);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println("Excel Successfully generated");

		return flag;
	}

}
