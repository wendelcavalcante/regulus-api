package br.jus.trece.regulusApi.db.regulus.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "magistrado")
public class Magistrado {
    
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "email")
    private String email;

    @Transient
    private float distanciaZona;

    @Transient
    private Integer diasSemMandato = 10000;


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

    public float getDistanciaZona() {
        return distanciaZona;
    }

    public void setDistanciaZona(float distanciaZona) {
        this.distanciaZona = distanciaZona;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getDiasSemMandato() {
        return diasSemMandato;
    }

    public void setDiasSemMandato(Integer diasSemMandato) {
        this.diasSemMandato = diasSemMandato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Magistrado [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", email=" + email
                + ", distanciaZona=" + distanciaZona + ", diasSemMandato=" + diasSemMandato + ", comarca=" + comarca
                + "]";
    }
            
    

}
