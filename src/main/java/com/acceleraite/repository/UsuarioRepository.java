package com.acceleraite.repository;

import com.acceleraite.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(
            value = "select * from usuario where correo = :correo and password = :password",
            nativeQuery = true
    )
    Usuario findByEmailAndPassword(@Param("correo") String correo, @Param("password") String password);

}
