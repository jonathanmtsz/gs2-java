package com.GSPELEAPI.gspeleapi.service.impl;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.repository.FichaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaServiceImpl implements com.GSPELEAPI.gspeleapi.service.FichaService {

    public FichaServiceImpl(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    FichaRepository fichaRepository;

    @Override
    public Ficha createFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    @Override
    public String updateFicha(Ficha ficha) {
        fichaRepository.save(ficha);
        return "Ficha atualizada";
    }

    @Override
    public String deleteFicha(Integer id_ficha) {
        fichaRepository.deleteById(id_ficha);
        return "Ficha deletada!";
    }

    @Override
    public Optional<Ficha> getFicha(Integer id_ficha) {
        return fichaRepository.findById(id_ficha);
    }

    @Override
    public List<Ficha> getAllFicha() {
        return fichaRepository.findAll();
    }
}
