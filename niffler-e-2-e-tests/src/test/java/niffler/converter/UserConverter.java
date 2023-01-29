package niffler.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import niffler.dto.User;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserConverter  implements ArgumentConverter {
    private ClassLoader cl = this.getClass().getClassLoader();
    private ObjectMapper om = new ObjectMapper();

    @Override
    public User convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new ArgumentConversionException("work only for Strings!");
        }
        try (InputStream is = cl.getResourceAsStream((String) source);
             InputStreamReader isr = new InputStreamReader(is)) {
            return om.readValue(isr, User.class);
        } catch (IOException e) {
            throw new ArgumentConversionException("Failed to convert", e);
        }
    }
}
