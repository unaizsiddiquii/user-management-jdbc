package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users(name, email) VALUES (? , ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
            System.out.println("User added Successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        String query = "SELECT * FROM user WHERE id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM users;";
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE user SET name = ? , email = ?, WHERE id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
            System.out.println("User Update.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("User Deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
