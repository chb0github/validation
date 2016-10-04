package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.internal.UUIDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ METHOD, FIELD, PARAMETER })
@Constraint(validatedBy= UUIDValidator.class)
@Retention(RUNTIME)
@Documented
public @interface UUID {
    String message() default "{org.bongiorno.validation.constraints.UUID.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
