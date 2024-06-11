package com.example.todoproject.dao;

import com.example.todoproject.db.DB;
import com.example.todoproject.models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements ITaskDao{
    Connection con;

    public TaskDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Task task) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "INSERT INTO tasks(title, description) VALUES (?, ?)");
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(statement);

        }
    }

    @Override
    public void update(Task task) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "UPDATE tasks SET title =? , description =? WHERE id =? ");
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setLong(3, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(statement);

        }
    }

    @Override
    public void deleteById(Task task) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "DELETE FROM tasks WHERE id = ?");
            statement.setLong(1, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(statement);
        }
    }
    @Override
    public void findById(Integer id) {

    }

    @Override
    public List<Task> findAll() {
        List<Task> listTasks = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM tasks");
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Task task = new Task(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"));
                listTasks.add(task);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listTasks;
    }
}
