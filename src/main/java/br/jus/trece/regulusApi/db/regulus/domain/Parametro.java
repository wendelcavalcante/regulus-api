package br.jus.trece.regulusApi.db.regulus.domain;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "PARAMETRO")
public class Parametro {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_sistema")
    private Integer idSistema;

    @Column(name = "ds_url_seguranca_tre")
    private String urlSegurancaTre;

    @Column(name = "ds_url_entidade_tre")
    private String urlEntidade;

    @Column(name = "ds_url_log_tre")
    private String urlLog;

    @Column(name = "ds_url_email_tre")
    private String urlEmail;

    @Column(name = "ds_url_fonetica_tre")
    private String urlFonetica;

    @Column(name = "ds_url_assinatura_tre")
    private String urlAssinatura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getUrlSegurancaTre() {
        return urlSegurancaTre;
    }

    public void setUrlSegurancaTre(String urlSegurancaTre) {
        this.urlSegurancaTre = urlSegurancaTre;
    }

    public String getUrlEntidade() {
        return urlEntidade;
    }

    public void setUrlEntidade(String urlEntidade) {
        this.urlEntidade = urlEntidade;
    }

    public String getUrlLog() {
        return urlLog;
    }

    public void setUrlLog(String urlLog) {
        this.urlLog = urlLog;
    }

    public String getUrlEmail() {
        return urlEmail;
    }

    public void setUrlEmail(String urlEmail) {
        this.urlEmail = urlEmail;
    }

    public String getUrlFonetica() {
        return urlFonetica;
    }

    public void setUrlFonetica(String urlFonetica) {
        this.urlFonetica = urlFonetica;
    }

    public String getUrlAssinatura() {
        return urlAssinatura;
    }

    public void setUrlAssinatura(String urlAssinatura) {
        this.urlAssinatura = urlAssinatura;
    }

    

}
