package com.GSPELEAPI.gspeleapi.resource.controller;

import com.GSPELEAPI.gspeleapi.beans.Historico;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.service.HistoricoService;
import com.GSPELEAPI.gspeleapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pele/historico")
public class HistoricoController {
    HistoricoService historicoService;

    UsuarioService usuarioService;

    @Autowired
    public HistoricoController(HistoricoService historicoService, UsuarioService usuarioService) {
        this.historicoService = historicoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Historico createHistorico(@RequestBody Historico historico) {
        return historicoService.createHistorico(historico);
    }
    @GetMapping("{idUsuario}")
    public Historico getHistoricoById(@PathVariable("idUsuario") Integer idUsuario){
        Optional<Usuario> usuario = usuarioService.getUsuario(idUsuario);
        if(usuario.isPresent()){
            return historicoService.findByUsuario(usuario.get());
        } else {
            return null;
        }
    }

    @GetMapping("/all")
    public List<Historico> getAll(){
        return historicoService.getAllHistorico();
    }

    @PutMapping
    public String updateHistorico(@RequestBody Historico historico){
        historicoService.updateHistorico(historico);
        return "Historico atualizado";
    }

    @DeleteMapping("{id_historico}")
    public String deleteHistorico(@PathVariable("id_historico") Integer id_historico){
        historicoService.deleteHistorico(id_historico);
        return "Historico deletado!!";
    }
}

