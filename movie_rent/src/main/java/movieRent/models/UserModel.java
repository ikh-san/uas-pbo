package movieRent.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import movieRent.entities.UserEntity;
import movieRent.utils.PrintUtils;

public class UserModel {
    private DataSource dataSource;
    private PrintUtils printUtils;

    public UserModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void CreateUser(UserEntity user) {
        String sql = "INSERT INTO user VALUES (?, ?, now())";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void ChangePassword(UserEntity user){
        String sql = "Update user SET password = ? where userid = ?";

        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getUserid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public UserEntity[] findAllUser(){
        printUtils = new PrintUtils(dataSource);
        String sql = "select * from user";

        try (
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement(); 
        ) {
            ResultSet resultSet = stmt.executeQuery(sql);
           List<UserEntity> list = new ArrayList<>(); 
           while(resultSet.next()){
            UserEntity user = new UserEntity();
            user.setUserid(resultSet.getString("userid"));
            list.add(user);
           }
            resultSet = stmt.executeQuery(sql);
            printUtils.PrintResult(resultSet);
           return list.toArray(new UserEntity[]{});
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean CheckUserExist(String username) {
        String sql = "SELECT * FROM user WHERE userid = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                return true;
            } else {
                resultSet.close();
                return false;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
