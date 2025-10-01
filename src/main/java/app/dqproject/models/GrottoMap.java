package app.dqproject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "grotto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrottoMap {

	
	private Integer seed;
	private String name;
	private int level;
	private String boss;
	private String link;
	private int code;
	private int chestA;
	private int chestS;
	private int metalKingFloor;
	private String type;
	private int floors;
	
	
	
	@JsonSetter("seed")
	public void setSeed(String seed) {
		this.seed = Integer.decode(seed);
	}
	
	@JsonSetter("code")
	public void setCode(String code) {
		this.code = Integer.decode(code);
	}
	
	@Override
	public String toString() {
		return "GrottoMap [seed=" + seed + ", name=" + name + ", level=" + level + ", boss=" + boss + ", link=" + link
				+ ", code=" + code + ", chestA=" + chestA + ", chestS=" + chestS + ", metalKingFloor=" + metalKingFloor
				+ ", type=" + type + ", floors=" + floors + "]";
	}
	
	
	
	
	
}
