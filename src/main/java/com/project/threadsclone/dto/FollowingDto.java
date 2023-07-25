package com.project.threadsclone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.threadsclone.model.User;
import jakarta.persistence.*;

public class FollowingDto {
    private Long id;
    private UserDto user;
}
