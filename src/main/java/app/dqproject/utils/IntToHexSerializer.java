package app.dqproject.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class IntToHexSerializer extends JsonSerializer<Integer>{

	@Override
	public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(value==null) {
			gen.writeNull();
		}else {
			gen.writeString(String.format("0x%04X", value));
		}
	}
}
