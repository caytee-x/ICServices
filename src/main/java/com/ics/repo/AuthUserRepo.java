package com.ics.repo;

import com.ics.models.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthUserRepo extends JpaRepository<AuthUser, Long> {

    @Query(value = "SELECT u FROM AuthUser u ORDER BY u.id DESC")
    public AuthUser findTopByOrderByIdDesc();

    @Query(value= "SELECT u FROM AuthUser u WHERE u.fps=?1")
    public AuthUser existsByFps(String fps);




}
