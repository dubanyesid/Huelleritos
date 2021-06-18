package co.edu.ufps.huelleritos.correo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.Usuario;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
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

    public boolean generarPDF(String nombreArchivo, String rol, File img, String nombreAnimal ,Usuario us, Formulario formulario) throws FileNotFoundException, IOException, InterruptedException {

        FileOutputStream f = new FileOutputStream(nombreArchivo);

        PdfWriter writer = new PdfWriter(f);
        PdfDocument pdfDoc = new PdfDocument(writer);

        Document document = new Document(pdfDoc, PageSize.A4);
        document.setMargins(50, 30, 20, 30);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

        try {
        	System.out.println("a");
        	Paragraph hue = new Paragraph("HUELLERITOS FUNDACIÓN").setFont(font1);
        	hue.setTextAlignment(TextAlignment.CENTER);
        	hue.setFontSize(36f);
        	System.out.println("n");
        	String[] fe=LocalDateTime.now().toString().split("T");
        	Paragraph fecha = new Paragraph("Fecha: "+fe[0]+" "+fe[1].substring(0,8)).setFont(font1);
        	Paragraph pTitulo = new Paragraph("Hola, "+formulario.getNombre()+"\n").setFont(font1);
            Paragraph pCuerpo = new Paragraph("Estamos felices de que te hayas unido a esta hermosa fundación, esperemos que nuestro huellerito "+ nombreAnimal+" y tú sean muy felices juntos.\n\n"
            		+ "Gracias al formulario que rellenó, se pudo valorar que si es apto por lo que se le generó el siguiente usuario:\n").setFont(font);               
            Paragraph infoUsuario = new Paragraph("Nombre de usuario: "+us.getUsuario()+"\nContraseña: "+us.getContraseña()).setFont(font1);
            Paragraph rolUser = new Paragraph("También se le hace saber que el usuario y usted pertenecen al rol de "+'"'+rol+'"'+", favor tener en cuenta lo anterior.").setFont(font);
            Paragraph despedida = new Paragraph("\nMuchas gracias por su granito de arena.\nAtt: Natalia Ortiz").setFont(font1);
            ImageData data = ImageDataFactory.create(img.getAbsolutePath());
            System.out.println(data.toString());
            Image imga = new Image(data).setFontSize(28f); 
            // Adding paragraphs to document       

            document.add(imga.setTextAlignment(TextAlignment.LEFT));
            document.add(hue);       
            document.add(fecha.setTextAlignment(TextAlignment.RIGHT));
            document.add(pTitulo);
            document.add(pCuerpo.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(infoUsuario.setTextAlignment(TextAlignment.JUSTIFIED));

            document.add(rolUser.setTextAlignment(TextAlignment.JUSTIFIED));
            document.add(despedida.setTextAlignment(TextAlignment.JUSTIFIED));
            document.close();

        } catch (Exception ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

       return new File(nombreArchivo).exists();
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