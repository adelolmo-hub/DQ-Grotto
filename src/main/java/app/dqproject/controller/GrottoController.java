package app.dqproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public ResponseEntity<GrottoMap> createNewGrottoMap(@RequestBody GrottoMap grotto) {
		System.out.println(grotto.toString());
		return new ResponseEntity<GrottoMap>(grottoService.createGrotto(grotto), HttpStatus.OK);
	}
}
