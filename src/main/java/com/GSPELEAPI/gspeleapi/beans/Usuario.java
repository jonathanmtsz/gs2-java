package com.GSPELEAPI.gspeleapi.beans;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="t_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  @Column(name = "id_usuario")
    private Integer id;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Historico historico;
    private String nome;
    private String email;
    private String senha;
    private String sexo_biologico;
    private String genero;
    private String data_nascimento;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<UsuarioFicha> usuarioFichas;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Integer id, String sexo_biologico, String genero, String data_nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.sexo_biologico = sexo_biologico;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo_biologico() {
        return sexo_biologico;
    }

    public void setSexo_biologico(String sexo_biologico) {
        this.sexo_biologico = sexo_biologico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}