package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.UserEntity;
import movieRent.models.UserModel;
import movieRent.utils.DBConnectionUtil;

public class UserUsecase {
    private HikariDataSource dataSource;
    private UserModel userModel;

    public UserUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        userModel = new UserModel(dataSource);
    }

    public void GetUserList() {
        UserEntity[] userList = userModel.findAllUser();
        for (UserEntity user : userList) {
            System.out.println("- "+user.getUserid());
        }
    }

    public void AddUser(String userid, String pass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
        userData.setPassword(pass);
        userModel.CreateUser(userData);
        System.out.println("Create User Succeed");
    }

    public void ChangePasswordUser(String newuserid, String newpass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(newuserid);
        userData.setPassword(newpass);
        userModel.ChangePassword(userData);
        System.out.println("Change Password Succeed!");
    }
}
