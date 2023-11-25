package com.GSPELEAPI.gspeleapi.service.impl;

import com.GSPELEAPI.gspeleapi.beans.Historico;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.repository.HistoricoRepository;
import com.GSPELEAPI.gspeleapi.service.HistoricoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoServiceImpl implements HistoricoService {
    HistoricoRepository historicoRepo;

    public HistoricoServiceImpl(HistoricoRepository historicoRepo){
        this.historicoRepo = historicoRepo;
    }
    @Override
    public Historico createHistorico(Historico historico) {
        return historicoRepo.save(historico);
    }

    @Override
    public String updateHistorico(Historico historico) {
        historicoRepo.save(historico);
        return "Atualizado com sucesso";
    }

    @Override
    public String deleteHistorico(Integer id) {
        historicoRepo.deleteById(id);
        return "Deletado com sucesso";
    }

    @Override
    public Optional<Historico> getHistorico(Integer id) {
        return historicoRepo.findById(id);
    }

    @Override
    public List<Historico> getAllHistorico() {
        return historicoRepo.findAll();
    }

    @Override
    public Historico findByUsuario(Usuario usuario) {
        return historicoRepo.findByUsuario(usuario);
    }

}
