package br.jus.trece.regulusApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.jus.trece.regulusApi.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    
}
