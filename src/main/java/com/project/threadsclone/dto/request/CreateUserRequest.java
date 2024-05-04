package com.project.threadsclone.dto.request;

import com.project.threadsclone.config.PasswordConstraint;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

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
    private String userName;

    @NotBlank(message = "mail is not be empty")
    @Email(message = "mail is not valid")
    private String mail;

    @NotBlank(message = "password is not be empty")
    @PasswordConstraint
    private String password;
}
