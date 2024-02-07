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
    private String id;

    @Column(name = "nm_munic")
    private String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + nome;
    }
    
}
