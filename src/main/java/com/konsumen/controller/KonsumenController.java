package com.konsumen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konsumen.model.Konsumen;
import com.konsumen.repository.KonsumenRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class KonsumenController {

	@Autowired
	KonsumenRepository konsumenRepository;

	@GetMapping("/konsumen")
	public ResponseEntity<List<Konsumen>> getAllKonsumen() {
		try {
			List<Konsumen> konsumen = new ArrayList<Konsumen>();

			konsumenRepository.findAll().forEach(konsumen::add);

			if (konsumen.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(konsumen, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/konsumen/{id}")
	public ResponseEntity<Konsumen> getKonsumenById(@PathVariable("id") int id) {
		try {
			Konsumen konsumen = konsumenRepository.findById(id);

			if (konsumen != null) {
				return new ResponseEntity<>(konsumen, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/konsumen")
	public ResponseEntity<String> createKonsumen(@RequestBody Konsumen konsumen) {
		try {
			konsumenRepository
					.save(new Konsumen(konsumen.getId(), konsumen.getNama(), konsumen.getAlamat(), konsumen.getKota(),
							konsumen.getProvinsi(), konsumen.getTgl_registrasi(), konsumen.getStatus()));
			return new ResponseEntity<>("Konsumen was created successfully.", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/konsumen/{id}")
	public ResponseEntity<String> updateKonsumen(@PathVariable("id") int id, @RequestBody Konsumen konsumen) {
		try {
			Konsumen _konsumen = konsumenRepository.findById(id);

			if (_konsumen != null) {
				_konsumen.setId(id);
				_konsumen.setNama(konsumen.getNama());
				_konsumen.setAlamat(konsumen.getAlamat());
				_konsumen.setKota(konsumen.getKota());
				_konsumen.setProvinsi(konsumen.getProvinsi());
				_konsumen.setTgl_registrasi(konsumen.getTgl_registrasi());
				_konsumen.setStatus(konsumen.getStatus());

				konsumenRepository.update(_konsumen);
				return new ResponseEntity<>("Konsumen was updated successfully.", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Cannot find Konsumen with id=" + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/konsumen/{id}")
	public ResponseEntity<String> deleteKonsumen(@PathVariable("id") int id) {
		try {
			int result = konsumenRepository.deleteById(id);
			if (result == 0) {
				return new ResponseEntity<>("Cannot find Konsumen with id=" + id, HttpStatus.OK);
			}
			return new ResponseEntity<>("Konsumen was deleted successfully.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/konsumen")
	public ResponseEntity<String> deleteAllKonsumen() {
		try {
			int numRows = konsumenRepository.deleteAll();
			return new ResponseEntity<>("Deleted " + numRows + " Konsumen(s) successfully.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
