package br.jus.trece.regulusApi.db.dadosCorporativos.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Immutable
@Subselect("SELECT vz.NUMERO AS numero, vm.NM_MUNIC AS sede " + //
        "        FROM VW_ZONA vz ," + //
        "            VW_MUNICIPIO vm " + //
        "        WHERE VZ.ID_MUNICIPIO = VM.ID_MUNIC ")
public class ZonaConsultaDc {
    
    @Id
    @Column(name = "numero")
    private int numero;

    @Column(name = "sede")
    private String sede;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    

}
