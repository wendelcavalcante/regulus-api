package br.jus.trece.regulusApi.db.regulus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "magistrado")
public class Magistrado {
    
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
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

    @ManyToOne
    @JoinColumn(name = "id_comarca", referencedColumnName = "codigo_ibge")
    private Municipio comarca;

    public Municipio getComarca() {
        return comarca;
    }

    public void setComarca(Municipio comarca) {
        this.comarca = comarca;
    }

    

}
