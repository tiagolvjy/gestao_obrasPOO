package com.example.todoproject.dao;

import com.example.todoproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao{
    Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(User user) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO users(email, password) VALUES (?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void findById(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Boolean findByUsernameAndPassword(String username, String password) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
