package io.github.jinyoungyou.hexagonalmodulith.common;

import jakarta.validation.*;

import java.util.Set;

public abstract class SelfValidating<T> {

    private final Validator validator;
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public SelfValidating() {
        validator = factory.getValidator();
    }

    @SuppressWarnings("unchecked cast")
    public void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
