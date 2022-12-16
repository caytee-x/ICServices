package com.ics;

import com.ics.models.User;
import com.ics.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;


    //C1
    //REQ  B-F01
    @Test
    public void loginValid() {
        String fps = "2102";
        String pwd = "moose";
        Boolean valid;
        User user = repo.findByFps(fps, pwd);
    }


    //C2
    //REQ  B-F01
    @Test
    public void loginInvalid(){
        String fps = "000";
        String pwd = "moose";
        Boolean valid;
        User user = repo.findByFps(fps, pwd);
        assertThat(user==null);

    }

    //C5
    //REQ B-F11
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFps("18181");
        user.setPassword("love");
        user.setFirst_name("J");
        user.setLast_name("C");
        user.setUnit_num(1);
        user.setCell_num(2);

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getFps()).isEqualTo(existUser.getFps());

    }

    //C6
    // REQ B-F11
    @Test
    public void testCreateInvalidUser() {
        User user = new User();

        user.setPassword("34FD5");
        user.setFirst_name("Jamie");
        user.setLast_name("Mcdonald");
        user.setUnit_num(10);
        user.setCell_num(2);

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getFps()).isEqualTo(existUser.getFps());

    }



}
