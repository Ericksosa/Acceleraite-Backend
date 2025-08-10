package com.acceleraite.repository;

import com.acceleraite.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.correo = :correo AND u.password = :password")
    Usuario findByCorreoAndPassword(@Param("correo") String correo, @Param("password") String password);
}