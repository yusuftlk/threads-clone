package com.project.threadsclone.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UpdateUserRequest {
    private String name;
    private String surname;
    private String userName;
    private String password;
}
