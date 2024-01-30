package br.jus.trece.regulusApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trece.regulusApi.db.juris.domain.MagistradoJuris;
import br.jus.trece.regulusApi.db.juris.repo.MagistradoJurisRepository;
import br.jus.trece.regulusApi.db.regulus.domain.Estado;
import br.jus.trece.regulusApi.db.regulus.repo.EstadoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	MagistradoJurisRepository magistradoJurisRepository;

	@GetMapping("/estados")
	public ResponseEntity<List<Estado>> getAllEstados() {
		try {
			List<Estado> estados = new ArrayList<Estado>();

			estadoRepository.findAll().forEach(estados::add);

			if (estados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(estados, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/magistrados")
	public ResponseEntity<List<MagistradoJuris>> getAllMagistradosJuris() {
		try {
			List<MagistradoJuris> magistrados = new ArrayList<MagistradoJuris>();

			magistradoJurisRepository.findAll().forEach(magistrados::add);

			if (magistrados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(magistrados, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}