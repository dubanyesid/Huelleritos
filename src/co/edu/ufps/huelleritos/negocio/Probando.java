package co.edu.ufps.huelleritos.negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import co.edu.ufps.huelleritos.correo.Correo;
import co.edu.ufps.huelleritos.correo.EnviarCorreoUsuario;
import co.edu.ufps.huelleritos.correo.EnviarMail;
import co.edu.ufps.huelleritos.correo.GenerarPDF;
import co.edu.ufps.huelleritos.correo.Mail;
import co.edu.ufps.huelleritos.dao.*;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.Usuario;

public class Probando {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * List<Puntaje> puntajes =new ArrayList<>(); Formulario f =new
		 * Formulario("alguien", "2131", "3232", "fdssdf", null, "sasa", "g211");
		 * Formulario f1 =new Formulario("hlguien", "2121", "7232", "adssdf", null,
		 * "aasa", "e211"); Formulario f2 =new Formulario("clguien", "21w1", "5232",
		 * "dfdssdf", null, "eeasa", "f211");
		 * 
		 * puntajes.add(new Puntaje(f,19)); puntajes.add(new Puntaje(f1,32));
		 * puntajes.add(new Puntaje(f2,23));
		 * 
		 * System.out.println(puntajes);
		 * 
		 * Collections.sort(puntajes, new Comparator<Puntaje>() {
		 * 
		 * @Override public int compare(Puntaje p1, Puntaje p2) { return
		 * p1.getPuntaje().compareTo(p2.getPuntaje()); } });
		 */

		/*
		 * String[]list = new PreguntaDAO().listPreguntas(2);
		 * 
		 * System.out.println(list.length); String[] datos=null; for(String s:list) {
		 * datos=s.split(";");
		 * System.out.println("Pregunta: "+datos[0]+", Respuesta: "+datos[1]+"\n"); }
		 * 
		 */

		/*
		 * Correo correo = new Correo(); EnviarMail em = new EnviarMail(); GenerarPDF gp
		 * = new GenerarPDF(); EnviarCorreoUsuario ec = new EnviarCorreoUsuario();
		 * 
		 * Usuario us = new Usuario("admin", "1234"); Formulario f = new Formulario(123,
		 * "Yurley", "Espinel", "yurleygabrielaes@ufps.edu.co", "3219810616", new
		 * Date()); ec.enviarCorreo("informacionHuelleritos.pdf", "Adoptante", "Coco",
		 * us, f);
		 */

		// Mail m = new Mail();

		Animal listAnimales= new AnimalDAO().buscarAnimalPorFormulario("2");
		// m.enviarEmail("juandavidsm@ufps.edu.co", "Que paso lk", "esto es una
		// prueba");
		// em.enviar("juandavidsm@ufps.edu.co", "Que paso lk", 1119323413);

	}
}
