package br.jus.trece.regulusApi.db.regulus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {
    
    @Id
    @Column(name = "codigo_ibge")
    private long codigoIbge;

    @Column(name = "nome")
    private String nome;

    public long getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(long codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
