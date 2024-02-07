package br.jus.trece.regulusApi.db.regulus.domain;

import java.io.Serializable;

public class DistanciaId implements Serializable {
    private long codigoIbgeOrigem;
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
    }

    
    
}
