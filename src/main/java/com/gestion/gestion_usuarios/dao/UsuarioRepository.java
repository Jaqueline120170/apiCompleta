package com.gestion.gestion_usuarios.dao;

import com.gestion.gestion_usuarios.entity.Usuario;  // Asegúrate de que sea la entidad

import com.gestion.gestion_usuarios.entity.Club;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
    Usuario findByEmail(String email);  // Buscar usuario por email

	void deleteByEmailUsuario(String emailUsuario);//borrar por nickname
	

    
}
