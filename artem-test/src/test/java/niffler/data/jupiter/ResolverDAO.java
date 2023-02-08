package niffler.data.jupiter;


import niffler.data.repository.PostgresUserRepository;
import niffler.data.model.annotations.DAO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResolverDAO implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        List<Field> fields = Arrays.stream(testInstance.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DAO.class))
                .peek(field -> field.setAccessible(true))
                .collect(Collectors.toList());

        for (Field field : fields) {
            field.set(testInstance, new PostgresUserRepository());
        }
    }
}
