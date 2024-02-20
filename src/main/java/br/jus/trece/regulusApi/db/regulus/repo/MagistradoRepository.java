package br.jus.trece.regulusApi.db.regulus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.regulus.domain.Magistrado;

@Repository
public interface MagistradoRepository extends JpaRepository<Magistrado, Integer>{
    
    @Query("select m from Magistrado m JOIN FETCH m.comarca")
    List<Magistrado> findAll();

    @Query("select m, d "+
           "  from Magistrado m, Distancia d "+
           "  JOIN FETCH m.comarca"+
           "  JOIN FETCH d.origem"+
           "  JOIN FETCH d.destino"+
           " where upper(d.destino.nome) = upper(:destino) and m.comarca.codigoIbge = d.origem.codigoIbge "+
           " order by d.distancia asc")
    List<Object[]> findMagistradosComDistancias(@Param("destino") String destino);

}
