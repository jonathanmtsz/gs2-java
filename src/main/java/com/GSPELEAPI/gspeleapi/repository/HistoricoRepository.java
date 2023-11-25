package com.GSPELEAPI.gspeleapi.repository;

import com.GSPELEAPI.gspeleapi.beans.Historico;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
    Historico findByUsuario (Usuario usuario);
}
