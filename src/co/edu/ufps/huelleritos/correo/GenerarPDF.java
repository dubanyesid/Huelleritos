package co.edu.ufps.huelleritos.correo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian I
 */
public class GenerarPDF {

    public GenerarPDF() {

    }

    public void generarPDF(String nombreArchivo, String titulo, String cuerpo) throws FileNotFoundException, IOException, InterruptedException {

        FileOutputStream f = new FileOutputStream(nombreArchivo);
        PdfWriter writer = new PdfWriter(f);
        PdfDocument pdfDoc = new PdfDocument(writer);

        Document document = new Document(pdfDoc, PageSize.A1);
        document.setMargins(50, 30, 20, 30);
        //PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        //PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

        try {
        	Paragraph paragraph1 = new Paragraph(titulo);             
            Paragraph paragraph2 = new Paragraph(cuerpo);              
            
            // Adding paragraphs to document       
            document.add(paragraph1);       
            document.add(paragraph2);
            
            document.close();

        } catch (Exception ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        abrirPDF(nombreArchivo);
    }

    public void abrirPDF(String nombreArchivo) throws IOException {

        int respuesta = JOptionPane.showConfirmDialog(null, "Desea Imprimir PDF",
                "Seguimiento", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            File f = new File(nombreArchivo);
            
            Desktop.getDesktop().open(f);
        } else {
            JOptionPane.showMessageDialog(null, "No se abrirá el PDF");
        }
    }
}