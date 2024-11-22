package com.gestion.gestion_usuarios.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.gestion_usuarios.dao.ClubRepository;
import com.gestion.gestion_usuarios.dao.UsuarioRepository;
import com.gestion.gestion_usuarios.entity.Club;
import com.gestion.gestion_usuarios.dto.ClubDto;

public class ClubServicio {
	
	 @Autowired
	    private ClubRepository clubRepository; // Inyectamos el repositorio
	
	  /**
     * Da de alta un nuevo club en la base de datos.
     * <p>
     * Convierte un objeto {@link ClubDto} a {@link Club} y lo guarda en la base de datos.
     * </p>
     *
     * @param clubDto datos del club que se desea dar de alta
     */

    @Transactional
    public void altaClub(ClubDto clubDto) {
        // Convertir ClubDto a Club sin establecer idClub
        Club club = new Club();
        club.setNombreClub(clubDto.getNombreClub());
        club.setEmailClub(clubDto.getEmailClub());
        club.setPasswdClub(clubDto.getPasswdClub());
        club.setSedeClub(clubDto.getSedeClub());
        club.setImagenClub(clubDto.getImagenClub());
        
        // Guardar el club en la base de datos
        clubRepository.save(club);
    }

    /**
     * Elimina un club existente de la base de datos usando el nombre del club.
     *
     * @param nombreClub nombre del club que se desea eliminar
     */

    @Transactional
    public void eliminarClub(String nombreClub) {
        clubRepository.deleteByNombreClub(nombreClub);
    }
    
    /**
     * Modifica los campos nombre, sede e imagen de un club existente en la base de datos.
     *
     * @param idClub identificador del club a modificar
     * @param clubDto objeto DTO que contiene los nuevos datos del club
     * @return un {@link Optional<ClubDto>} con los datos actualizados si la modificación fue exitosa; de lo contrario, un Optional vacío
     */
    @Transactional
    public boolean modificarClub(long idClub, String nuevoNombre, String nuevaSede, byte[] nuevaImagen) {
        Optional<Club> clubOpt = clubRepository.findByIdClub(idClub);

        if (clubOpt.isPresent()) {
            Club club = clubOpt.get();
            // Modificar los campos
            if (nuevoNombre != null) club.setNombreClub(nuevoNombre);
            if (nuevaSede != null) club.setSedeClub(nuevaSede);
            if (nuevaImagen != null) club.setImagenClub(nuevaImagen);

            clubRepository.save(club); // Guardar los cambios
            return true;
        }

        return false; // Si el club no existe
    }

}
