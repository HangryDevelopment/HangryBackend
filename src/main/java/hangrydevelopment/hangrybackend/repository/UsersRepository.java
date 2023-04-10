package hangrydevelopment.hangrybackend.repository;

import hangrydevelopment.hangrybackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
   User findByUserName(String userName);
}
