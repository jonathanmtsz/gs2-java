package com.GSPELEAPI.gspeleapi.service.impl;
//essa classe implementa a interface UsuarioService

import com.GSPELEAPI.gspeleapi.beans.Usuario;
import com.GSPELEAPI.gspeleapi.exceptions.ObjectNotFoundException;
import com.GSPELEAPI.gspeleapi.repository.HistoricoRepository;
import com.GSPELEAPI.gspeleapi.repository.UsuarioRepository;
import com.GSPELEAPI.gspeleapi.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String createUsuario(Usuario usuario) {
        //logica de negocios para o banco de dados
        usuarioRepository.save(usuario);
        return "Salvo com sucesso";
    }

    @Override
    public String updateUsuario(Usuario usuario) {
        //logica de negocios para o banco de dados
        usuarioRepository.save(usuario);
        return "Atualizado com sucesso";
    }

    @Override
    public String deleteUsuario(Integer id) {
        //logica de negocios para o banco de dados
        usuarioRepository.deleteById(id);
        return "Deletado com sucesso!";
    }

    @Override
    public Optional<Usuario> getUsuario(Integer id) {
        //logica de negocios para o banco de dados
        if(usuarioRepository.findById(id).isEmpty()){
            throw new ObjectNotFoundException("Nenhum usuario encontrado com esse Identificador");
        } else {
            return usuarioRepository.findById(id);
        }
    }

    @Override
    public List<Usuario> getAllUsuario() {
        //logica de negocios para o banco de dados
        return usuarioRepository.findAll();
    }

    //funcao de encontrar email,
    // usada para evitar conflitos nas operações de login e registro

    @Override
    public Optional<Usuario> findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null)
            throw new ObjectNotFoundException("Nenhum usuario com esse email");
        return Optional.of(usuario);
    }

    public Optional<Usuario> findByEmailRegister(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null) {
            return Optional.empty();
        } else {
            return Optional.of(usuario);
        }
    }

    //funcao de login, caso um usuario com esse email exista,
    // a funcao verifica se a senha atrelada aquele email é a correta
    //se o usuario for nulo, significa que o findByEmail não encontrou nada, retorna 2
    // se nao for nulo, e se a senha do usuario que o findByEmail encontrou for igual a senha recebida, retorna 0
    // se nao for, retorna 1
    @Override
    public Integer login(String email, String senha){
        Optional<Usuario> usuario = findByEmail(email);
        if (usuario.isPresent()) {
            if(usuario.get().getSenha().equals(senha)){
                return 0;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    //funcao de registro para novos usuario
    //a funcao verifica nessa ordem, se a senha é nula ou vazia, se for retorna 2,
    // se nao, verifica se o email é nulo ou vazio, se for retorna 1
    // se nao, verifica se esse email pode ser encontrado no banco de dados, se for encontrado retorna 1
    // e por ultimo, verifica se o nome é nulo ou vazio, se for retorna 3
    // se não for, retorna 0 e registra o usuario no banco de dados

    @Override
    public Integer register(Usuario usuario) {
        if (usuario.getSenha() == null || usuario.getSenha().isBlank()){
            return null;
            } else if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
                return null;
                } else if(findByEmailRegister(usuario.getEmail()).isPresent()){
                            throw new ObjectNotFoundException("Usuario com esse email já existe");
                        }else if (usuario.getNome() == null || usuario.getNome().isBlank()){
                            return null;
        } else {
            createUsuario(usuario);
            return 0;
                }
    }

}
