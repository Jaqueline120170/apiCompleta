package com.gestion.gestion_usuarios.dto;

public class UsuarioDto {

	private String nicknameUsuario;
	private String nombreUsuario;
	private String dniUsuario;
	private String telefonoUsuario;
	private byte[] fotoUsuario;
    private String email;
    private String password;
    private String rol;
    
    
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

    // Getters y setters

   
}
