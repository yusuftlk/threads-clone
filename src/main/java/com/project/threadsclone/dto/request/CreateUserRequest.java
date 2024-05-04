package com.project.threadsclone.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateUserRequest {
    private String name;
    private String surname;
    private String userName;
    private String mail;
    private String password;
}
