package com.ojas.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.entity.UserEntity;

public class PdfGenetator {
	public static boolean GeneratePdf(List<UserEntity> userList) {
		boolean flag = false;
		try {
			// Create Document instance.
			Document document = new Document();

			// Create OutputStream instance.
			FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\HP\\OneDrive\\Desktop\\userlist.pdf"));

			// Create PDFWriter instance.
			PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			// Add content to the document.
			userList.stream().forEach(u -> {
				try {
					document.add(new Paragraph(u.getFisrtName() + "\t" + u.getLastName() + "\t" + u.getSurName() + "\t"
							+ u.getDateOfBirth() + "\t" + u.getCityName()));
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			});
			document.add(new Paragraph("Hello world, " + "this is a test pdf file."));

			// Close document and outputStream.
			document.close();
			outputStream.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
