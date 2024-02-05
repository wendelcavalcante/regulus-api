package br.jus.trece.regulusApi.db.dadosCorporativos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.dadosCorporativos.domain.MunicipioDc;

@Repository
public interface MunicipioDcRepository extends JpaRepository<MunicipioDc, Integer> {

}
