package User.Login.dao;

import User.User;

import java.util.List;

public interface UserDao {

    void add(User user) throws Exception;

    List<User> findAll();

    User findById(int id);
}
