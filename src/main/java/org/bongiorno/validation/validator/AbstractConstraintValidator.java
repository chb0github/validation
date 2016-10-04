package org.bongiorno.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.BiFunction;

/**
 * @author cbongiorno
 */
public abstract class AbstractConstraintValidator<A extends Annotation,R> implements ConstraintValidator<A,R> {


    protected BiFunction<R,ConstraintValidatorContext,Boolean> function;

    protected AbstractConstraintValidator(BiFunction<R, ConstraintValidatorContext, Boolean> function) {
        this.function = function;
    }

    protected AbstractConstraintValidator() {
    }


    @Override
    public void initialize(A constraintAnnotation) {

    }

    @Override
    public boolean isValid(R value, ConstraintValidatorContext context) {
        return value == null || function.apply(value,context);
    }
}
