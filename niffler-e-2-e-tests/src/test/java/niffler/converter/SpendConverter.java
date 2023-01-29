package niffler.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import niffler.dto.Spend;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpendConverter implements ArgumentConverter {

    private ClassLoader cl = this.getClass().getClassLoader();
    private ObjectMapper om = new ObjectMapper();

    @Override
    public Spend convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new ArgumentConversionException("work only for Strings!");
        }
        try (InputStream is = cl.getResourceAsStream((String) source);
             InputStreamReader isr = new InputStreamReader(is)) {
//            TODO   заменить на  object    и вернуть его , чтобы не плодить конвертеры
            return om.readValue(isr, Spend.class);
        } catch (IOException e) {
            throw new ArgumentConversionException("Failed to convert", e);
        }
    }
}
