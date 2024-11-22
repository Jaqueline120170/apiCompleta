package com.gestion.gestion_usuarios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import com.gestion.gestion_usuarios.dto.ClubDto;
import jakarta.persistence.Column;

/**
 * Clase que representa la entidad Club en la base de datos.
 * <p>
 * Esta clase contiene los atributos que definen a un club, como su nombre,
 * email, contraseña, sede y una imagen. Está mapeada como una entidad JPA para 
 * facilitar su persistencia en la base de datos.
 * </p>
 */
@Entity // Indica que esta clase es una entidad JPA
//@Table(name = "clubs", schema= "public")
public class Club {

    /** Identificador único del club, generado automáticamente. */
    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
    private long idClub;

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
    private String Rol;

    
    
    /******************************* GETTERS Y SETTERS **************************************/
	public long getIdClub() {
		return idClub;
	}

	public void setIdClub(long idClub) {
		this.idClub = idClub;
	}

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