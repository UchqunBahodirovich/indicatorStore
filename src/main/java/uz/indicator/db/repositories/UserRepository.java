package uz.indicator.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.User;
import uz.indicator.db.enums.UserType;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByDeletedFalse();

    List<User> findAllByDeletedTrue();
    List<User> findAllByUserTypeAndDeletedFalse(UserType userType);

    User findById(int id);

    User findByUsername(String username);

}
