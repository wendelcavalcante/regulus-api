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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (codigoIbge ^ (codigoIbge >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Municipio other = (Municipio) obj;
        if (codigoIbge != other.codigoIbge)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
    
}
