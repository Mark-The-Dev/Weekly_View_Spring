package com.markthedev.weekly_view;

import com.markthedev.weekly_view.model.Users;
import com.markthedev.weekly_view.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsersRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsersRepository repo;

    @Test
    public void testCreateUser() {
        Users user = new Users();
        user.setEmail("swifttactics@gmail.com");
        user.setPassword("testpass");
        user.setFirst_name("Mark");
        user.setLast_name("Marcello");

        Users savedUser = repo.save(user);

        Users existUser = entityManager.find(Users.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

}
