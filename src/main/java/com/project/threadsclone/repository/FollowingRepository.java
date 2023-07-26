package com.project.threadsclone.repository;

import com.project.threadsclone.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingRepository extends JpaRepository<Following, Long> {
}
