package com.gestion.gestion_usuarios.controladores;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestion_usuarios.dto.ClubDto;
import com.gestion.gestion_usuarios.servicios.ClubServicio;

import jakarta.persistence.EntityNotFoundException;

public class ClubControlador {
	
	private final ClubServicio clubServicio = new ClubServicio();
	/**
     * Endpoint para crear un nuevo club.
     * <p>
     * Recibe un {@link ClubDto} en el cuerpo de la solicitud, y si es exitoso,
     * devuelve una respuesta HTTP 201 (Created). En caso de error, devuelve
     * un mensaje de error con el estado correspondiente.
     * </p>
     *
     * @param clubDto datos del club a crear
     * @return ResponseEntity con el mensaje de éxito o error
     */

    @PostMapping
    public ResponseEntity<String> crearClub(@RequestBody ClubDto clubDto) {
        try {
            clubServicio.altaClub(clubDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Club creado con éxito.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el club: " + e.getMessage());
        }
    }
    
    /**
     * Endpoint para eliminar un club por su nombre.
     * <p>
     * Si el club existe, lo elimina y devuelve un mensaje de éxito con el estado HTTP 200 (OK).
     * Si el club no es encontrado, devuelve un estado HTTP 404 (Not Found).
     * </p>
     *
     * @param nombreClub nombre del club a eliminar
     * @return ResponseEntity con el mensaje de éxito o error
     */
    @DeleteMapping("/{nombreClub}")
    public ResponseEntity<String> eliminarClub(@PathVariable String nombreClub) {
        try {
            eliminarClub(nombreClub);
            return ResponseEntity.ok("Club eliminado con éxito.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Club no encontrado: " + nombreClub);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el club: " + e.getMessage());
        }
    }

}
