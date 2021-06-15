package co.edu.ufps.huelleritos.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.edu.ufps.huelleritos.dao.*;
import co.edu.ufps.huelleritos.entities.Formulario;

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
		
		String[]list = new PreguntaDAO().listPreguntas(2);
		
	System.out.println(list.length);
		String[] datos=null;
			for(String s:list) {
				datos=s.split(";");
				System.out.println("Pregunta: "+datos[0]+", Respuesta: "+datos[1]+"\n");
			}

		

	}
}
