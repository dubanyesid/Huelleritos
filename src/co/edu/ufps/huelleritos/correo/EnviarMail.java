/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.huelleritos.correo;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian I
 */
public class EnviarMail {

    public boolean SendMail(Correo c) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", c.getUsuarioCorreo());
            props.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMensaje());
            BodyPart adjunto = new MimeBodyPart();
            if (!c.getRutaArchivo().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
                adjunto.setFileName(c.getNombreArchivo());
            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            if (!c.getRutaArchivo().equals("")) {
                m.addBodyPart(adjunto);
            }
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
            mensaje.setSubject(c.getAdjunto());
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(c.getUsuarioCorreo(), c.getContrasena());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }

    public void enviar(String destino, int identificacion) {

    	UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().split("-")[0];
    	
        String usuarioCorreo="huelleritosfundacion@gmail.com";
        String aux="Huelleritos3259";
        String nombreArchivo = "recibo-"+identificacion+"-"+uuidAsString+".pdf";
        String mensaje = "Deseamos hacerle llegar los datos del animal";
        String adjunto = "HUELLERITOS FUNDACION";
        File destinoArchivo = new File(nombreArchivo);
        String rutaArchivo = String.valueOf(destinoArchivo);

        Correo c = new Correo(usuarioCorreo, nombreArchivo, aux, rutaArchivo, destino, mensaje, adjunto);

        if (this.SendMail(c)) {
            JOptionPane.showMessageDialog(null, "Mensaje Enviado");
        } else {
            JOptionPane.showMessageDialog(null, "Mensaje no Enviado");
        }
    }
}
