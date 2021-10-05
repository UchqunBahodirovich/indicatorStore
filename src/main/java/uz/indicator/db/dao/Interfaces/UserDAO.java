package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.UserAndMessage;
import uz.indicator.db.entities.User;
import uz.indicator.db.enums.UserType;


import java.util.List;

public interface UserDAO {

    List<User> getAllByDeletedFalse();

    List<User> getAllByDeletedTrue();
    List<User> getAllUsersByTheirType(UserType userType);

    User getById(int id);

    User getByUsername(String username);

    String deleteById(int id);

    UserAndMessage saveAndEditUser(User user);


}
