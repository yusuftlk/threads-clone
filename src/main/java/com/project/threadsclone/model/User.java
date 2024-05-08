package com.project.threadsclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Column(unique=true)
    private String userName;
    @Column(unique=true)
    private String mail;

    private String number;

    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Lob
    @Column(name = "userProfileImage",length = 1000)
    private byte[] userProfileImage;

    private boolean isActive = true;

    public User(String name, String surname, String userName, String mail, String number, String password, LocalDateTime createdAt) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.mail = mail;
        this.number = number;
        this.password = password;
        this.createdAt = createdAt;
    }
}
