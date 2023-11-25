package com.GSPELEAPI.gspeleapi.service;

import com.GSPELEAPI.gspeleapi.beans.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    String createUsuario(Usuario usuario);
    String updateUsuario(Usuario usuario);
    String deleteUsuario(Integer id);
    Optional<Usuario> getUsuario(Integer id);
    List<Usuario> getAllUsuario();
    Optional<Usuario> findByEmail(String email);
    Integer login(String email, String senha);
    Integer register(Usuario usuario);

}
