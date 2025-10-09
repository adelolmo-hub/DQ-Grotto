package app.dqproject.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.*;

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
	
	@NotBlank(message = "Name can't be blank")
	private String name;
	
	@Min(value = 1, message = "Min level is 1")
    @Max(value = 99, message = "Max level is 99")
	private int level;
	
	@NotBlank(message = "Boss name can't be blank")
	private String boss;
	
	@Pattern(regexp = "^[0-9]{1,2}-[0-9]{1,2}$", message = "Invalid range format. Expected format: 'number-number' (e.g., '7-10').")
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
