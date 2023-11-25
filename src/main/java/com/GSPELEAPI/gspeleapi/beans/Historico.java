package com.GSPELEAPI.gspeleapi.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "t_historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_historico;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private  String condicoes_pre;
    private String historico_doencas;
    private String historico_familia;
    private String alergias;
    private String tratamentos_anteriores;

    public Historico(Integer id_historico, String condicoes_pre,
                     String historico_doencas, String historico_familia,
                     String alergias, String tratamentos_anteriores, Usuario usuario) {
        this.id_historico = id_historico;
        this.condicoes_pre = condicoes_pre;
        this.historico_doencas = historico_doencas;
        this.historico_familia = historico_familia;
        this.alergias = alergias;
        this.tratamentos_anteriores = tratamentos_anteriores;
        this.usuario = usuario;
    }

    public Historico(){

    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Integer getId_historico() {
        return id_historico;
    }

    public void setId_historico(Integer id_historico) {
        this.id_historico = id_historico;
    }

    public String getCondicoes_pre() {
        return condicoes_pre;
    }

    public void setCondicoes_pre(String condicoes_pre) {
        this.condicoes_pre = condicoes_pre;
    }

    public String getHistorico_doencas() {
        return historico_doencas;
    }

    public void setHistorico_doencas(String historico_doencas) {
        this.historico_doencas = historico_doencas;
    }

    public String getHistorico_familia() {
        return historico_familia;
    }

    public void setHistorico_familia(String historico_familia) {
        this.historico_familia = historico_familia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTratamentos_anteriores() {
        return tratamentos_anteriores;
    }

    public void setTratamentos_anteriores(String tratamentos_anteriores) {
        this.tratamentos_anteriores = tratamentos_anteriores;
    }



}
