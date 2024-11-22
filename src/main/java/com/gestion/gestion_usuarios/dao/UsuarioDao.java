package com.gestion.gestion_usuarios.dao;

import com.gestion.gestion_usuarios.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UsuarioDto obtenerUsuarioPorEmail(String email) {
        String sql = "SELECT email, password, rol FROM usuarios WHERE email = ?";
        
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                UsuarioDto usuario = new UsuarioDto();
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                return usuario;
            });
        } catch (Exception e) {
            // Si no se encuentra el usuario o hay algún error, devolver null
            return null;
        }
    }
}
