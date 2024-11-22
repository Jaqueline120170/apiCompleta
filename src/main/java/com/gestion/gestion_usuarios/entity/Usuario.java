package com.gestion.gestion_usuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "usuario", schema = "gestion")  // Especifica el esquema "gestion"
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
    private Long id;  
    private String nicknameUsuario;
    private String nombreUsuario;
    private String dniUsuario;
    private String telefonoUsuario;
    private byte[] fotoUsuario;
    private String email;
    private String password;
    private String rol;
    
    // Getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNicknameUsuario() {
		return nicknameUsuario;
	}
	public void setNicknameUsuario(String nicknameUsuario) {
		this.nicknameUsuario = nicknameUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public byte[] getFotoUsuario() {
		return fotoUsuario;
	}
	public void setFotoUsuario(byte[] fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

  

   
}
