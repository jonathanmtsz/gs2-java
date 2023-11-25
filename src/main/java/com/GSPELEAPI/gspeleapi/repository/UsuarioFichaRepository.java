package com.GSPELEAPI.gspeleapi.repository;

import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.beans.UsuarioFicha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioFichaRepository extends JpaRepository<UsuarioFicha, Integer> {
    String findByUsuario (Usuario usuario);
}
