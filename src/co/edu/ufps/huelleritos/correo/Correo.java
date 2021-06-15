/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.huelleritos.correo;

/**
 *
 * @author Sebastian I
 */
public class Correo {
    private String usuarioCorreo;
    private String nombreArchivo;
    private String contrasena;
    private String rutaArchivo;
    private String destino;
    private String mensaje;
    private String adjunto;

    public Correo() {
    }

    public Correo(String usuarioCorreo, String nombreArchivo, String contrasena,
            String rutaArchivo, String destino, String mensaje,
            String adjunto) {
        this.usuarioCorreo = usuarioCorreo;
        this.nombreArchivo = nombreArchivo;
        this.contrasena = contrasena;
        this.rutaArchivo = rutaArchivo;
        this.destino = destino;
        this.mensaje = mensaje;
        this.adjunto=adjunto;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }
}
