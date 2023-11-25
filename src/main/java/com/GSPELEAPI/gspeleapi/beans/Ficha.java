package com.GSPELEAPI.gspeleapi.beans;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "t_ficha")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id_ficha;
    private  String apelido_ficha;
    private String data_inicio_sintomas;
    private String data_fim_sintomas;
    private String sintomas;
    private String ambiente_trabalho;
    private String ambiente_domestico;
    private String uso_produtos;
    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL)
    private Set<UsuarioFicha> usuarioFichas;

    public Ficha(Integer id_ficha, String apelido_ficha,
                 String data_inicio_sintomas, String data_fim_sintomas,
                 String sintomas, String ambiente_trabalho,
                 String ambiente_domestico, String uso_produtos) {
        this.id_ficha = id_ficha;
        this.apelido_ficha = apelido_ficha;
        this.data_inicio_sintomas = data_inicio_sintomas;
        this.data_fim_sintomas = data_fim_sintomas;
        this.sintomas = sintomas;
        this.ambiente_trabalho = ambiente_trabalho;
        this.ambiente_domestico = ambiente_domestico;
        this.uso_produtos = uso_produtos;
    }

    public Ficha (){

    }

    public Integer getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(Integer id_ficha) {
        this.id_ficha = id_ficha;
    }

    public String getApelido_ficha() {
        return apelido_ficha;
    }

    public void setApelido_ficha(String apelido_ficha) {
        this.apelido_ficha = apelido_ficha;
    }

    public String getData_inicio_sintomas() {
        return data_inicio_sintomas;
    }

    public void setData_inicio_sintomas(String data_inicio_sintomas) {
        this.data_inicio_sintomas = data_inicio_sintomas;
    }

    public String getData_fim_sintomas() {
        return data_fim_sintomas;
    }

    public void setData_fim_sintomas(String data_fim_sintomas) {
        this.data_fim_sintomas = data_fim_sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getAmbiente_trabalho() {
        return ambiente_trabalho;
    }

    public void setAmbiente_trabalho(String ambiente_trabalho) {
        this.ambiente_trabalho = ambiente_trabalho;
    }

    public String getAmbiente_domestico() {
        return ambiente_domestico;
    }

    public void setAmbiente_domestico(String ambiente_domestico) {
        this.ambiente_domestico = ambiente_domestico;
    }

    public String getUso_produtos() {
        return uso_produtos;
    }

    public void setUso_produtos(String uso_produtos) {
        this.uso_produtos = uso_produtos;
    }


}
