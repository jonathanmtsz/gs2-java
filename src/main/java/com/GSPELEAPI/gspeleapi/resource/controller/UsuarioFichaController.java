package com.GSPELEAPI.gspeleapi.resource.controller;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.service.FichaService;
import com.GSPELEAPI.gspeleapi.service.UsuarioFichaService;
import com.GSPELEAPI.gspeleapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pele/usuarioficha")
public class UsuarioFichaController {

    FichaService fichaService;
    UsuarioService usuarioService;
    UsuarioFichaService usuarioFichaService;

    public UsuarioFichaController(FichaService fichaService, UsuarioService usuarioService, UsuarioFichaService usuarioFichaService) {
        this.fichaService = fichaService;
        this.usuarioService = usuarioService;
        this.usuarioFichaService = usuarioFichaService;
    }


    @PostMapping("/associar")
    public String associarUsuarioEFicha(@RequestParam Integer idUsuario, @RequestParam Integer idFicha) {
        Optional<Usuario> usuario = usuarioService.getUsuario(idUsuario);
        Optional<Ficha> ficha = fichaService.getFicha(idFicha);

        if (usuario.isPresent() && ficha.isPresent()) {
            usuarioFichaService.associarUsuarioFicha(usuario.get(), ficha.get());
            return "Associação criada com sucesso.";
        } else {
            return "Usuário ou ficha não encontrados.";
        }
    }

    @PostMapping("/criar/{id_usuario}")
    public String criarFicha(@RequestBody Ficha ficha,@PathVariable("id_usuario") Integer id_usuario){
        Optional<Usuario> usuario = usuarioService.getUsuario(id_usuario);
        if(usuario.isPresent()) {
            Ficha ficha_salva = fichaService.createFicha(ficha);
            associarUsuarioEFicha(id_usuario, ficha_salva.getId_ficha());
            return "Ficha associada ao usuario!";
        } else {
            return "Usuario não encontrado para criar a ficha!";
        }
    }

}
