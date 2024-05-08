package com.project.threadsclone.dto.request;

import com.project.threadsclone.config.PasswordConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UpdateUserRequest {

    @NotBlank(message = "name is not be empty")
    private String name;

    @NotBlank(message = "name is not be empty")
    private String surname;

    @NotBlank(message = "name is not be empty")
    private String userName;

    @NotBlank(message = "name is not be empty")
    private String number;

    @NotBlank(message = "name is not be empty")
    @PasswordConstraint
    private String password;
}
