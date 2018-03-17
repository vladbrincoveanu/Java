package bll;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Produs;
import model.Student;
import java.io.FileOutputStream;
import java.io.IOException;

public class ToPdf {

    public void createPdf(String filename,PdfPTable table)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(table);
        // step 5
        document.close();
    }

    public PdfPTable createFirstTable(int contorChitante, Student st, Produs p, int cantitate) {
        // a table with three columns
        PdfPTable table = new PdfPTable(4);
        // the cell object
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Chitanta [" + contorChitante + "] ---- "));
        cell.setColspan(4);
        //cell.setRowspan(3);
        table.addCell(cell);
        table.addCell("Nume");
        table.addCell("Adresa");
        table.addCell("Email");
        table.addCell("Varsta");
        table.addCell(st.getName());
        table.addCell( st.getAddress());
        table.addCell(st.getEmail());
        table.addCell(String.valueOf(st.getAge()));

        cell = new PdfPCell(new Phrase("Informatii produs achizitionat"));
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("Nume");
        table.addCell("Cantitate");
        table.addCell(" ");
        table.addCell(" ");
        System.out.println(p.getName()+cantitate);
        table.addCell(p.getName());
        table.addCell(String.valueOf(cantitate));
        return table;
    }
}
