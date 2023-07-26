package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.FollowerDto;
import com.project.threadsclone.dto.FollowingDto;
import com.project.threadsclone.dto.PostDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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
