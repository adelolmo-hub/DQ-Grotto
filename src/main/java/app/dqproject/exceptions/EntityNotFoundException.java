package app.dqproject.exceptions;

public class EntityNotFoundException extends RuntimeException{

	public EntityNotFoundException(Integer seed) {
		super("Grotto with seed %s does not exist".formatted(String.format("0x%04X", seed)));
	}
}
