package ru.gonsoronov.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gonsoronov.springboot.dao.UserDAO;
import ru.gonsoronov.springboot.model.User;
import jakarta.validation.Valid;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public Object getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Override
    public void updateUser(@Valid User user) {
        userDAO.updateUser(user);
    }
}