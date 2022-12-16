package com.ics.repo;

import com.ics.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

   @Query(value = "SELECT user FROM User user WHERE user.fps=?1 and user.password=?2")
    public User findByFps(String fps, String password);


}
