package com.project.threadsclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
