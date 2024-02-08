package br.jus.trece.regulusApi.db.regulus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(DistanciaId.class)
@Table(name = "distancia")
public class Distancia {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_ibge_origem", referencedColumnName = "codigo_ibge")
    private Municipio origem;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_ibge_destino", referencedColumnName = "codigo_ibge")
    private Municipio destino;

    @Column(name = "distancia")
    private float distancia;

    public Distancia() {
    }

    public Distancia(Municipio origem, Municipio destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Municipio getOrigem() {
        return origem;
    }

    public void setOrigem(Municipio origem) {
        this.origem = origem;
    }

    public Municipio getDestino() {
        return destino;
    }

    public void setDestino(Municipio destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    
    
}
