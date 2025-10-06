package app.dqproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dqproject.models.GrottoMap;
import app.dqproject.service.GrottoService;

@RestController
@RequestMapping(path = "/api/v1/grotto")
public class GrottoController {
	
	@Autowired
	private GrottoService grottoService;
	
	@GetMapping
	public ResponseEntity<List<GrottoMap>> getAllGrotos() {
		return new ResponseEntity<List<GrottoMap>>(grottoService.allGrottos(), HttpStatus.OK);
	}
	
	@GetMapping("{seed}")
	public ResponseEntity<GrottoMap> getGrottoById(@PathVariable Integer seed){
		return new ResponseEntity<GrottoMap>(grottoService.getById(seed), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<GrottoMap> createNewGrottoMap(@RequestBody GrottoMap grotto) {
		return new ResponseEntity<GrottoMap>(grottoService.createGrotto(grotto), HttpStatus.OK);
	}
	
	@PutMapping("{seed}")
	public ResponseEntity<GrottoMap> updateGrottoMap(@RequestBody GrottoMap grotto, @PathVariable Integer seed){
		return new ResponseEntity<GrottoMap>(grottoService.updateGrotto(seed, grotto), HttpStatus.OK);
	}
	
	@DeleteMapping("{seed}")
	public ResponseEntity<String> deleteGrottoMap(@PathVariable Integer seed){
		grottoService.deleteGrotto(seed);
		return new ResponseEntity<String>("Grotto with seed " + seed + " deleted", HttpStatus.OK);
	}
	
}
