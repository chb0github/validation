package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.internal.TimeZoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, PARAMETER,LOCAL_VARIABLE})
@Constraint(validatedBy=TimeZoneValidator.class)
@Retention(RUNTIME)
public @interface TimeZone {
    String message() default "{org.bongiorno.validation.constraints.TimeZone.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
