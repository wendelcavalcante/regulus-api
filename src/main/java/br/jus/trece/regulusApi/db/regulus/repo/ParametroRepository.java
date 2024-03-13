package br.jus.trece.regulusApi.db.regulus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.regulus.domain.Parametro;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {

}