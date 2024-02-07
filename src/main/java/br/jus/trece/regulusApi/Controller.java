package br.jus.trece.regulusApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trece.regulusApi.db.dadosCorporativos.domain.MunicipioDc;
import br.jus.trece.regulusApi.db.dadosCorporativos.domain.ZonaConsultaDc;
import br.jus.trece.regulusApi.db.dadosCorporativos.domain.ZonaDc;
import br.jus.trece.regulusApi.db.dadosCorporativos.repo.MunicipioDcRepository;
import br.jus.trece.regulusApi.db.dadosCorporativos.repo.ZonaConsultaDcRepository;
import br.jus.trece.regulusApi.db.dadosCorporativos.repo.ZonaDcRepository;
import br.jus.trece.regulusApi.db.juris.domain.MagistradoJuris;
import br.jus.trece.regulusApi.db.juris.repo.MagistradoJurisRepository;
import br.jus.trece.regulusApi.db.regulus.domain.Estado;
import br.jus.trece.regulusApi.db.regulus.domain.Magistrado;
import br.jus.trece.regulusApi.db.regulus.repo.EstadoRepository;
import br.jus.trece.regulusApi.db.regulus.repo.MagistradoRepository;
import br.jus.trece.regulusApi.db.regulus.repo.QueriesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	MagistradoJurisRepository magistradoJurisRepository;

	@Autowired
	MagistradoRepository magistradoRepository;

	@Autowired
	MunicipioDcRepository municipioDcRepository;

	@Autowired
	ZonaDcRepository zonaDcRepository;

	@Autowired
	ZonaConsultaDcRepository zonaConsultaDcRepository;

	/*@Autowired
	@Qualifier(value = "regulusEntityManagerFactory")
	QueriesRepository queriesRepository;*/

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

	@GetMapping("/zonas")
	public ResponseEntity<List<ZonaDc>> getAllZonas() {
		try {
			List<ZonaDc> zonas = new ArrayList<ZonaDc>();

			zonaDcRepository.findAll().forEach(zonas::add);

			if (zonas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(zonas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*@GetMapping("/zonas")
	public ResponseEntity<List<ZonaConsultaDc>> getAllZonasConsulta() {
		try {
			List<ZonaConsultaDc> zonas = new ArrayList<ZonaConsultaDc>();

			zonaConsultaDcRepository.findAll().forEach(zonas::add);

			if (zonas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(zonas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	@GetMapping("/municipios")
	public ResponseEntity<List<MunicipioDc>> getAllMunicipios() {
		try {
			List<MunicipioDc> municipios = new ArrayList<MunicipioDc>();

			municipioDcRepository.findAll().forEach(municipios::add);

			if (municipios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(municipios, HttpStatus.OK);
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

	@GetMapping("/magistrados_regulus")
	public ResponseEntity<List<Magistrado>> getAllMagistradosRegulus() {
		try {
			List<Magistrado> magistrados = new ArrayList<Magistrado>();

			//queriesRepository.findMagistradosComDistancias().forEach(magistrados::add);
			//magistradoRepository.findAll().forEach(magistrados::add);

			List<Object[]> lst = magistradoRepository.findMagistradosComDistancias();
						
			for(Object o[] : lst) {
				magistrados.add((Magistrado)o[0]);
			}

			if (magistrados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(magistrados, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}