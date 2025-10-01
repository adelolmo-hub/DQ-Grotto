package app.dqproject.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class HexToIntDeserializer extends JsonDeserializer<Integer>{

	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String value = p.getText();
		return Integer.decode(value);
	}
}
