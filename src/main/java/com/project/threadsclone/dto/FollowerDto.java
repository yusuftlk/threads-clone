package com.project.threadsclone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.threadsclone.model.User;
import jakarta.persistence.*;

public class FollowerDto {
    private Long id;
    private UserDto user;
}
