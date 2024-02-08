package br.jus.trece.regulusApi.db.regulus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.jus.trece.regulusApi.db.regulus.domain.Distancia;
import br.jus.trece.regulusApi.db.regulus.domain.DistanciaId;
import br.jus.trece.regulusApi.db.regulus.domain.Magistrado;

public interface DistanciaRepository extends JpaRepository<Distancia, DistanciaId>{
    
    @Query("select d from Distancia d JOIN FETCH d.origem JOIN FETCH d.destino")
    List<Distancia> findAll();

}
