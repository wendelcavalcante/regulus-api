package br.jus.trece.regulusApi.db.regulus.domain;

import java.io.Serializable;

public class DistanciaId implements Serializable {

    private Municipio origem;

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

    public DistanciaId() {
    }

    public DistanciaId(Municipio origem, Municipio destino) {
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
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
        DistanciaId other = (DistanciaId) obj;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        return true;
    }

    

    /*private long codigoIbgeOrigem;
    private long codigoIbgeDestino;

    public DistanciaId(long codigoIbgeOrigem, long codigoIbgeDestino) {
        this.codigoIbgeOrigem = codigoIbgeOrigem;
        this.codigoIbgeDestino = codigoIbgeDestino;
    }

    

    public long getCodigoIbgeOrigem() {
        return codigoIbgeOrigem;
    }



    public void setCodigoIbgeOrigem(long codigoIbgeOrigem) {
        this.codigoIbgeOrigem = codigoIbgeOrigem;
    }



    public long getCodigoIbgeDestino() {
        return codigoIbgeDestino;
    }



    public void setCodigoIbgeDestino(long codigoIbgeDestino) {
        this.codigoIbgeDestino = codigoIbgeDestino;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (codigoIbgeOrigem ^ (codigoIbgeOrigem >>> 32));
        result = prime * result + (int) (codigoIbgeDestino ^ (codigoIbgeDestino >>> 32));
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
        DistanciaId other = (DistanciaId) obj;
        if (codigoIbgeOrigem != other.codigoIbgeOrigem)
            return false;
        if (codigoIbgeDestino != other.codigoIbgeDestino)
            return false;
        return true;
    }*/
   
    
}
