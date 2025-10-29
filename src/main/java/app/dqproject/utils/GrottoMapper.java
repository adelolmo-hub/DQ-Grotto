package app.dqproject.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import app.dqproject.dto.GrottoMapDTO;
import app.dqproject.models.GrottoMap;

@Component
public class GrottoMapper {

	public GrottoMapDTO toDTO(GrottoMap map) {
        return new GrottoMapDTO(map.getSeed(), map.getCode(), map.getName(), map.getLevel(), map.getBoss(), map.getRank(),
        		map.getMonsters(), map.getLink(), map.getChestA(), map.getChestS(), map.getMetalKingFloor(), map.getType(), map.getFloors());
    }

    public List<GrottoMapDTO> toDTOList(List<GrottoMap> grottos) {
        return grottos.stream()
                    .map(this::toDTO)
                    .toList();
    }
}
