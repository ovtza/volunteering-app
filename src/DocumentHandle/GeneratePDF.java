package DocumentHandle;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Database.SelectRecords;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class GeneratePDF {
    private static String FILE;
    private static Font catFont = new Font(Font.FontFamily.COURIER, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.COURIER, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.COURIER, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.COURIER, 12,
            Font.BOLD);

    public static void createPDF(String path, String title) {
        FILE = path;

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(title, document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Wolontariat");
        document.addSubject("Raport");
        document.addKeywords("Java, PDF, Wolontariat");
        document.addAuthor(System.getProperty("user.name"));
        document.addCreator(System.getProperty("user.name"));
    }

    private static void addTitlePage(String title, Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);

        preface.add(new Paragraph(title, catFont));

        addEmptyLine(preface, 1);

        preface.add(new Paragraph(
                "Raport wygenerowany przez: " + System.getProperty("user.name") + ", " + new Date(),
                smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph(
                "Raport",
                smallBold));

        String sql = "SELECT * FROM " + title;
        int count = 0;
        try {
            SelectRecords app = new SelectRecords();
            Connection conn = app.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            addEmptyLine(preface, 1);

            while (rs.next()) {
                count++;
                preface.add(new Paragraph("ID puszki: " +
                        String.valueOf(rs.getInt("id")),
                        smallBold));
                preface.add(new Paragraph("Nazwa puszki: " +
                        String.valueOf(rs.getString("nazwa")),
                        smallBold));
                preface.add(new Paragraph("Kod puszki: " +
                        String.valueOf(rs.getString("kod")),
                        smallBold));
                                preface.add(new Paragraph("Rodzaj puszki: " +
                        String.valueOf(rs.getString("rodzaj")),
                        smallBold));
                addEmptyLine(preface, 1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Ilosc: " + count,
                smallBold));
        addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "Wygenerowano przy uzyciu Wolontariat 1.1",
                redFont));

        document.add(preface);

        document.newPage();
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}