package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.internal.CurrencyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, PARAMETER,LOCAL_VARIABLE})
@Constraint(validatedBy=CurrencyValidator.class)
@Retention(RUNTIME)
public @interface CurrencyCode {
    String message() default "{org.bongiorno.validation.constraints.CurrencyCode.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
