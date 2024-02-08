package br.jus.trece.regulusApi.db.juris.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Immutable
@Subselect(
    "SELECT dsm.id_autoridade as id_autoridade, aut.id_servidor AS id_servidor, aut.id_servidor_tj AS id_servidor_tj, va.nome AS nome, dsm.dias_sem_mandato as dias_sem_mandato     from         (             select m1.id_autoridade AS id_autoridade, ceil(sysdate - max(nvl(m1.dt_fim_mandato,sysdate))) AS dias_sem_mandato             from (select m2.id_autoridade, m2.dt_fim_mandato                   from juris.mandato m2                  where ((nvl2(dt_fim_mandato, dt_fim_mandato, sysdate) - dt_exercicio_eleitoral) >= 15)) m1,                   juris.autoridade a             where m1.id_autoridade = a.id_autoridade             group by m1.id_autoridade         ) dsm,          juris.AUTORIDADE aut,         juris.VW_AUTORIDADE va     WHERE          dsm.id_autoridade = aut.id_autoridade AND          va.matricula = aut.id_servidor"
)
public class MagistradoJuris {
    @Id
    @Column(name = "id_autoridade")
    private int idAutoridade;

    @Column(name = "dias_sem_mandato")
    private Integer diasSemMandato;

    @Column(name = "id_servidor_tj")
    private Integer idServidorTj;

    public int getIdAutoridade() {
        return idAutoridade;
    }

    public void setIdAutoridade(int idAutoridade) {
        this.idAutoridade = idAutoridade;
    }

    public Integer getDiasSemMandato() {
        return diasSemMandato;
    }

    public void setDiasSemMandato(Integer diasSemMandato) {
        this.diasSemMandato = diasSemMandato;
    }

    public Integer getIdServidorTj() {
        return idServidorTj;
    }

    public void setIdServidorTj(Integer idServidorTj) {
        this.idServidorTj = idServidorTj;
    }

}
