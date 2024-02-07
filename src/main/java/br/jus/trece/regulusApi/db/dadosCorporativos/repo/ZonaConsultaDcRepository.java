package br.jus.trece.regulusApi.db.dadosCorporativos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.dadosCorporativos.domain.ZonaConsultaDc;

@Repository
public interface ZonaConsultaDcRepository extends JpaRepository<ZonaConsultaDc, Integer>{
    
}
