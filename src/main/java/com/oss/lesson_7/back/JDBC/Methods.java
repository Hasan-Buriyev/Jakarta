package com.oss.lesson_7.back.JDBC;

import com.oss.lesson_7.back.Enums.Gender;
import com.oss.lesson_7.back.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    private static final Methods instance = new Methods();

    public static Methods getInstance() {
        return instance;
    }

    private Methods() {
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        Gender.valueOf(rs.getString("gender"))
                        )
                );
            }
            conn.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return users;
        }

    }

    public boolean sava(User user) {
        try {
            Connection connection = JDBC.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into users(name, username, password, phone_number, gender) VALUES (?,?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getGender().toString());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
