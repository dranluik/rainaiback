package ee.valiit.rainaiback.domain.contact.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2 and u.status = ?3")
    Optional<User> findActiveUserBy(String username, String password, String status);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean usernameExistsBy(String username);

    @Query("select u from User u where u.id = ?1")
    User findUserBy(Integer id);

}