package br.jus.trece.regulusApi.db.dadosCorporativos.domain;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "VW_MUNICIPIO")
public class MunicipioDc {
    @Id
    @Column(name = "id_munic")
    private long id;

    @Column(name = "nm_munic")
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
