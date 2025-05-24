package com.example.transacoes_financeiras.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "tb_transacoes")
public class Transacao implements Serializable{


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private TipoTransacao TipoTransacao;
    private String Categoria;

    public Transacao() {}


    public Transacao(Long id, TipoTransacao tipoTransacao, String categoria) {
        this.Id = id;
        this.TipoTransacao = tipoTransacao;
        this.Categoria = categoria;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId(){
        return Id;
    }

    public TipoTransacao getTipoTransacao() {
        return TipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.TipoTransacao = tipoTransacao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }
}



