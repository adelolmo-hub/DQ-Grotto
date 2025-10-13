package app.dqproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

import app.dqproject.exceptions.EntityNotFoundException;
import app.dqproject.models.GrottoMap;
import app.dqproject.models.Monster;
import app.dqproject.models.MonsterEntry;
import app.dqproject.repository.IGrottoRepository;

@Service
public class GrottoService {

	@Autowired
	private IGrottoRepository grottoRepository;
	
	@Autowired
	private MonsterService monsterService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<GrottoMap> allGrottos(){
		List<GrottoMap> grottoList = grottoRepository.findAll();
		for(GrottoMap grotto : grottoList) {
			getFilteredMonsterList(grotto);
		}
		
		return grottoList;
	}
	
	public GrottoMap createGrotto(GrottoMap grotto) {
		if(grottoRepository.existsById(grotto.getSeed())) {
			throw new IllegalStateException("This grotto already exists. Seed = " + grotto.getSeed());
		}
		return grottoRepository.save(grotto);
	}
	
	public GrottoMap updateGrotto(Integer seed, GrottoMap grotto) {
		Query query = new Query(Criteria.where("seed").is(seed));

	    Update update = new Update()
	        .set("name", grotto.getName())
	        .set("level", grotto.getLevel())
	        .set("boss", grotto.getBoss())
	        .set("link", grotto.getLink())
	        .set("code", grotto.getCode())
	        .set("rank", grotto.getRank())
	        .set("chestA", grotto.getChestA())
	        .set("chestS", grotto.getChestS())
	        .set("metalKingFloor", grotto.getMetalKingFloor())
	        .set("type", grotto.getType())
	        .set("floors", grotto.getFloors());

	    UpdateResult result = mongoTemplate.updateFirst(query, update, GrottoMap.class);
	    if(result.getMatchedCount() == 0) {
	    	throw new EntityNotFoundException(seed);
	    }
	    return grotto;
	}
	
	public void deleteGrotto(Integer seed) {
		if(!grottoRepository.existsById(seed)) {
			throw new EntityNotFoundException(seed);
		}else {
			grottoRepository.deleteById(seed);
		}
	}
	
	public GrottoMap getById(Integer seed) {
		GrottoMap grotto = grottoRepository.findById(seed).orElseThrow(() -> new EntityNotFoundException(seed));
		getFilteredMonsterList(grotto);
		
		return grotto;
	}

	private GrottoMap getFilteredMonsterList(GrottoMap grotto) {
		
		Optional<Monster> monster = monsterService.getMonstersByType(grotto.getType());
		
		String[] ranks = grotto.getRank().split("-");
		
		if(monster.isPresent() && grotto.getRank() != null) {
			Monster monsterClass = monster.get();
			
			int minRank = Integer.parseInt(ranks[0]);
			int maxRank = Integer.parseInt(ranks[1]);
			
			List<MonsterEntry> filtered = monsterClass.getMonsterList().stream()
			        .filter(m -> m.getRank() >= minRank && m.getRank() <= maxRank)
			        .toList();
			
			monsterClass.setMonsterList(filtered);
			grotto.setMonsters(monsterClass);
		}
		
		return grotto;
	}
	
}
