package com.GSPELEAPI.gspeleapi.service;

import com.GSPELEAPI.gspeleapi.beans.Historico;
import com.GSPELEAPI.gspeleapi.beans.Usuario;

import java.util.List;
import java.util.Optional;

public interface HistoricoService {
    Historico createHistorico(Historico historico);
    String updateHistorico(Historico historico);
    String deleteHistorico(Integer id);
    Optional<Historico> getHistorico(Integer id);
    List<Historico> getAllHistorico();
    Historico findByUsuario (Usuario usuario);
}
