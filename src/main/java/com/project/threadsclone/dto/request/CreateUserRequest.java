package com.project.threadsclone.dto.request;

import com.project.threadsclone.config.PasswordConstraint;
import com.project.threadsclone.model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank(message = "name is not be empty")
    private String name;

    @NotBlank(message = "surname is not be empty")
    private String surname;

    @NotBlank(message = "username is not be empty")
    private String username;

    @NotBlank(message = "mail is not be empty")
    @Email(message = "mail is not valid")
    private String mail;

    @NotBlank(message = "number is not be empty")
    private String number;

    @NotBlank(message = "password is not be empty")
    @PasswordConstraint
    private String password;

    private Set<Role> authorities;
}
