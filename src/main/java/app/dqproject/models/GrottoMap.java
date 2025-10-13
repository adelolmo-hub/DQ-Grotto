package app.dqproject.models;

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
	
	@Pattern(regexp = "^https:\\/\\/[\\w-]+\\.[a-zA-Z]{2,}\\/[a-zA-Z0-9/.?=-_&%]+$", message = "Invalid format. Link must be an URL")
	private String link;
	
	@JsonSerialize(using = IntToHexSerializer.class)
	@JsonDeserialize(using = HexToIntDeserializer.class)
	@NotNull(message = "Code can't be blank")
	private Integer code;
	
	@NotNull(message = "ChestA can't be blank")
	private Integer chestA;
	
	@NotNull(message = "ChestS can't be blank")
	private Integer chestS;
	
	@NotNull(message = "Metal king floor can't be blank")
	private Integer metalKingFloor;
	
	@NotBlank(message = "Type can't be blank")
	private String type;
	
	@NotNull(message = "Floors can't be blank")
	private Integer floors;
	
	@Transient
	private Monster monsters;
	
	
	
	
	
	
}
