package com.project.threadsclone.config;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface PasswordConstraint {
    String message() default "Password must contain at least one uppercase letter, one number and one special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
