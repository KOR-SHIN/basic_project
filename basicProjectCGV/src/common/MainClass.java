package common;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {
	
	// 파일이 생성되는 경로
	private static String FILE = "D:/CGV_ticket_pdf.pdf";

	// 사용할 폰트를 미리 지정하는 부분
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);
	private static String admin = "신광진";

	public static void main(String[] args) {
		ViewClass v = new ViewClass();
		v.run();



		try {
			// BaseFont bFont = BaseFont.createFont("fonts/malgun.ttf",
			// BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// Font font = new Font(bFont, 12);

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();

			CraftPDF.addMetaData(document); // insert MetaData
			CraftPDF.addImage(document); // insert Image
			CraftPDF.addTitlePage(document); // insert content
			document.close(); // closeDocument

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
		
		
	}
}
