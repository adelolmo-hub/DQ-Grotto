package app.dqproject.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import app.dqproject.utils.HexToIntDeserializer;
import app.dqproject.utils.IntToHexSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "grotto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrottoMap {

	@JsonSerialize(using = IntToHexSerializer.class)
	@JsonDeserialize(using = HexToIntDeserializer.class)
	@Id
	private Integer seed;
	private String name;
	private int level;
	private String boss;
	private String rank;
	private String link;
	@JsonSerialize(using = IntToHexSerializer.class)
	@JsonDeserialize(using = HexToIntDeserializer.class)
	private int code;
	private int chestA;
	private int chestS;
	private int metalKingFloor;
	private String type;
	private int floors;
	@Transient
	private Monster monsters;
	
	
	
	
	
	
}
