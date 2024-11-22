package com.gestion.gestion_usuarios.servicios;

import com.gestion.gestion_usuarios.dao.UsuarioRepository;
import com.gestion.gestion_usuarios.entity.Usuario;  // Cambiar DTO a entidad

import com.gestion.gestion_usuarios.dto.UsuarioDto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository; // Inyectamos el repositorio
    

    public ResponseEntity<String> validarCredenciales(String email, String password) {
        // Intentamos recuperar al usuario por su email
        Usuario usuario = usuarioRepository.findByEmail(email); // Usamos la entidad Usuario
        
        if (usuario == null) {
            System.out.println("Usuario no encontrado para el email: " + email);
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        System.out.println("Usuario encontrado: " + usuario.getEmail());
        System.out.println("Contraseña almacenada: " + usuario.getPassword());
        System.out.println("Contraseña recibida: " + password);

        // Aquí comparamos la contraseña directamente
        if (!password.equals(usuario.getPassword())) {
            System.out.println("Contraseña incorrecta");
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        // Si las credenciales son correctas, utilizamos el rol directamente desde la base de datos
        String rol = usuario.getRol(); // Obtenemos el rol desde la entidad
        System.out.println("Rol recuperado desde la base de datos: " + rol);

        return ResponseEntity.ok(rol);  // Devolvemos el rol
    }
    
    /**
     * Da de alta un nuevo usuario en la base de datos.
     * <p>
     * Convierte un objeto {@link UsuarioDto} a {@link Usuario} y lo guarda en la base de datos.
     * </p>
     *
     * @param usuarioDto datos del usuario que se desea dar de alta
     */
    
    @Transactional
    public void altaUsuario(UsuarioDto usuarioDto) {
        // Convertir UsuarioDto a Usuario sin establecer idUsuario
        Usuario usuario = new Usuario();
        usuario.setNicknameUsuario(usuarioDto.getNicknameUsuario());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setDniUsuario(usuarioDto.getDniUsuario());
        usuario.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuario.setFotoUsuario(usuarioDto.getFotoUsuario());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setRol(usuarioDto.getRol());

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
    }
    
    /**
     * Elimina un usuario existente de la base de datos usando el nickname del usuario.
     *
     * @param nicknameUsuario nickname del usuario que se desea eliminar
     */
    @Transactional
    public void eliminarUsuario(String nicknameUsuario) {
        usuarioRepository.deleteByNicknameUsuario(nicknameUsuario);
    }
    
    /**
     * Modifica los campos nombre, teléfono e imagen de un usuario existente en la base de datos.
     *
     * @param idUsuario identificador del usuario a modificar
     * @param nuevoNombre nuevo nombre del usuario (opcional)
     * @param nuevoTelefono nuevo teléfono del usuario (opcional)
     * @param nuevaFoto nueva foto del usuario (opcional)
     * @return true si la modificación fue exitosa; de lo contrario, false
     */
    @Transactional
    public boolean modificarUsuario(long idUsuario, String nuevoNombre, String nuevoTelefono, byte[] nuevaFoto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // Modificar los campos si se proporcionan valores no nulos
            if (nuevoNombre != null) usuario.setNombreUsuario(nuevoNombre);
            if (nuevoTelefono != null) usuario.setTelefonoUsuario(nuevoTelefono);
            if (nuevaFoto != null) usuario.setFotoUsuario(nuevaFoto);

            usuarioRepository.save(usuario); // Guardar los cambios
            return true;
        }

        return false; // Si el usuario no existe
    }
}
