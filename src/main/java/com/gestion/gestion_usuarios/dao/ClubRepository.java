package com.gestion.gestion_usuarios.dao;

import java.util.Optional;

import com.gestion.gestion_usuarios.entity.Club;

public interface ClubRepository {
	
	/**
     * Elimina un club por su nombre.
     *
     * @param nombreClub El nombre del club a eliminar.
     */
    void deleteByNombreClub(String nombreClub);

    /**
     * Encuentra un club por su email y contraseña.
     *
     * @param emailClub El email del club.
     * @param passwdClub La contraseña del club.
     * @return Un Optional que contiene el club encontrado, si existe.
     */
    Optional<Club> findByEmailClubAndPasswdClub(String emailClub, String passwdClub);
    
    Optional<Club> findByIdClub(Long idClub); // Encuentra un club por su ID
    // Método para encontrar un club por su email
    Optional<Club> findByEmailClub(String emailClub);

	void save(Club club);

}
