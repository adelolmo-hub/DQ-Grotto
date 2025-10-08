package app.dqproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dqproject.exceptions.EntityNotFoundException;
import app.dqproject.models.Monster;
import app.dqproject.repository.IMonstersRepository;

@Service
public class MonsterService {
	@Autowired
	private IMonstersRepository monstersRepository;
	
	public Monster getMonster(String type) {
		return monstersRepository.findByType(type).orElseThrow(() -> new EntityNotFoundException(1234));
	}
}
