package com.project.threadsclone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.threadsclone.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class FollowingDto {
    private Long id;
    private String userName;
}
