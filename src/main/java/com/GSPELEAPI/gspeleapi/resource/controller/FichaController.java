package com.GSPELEAPI.gspeleapi.resource.controller;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.service.FichaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pele/ficha")
public class FichaController {
    FichaService fichaService;



    @PutMapping("/atualizar")
    public String updateFicha (@RequestBody Ficha ficha){
        fichaService.createFicha(ficha);
        return "Ficha atualizada com sucesso";
    }

    @GetMapping("/{id_ficha}")
    public Optional<Ficha> getById_ficha (@RequestParam("id_ficha") Integer id_ficha){
        return fichaService.getFicha(id_ficha);
    }

    @PostMapping("/criarficha")
    public String createFicha (@RequestBody Ficha ficha){
        fichaService.createFicha(ficha);
        return "Ficha criada e salva!";
    }

    @DeleteMapping("/delete")
    public String deleteFicha (@RequestParam("id_ficha") Integer id_ficha){
        fichaService.deleteFicha(id_ficha);
        return "Ficha Deletada!!";
    }

}
