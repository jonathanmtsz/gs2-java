package com.GSPELEAPI.gspeleapi.service;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.repository.UsuarioFichaRepository;

public interface UsuarioFichaService {
    void associarUsuarioFicha(Usuario usuario, Ficha ficha);
}
