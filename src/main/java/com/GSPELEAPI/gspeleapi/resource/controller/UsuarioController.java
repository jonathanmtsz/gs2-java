package com.GSPELEAPI.gspeleapi.resource.controller;

import com.GSPELEAPI.gspeleapi.beans.Historico;
import com.GSPELEAPI.gspeleapi.beans.Login;
import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.exceptions.ObjectNotFoundException;
import com.GSPELEAPI.gspeleapi.service.HistoricoService;
import com.GSPELEAPI.gspeleapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pele")
public class UsuarioController
{

    UsuarioService usuarioService;

    HistoricoService historicService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    public void HistoricoController(HistoricoService historicoService){
        this.historicService = historicoService;
    }


    //Encontrar detalhes especificos de UM usuario pelo ID
    @GetMapping("{usuarioId}")
    public Optional<Usuario> getUsuarioDetails(@PathVariable("usuarioId") Integer usuarioId){
        return usuarioService.getUsuario(usuarioId);
    }

    //Encontrar detalhes especificos de TODOS usuarios
    @GetMapping("all")
    public List<Usuario> getAllUsuarioDetails(){
        return usuarioService.getAllUsuario();
    }

    //Encontrar usuario por email
    @GetMapping("findEmail/{email}")
    public Optional<Usuario> findByEmail(@PathVariable("email") String email){
        if(usuarioService.findByEmail(email).isPresent()){
            return usuarioService.findByEmail(email);
        } else {
            throw new ObjectNotFoundException("Nenhum usuario com esse email!");
        }

    }

    @PostMapping("login")
    public Object login(@RequestBody Login login) {
        return usuarioService.login(login.getEmail(), login.getSenha());
    }
    //f
    @PostMapping("register")
    public Integer register(@RequestBody Usuario usuario) {
        return usuarioService.register(usuario);
    }

    @PostMapping
    public String createUsuarioDetails(@RequestBody Usuario usuario){
     usuarioService.createUsuario(usuario);
     return "Usuario criado com sucesso";
    }

    @PostMapping("atualizarhistorico/{id_usuario}")
    public String createHistorico(@RequestBody Historico historico, @PathVariable("id_usuario") Integer id_usuario){

        Optional<Usuario> usuarioOptional = usuarioService.getUsuario(id_usuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            historico.setUsuario(usuario);
            historicService.createHistorico(historico);
            // Salva o usuario com a associação de um historico
            usuarioService.updateUsuario(usuario);

            return "Histórico associado ao usuário com sucesso";
        } else {
            return "Usuário não encontrado";
        }
    }



    @PutMapping
    public String updateUsuarioDetails(@RequestBody Usuario usuario){
        usuarioService.updateUsuario(usuario);
        return "Usuario atualizado com sucesso";
    }

    @DeleteMapping("{usuarioId}")
    public String deleteUsuarioDetails(Integer usuarioId){
        usuarioService.deleteUsuario(usuarioId);
        return "Usuario deletado com sucesso";
    }


}
