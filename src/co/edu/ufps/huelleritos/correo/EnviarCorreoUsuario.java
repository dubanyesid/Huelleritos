package co.edu.ufps.huelleritos.correo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.Usuario;

public class EnviarCorreoUsuario {

	private Correo correo;
	private EnviarMail enviar;
	private GenerarPDF generarPDF;

	public EnviarCorreoUsuario() {
		super();
		this.generarPDF=new GenerarPDF();
		this.enviar=new EnviarMail();
	}

	public EnviarCorreoUsuario(Correo correo, EnviarMail enviar, GenerarPDF generarPDF) {
		super();
		this.correo = correo;
		this.enviar = enviar;
		this.generarPDF = generarPDF;
	}

	public boolean enviarCorreo(String nombreArchivo, String rol, Usuario us, Formulario formulario) {
		System.out.println("dadssada");
		boolean creado=false;
		boolean enviado=false;
		try {
			System.out.println("antes");
			Formulario f = new Formulario(123, "Juan", "Sanchez", "juansebasprada07@gmail.com", "3219810616",
					new Date());
			System.out.println("ddes");

			correo = new Correo("huelleritosfundacion@gmail.com", nombreArchivo, "Huelleritos3259", "", formulario.getCorreo(),
					"Se adjunta información sobre la solicitud.", "Solicitud " + rol);

			creado=generarPDF.generarPDF(nombreArchivo, rol, us, formulario);

			correo.setRutaArchivo(new File(nombreArchivo).toString());

			enviado=enviar.SendMail(correo);

		} catch (FileNotFoundException e) {
			System.err.println("FILENOFOUND");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOEXCEPTION");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("INTERRUPTED");
			e.printStackTrace();
		}
		return creado&&enviado;
	}

	public Correo getCorreo() {
		return correo;
	}

	public void setCorreo(Correo correo) {
		this.correo = correo;
	}

	public EnviarMail getEnviar() {
		return enviar;
	}

	public void setEnviar(EnviarMail enviar) {
		this.enviar = enviar;
	}

	public GenerarPDF getGenerarPDF() {
		return generarPDF;
	}

	public void setGenerarPDF(GenerarPDF generarPDF) {
		this.generarPDF = generarPDF;
	}

}
