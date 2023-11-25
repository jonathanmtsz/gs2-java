package com.GSPELEAPI.gspeleapi.service.impl;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.beans.UsuarioFicha;
import com.GSPELEAPI.gspeleapi.repository.UsuarioFichaRepository;
import com.GSPELEAPI.gspeleapi.service.UsuarioFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioFichaServiceImpl implements UsuarioFichaService {
    @Autowired
    UsuarioFichaRepository usuarioFichaRepository;

    @Override
    public void associarUsuarioFicha(Usuario usuario, Ficha ficha) {
        UsuarioFicha usuarioFicha = new UsuarioFicha(usuario, ficha);
        usuarioFichaRepository.save(usuarioFicha);
    }

}
