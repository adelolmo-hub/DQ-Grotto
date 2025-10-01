package app.dqproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dqproject.models.GrottoMap;
import app.dqproject.repository.IGrottoRepository;

@Service
public class GrottoService {

	@Autowired
	private IGrottoRepository grottoRepository;
	
	public List<GrottoMap> allGrottos(){
		return grottoRepository.findAll();
	}
	
	public GrottoMap createGrotto(GrottoMap grotto) {
		return grottoRepository.save(grotto);
	}
}
