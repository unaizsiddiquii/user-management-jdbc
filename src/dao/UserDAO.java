package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    User getUserById(int id);

    List<User> getAllUser();

    void updateUser(User user);

    void deleteUser(int id);

}
