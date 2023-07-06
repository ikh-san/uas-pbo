package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.UserEntity;
import movieRent.models.UserModel;
import movieRent.utils.DBConnectionUtil;
import movieRent.utils.ValidationUtils;

public class UserUsecase {
    private HikariDataSource dataSource;
    private UserModel userModel;

    public UserUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        userModel = new UserModel(dataSource);
    }

    public void GetUserList() {
        userModel.findAllUser();
    }

    public void AddUser(String userid, String pass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
        userData.setPassword(pass);
        try {
            ValidationUtils.RegisterValidate(userData);
            userModel.CreateUser(userData);
            System.out.println("Create User Succeed");
        } catch (Throwable ex) {
            System.out.println("Register invalid - " + ex.getMessage());
        }
    }

    public void ChangePasswordUser(String newuserid, String newpass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(newuserid);
        userData.setPassword(newpass);
        userModel.ChangePassword(userData);
        System.out.println("Change Password Succeed!");
    }

    public Boolean IsUserExist(String username) {
        if (userModel.CheckUserExist(username)) {
            return true;
        } else {
            return false;
        }
    }
}
