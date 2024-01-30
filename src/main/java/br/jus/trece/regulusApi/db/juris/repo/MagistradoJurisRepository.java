package br.jus.trece.regulusApi.db.juris.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.trece.regulusApi.db.juris.domain.MagistradoJuris;
import br.jus.trece.regulusApi.db.regulus.domain.Estado;

@Repository
public interface MagistradoJurisRepository extends JpaRepository<MagistradoJuris, Integer> {

}
