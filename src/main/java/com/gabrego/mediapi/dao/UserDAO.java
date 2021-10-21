package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findById(int id);

    public User findByEmail(String email);

    public void save(User user);

    public void deleteById(int id);
}
