package br.jus.trece.regulusApi.db.dadosCorporativos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.dadosCorporativos.domain.ZonaDc;
import jakarta.persistence.EntityManager;

@Repository
public interface ZonaDcRepository extends JpaRepository<ZonaDc, String> {

    @Query("select z from ZonaDc z JOIN FETCH z.sede")
    List<ZonaDc> findAll();
        
}