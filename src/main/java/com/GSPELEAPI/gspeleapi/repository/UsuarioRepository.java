package com.GSPELEAPI.gspeleapi.repository;

import com.GSPELEAPI.gspeleapi.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

}
