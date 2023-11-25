package com.GSPELEAPI.gspeleapi.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "t_usuario_ficha")
public class UsuarioFicha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_usuario_fichas")
    private Integer id_usuario_fichas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private Ficha ficha;

    public UsuarioFicha(Integer id_usuario_fichas, Usuario usuario, Ficha ficha) {
        this.id_usuario_fichas = id_usuario_fichas;
        this.usuario = usuario;
        this.ficha = ficha;
    }

    public UsuarioFicha (){

    }

    public UsuarioFicha (Usuario usuario, Ficha ficha){
        this.usuario = usuario;
        this.ficha = ficha;
    }

    public Integer getId_usuario_fichas() {
        return id_usuario_fichas;
    }

    public void setId_usuario_fichas(Integer id_usuario_fichas) {
        this.id_usuario_fichas = id_usuario_fichas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

}
