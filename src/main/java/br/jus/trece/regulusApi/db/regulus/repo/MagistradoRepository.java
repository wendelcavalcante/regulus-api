package br.jus.trece.regulusApi.db.regulus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.regulus.domain.Magistrado;

@Repository
public interface MagistradoRepository extends JpaRepository<Magistrado, Integer>{
    
    @Query("select m from Magistrado m JOIN FETCH m.comarca")
    List<Magistrado> findAll();

    @Query("select m from Magistrado m JOIN FETCH m.comarca")
    List<Object[]> findMagistradosComDistancias();

}
