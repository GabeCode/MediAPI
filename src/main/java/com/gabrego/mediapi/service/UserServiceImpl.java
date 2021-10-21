package com.gabrego.mediapi.service;

import com.gabrego.mediapi.dao.UserDAO;
import com.gabrego.mediapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        List<User> userList = userDAO.findAll();
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userDAO.findByEmail(email);
        return user;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }
}
