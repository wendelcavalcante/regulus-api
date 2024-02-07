package br.jus.trece.regulusApi.db.regulus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*@Entity
@Table(name = "distancia")*/
public class Distancia {
   
    @ManyToOne
    @JoinColumn(name = "codigo_ibge_origem", referencedColumnName = "codigo_ibge")
    private Municipio origem;

    @ManyToOne
    @JoinColumn(name = "codigo_ibge_destino", referencedColumnName = "codigo_ibge")
    private Municipio destino;

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

    
}
