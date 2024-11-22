package com.gestion.gestion_usuarios.dto;

import java.util.Arrays;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) para la entidad Club.
 * <p>
 * Esta clase se utiliza para transferir datos entre la API y la capa de servicio, 
 * aislando la lógica de la entidad principal y proporcionando solo los datos necesarios.
 * </p>
 */
public class ClubDto {
    
    /** Nombre del club. */
    private String nombreClub;
    
    /** Email de contacto del club. */
    private String emailClub;
    
    /** Contraseña del club para autenticación. */
    private String passwdClub;
    
    /** Sede del club. */
    private String sedeClub;
    
    /** Imagen del club en formato de bytes. */
    private byte[] imagenClub;
    
    /** Administrador del sitio. */
    public String Rol;

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public String getEmailClub() {
		return emailClub;
	}

	public void setEmailClub(String emailClub) {
		this.emailClub = emailClub;
	}

	public String getPasswdClub() {
		return passwdClub;
	}

	public void setPasswdClub(String passwdClub) {
		this.passwdClub = passwdClub;
	}

	public String getSedeClub() {
		return sedeClub;
	}

	public void setSedeClub(String sedeClub) {
		this.sedeClub = sedeClub;
	}

	public byte[] getImagenClub() {
		return imagenClub;
	}

	public void setImagenClub(byte[] imagenClub) {
		this.imagenClub = imagenClub;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}

   
}
