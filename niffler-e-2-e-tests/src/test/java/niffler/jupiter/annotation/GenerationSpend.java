package niffler.jupiter.annotation;

import niffler.model.CurrencyValues;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerationSpend {
    String spendDate();

    String category();

    CurrencyValues currency();

    double amount();

    String description();

    String username() default "";

}
