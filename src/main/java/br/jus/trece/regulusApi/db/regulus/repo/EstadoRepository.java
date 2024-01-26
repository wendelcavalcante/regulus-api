package br.jus.trece.regulusApi.db.regulus.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.regulus.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    
}
