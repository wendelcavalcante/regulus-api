package br.jus.trece.regulusApi.db.dadosCorporativos.domain;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Immutable
@Table(name = "VW_ZONA")
public class ZonaDc {
    
    @Id
    @Column(name = "ID_ZONA")
    private String id;

    @Column(name = "NUMERO")
    private int numero;

    @OneToOne
    @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNIC")
    private MunicipioDc sede;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public MunicipioDc getSede() {
        return sede;
    }

    public void setSede(MunicipioDc sede) {
        this.sede = sede;
    }

}
