package app.dqproject.dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import app.dqproject.models.GrottoMap;
import app.dqproject.models.Monster;
import app.dqproject.utils.IntToHexSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrottoMapDTO {

	@JsonSerialize(using = IntToHexSerializer.class)
	private Integer seed;
	
	@JsonSerialize(using = IntToHexSerializer.class)
	private Integer code;
	
	private String name;
	
	private int level;
	
	private String boss;
	
	private String rank;
	
	private Monster monsters;
	
	private String link;
	
	private Integer chestA;
	
	private Integer chestS;
	
	private Integer metalKingFloor;
	
	private String type;
	
	private Integer floors;
	
	
	public static GrottoMapDTO fromEntity(GrottoMap map) {
        return new GrottoMapDTO(map.getSeed(), map.getCode(), map.getName(), map.getLevel(), map.getBoss(), map.getRank(),
        		map.getMonsters(), map.getLink(), map.getChestA(), map.getChestS(), map.getMetalKingFloor(), map.getType(), map.getFloors());
    }
	
	
}
