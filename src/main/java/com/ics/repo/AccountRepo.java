package com.ics.repo;

import com.ics.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepo extends JpaRepository<Account, Long> {

    @Query(value="SELECT u FROM Account u WHERE u.fps=?1")
    public Account findByFps(String fps);
}
