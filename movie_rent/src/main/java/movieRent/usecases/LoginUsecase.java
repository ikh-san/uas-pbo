package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.UserEntity;
import movieRent.models.LoginModel;
import movieRent.utils.DBConnectionUtil;

public class LoginUsecase {
    private HikariDataSource dataSource;
    private LoginModel loginModel;

    public LoginUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        loginModel = new LoginModel(dataSource);
    }

    public String LoginValidate(String userid, String password) {
        if (userid.equals("") || password.equals("")) {
            return "userid or password cannot be empty!";
        }

        UserEntity user = new UserEntity();
        user.setUserid(userid);
        user.setPassword(password);

        if (!loginModel.CheckUserExist(user.getUserid())) {
            return "userid is not exist, please try again.";
        }

        if (!loginModel.UserPasswordValid(user)) {
            return "userid and password is not valid, please try again";
        }

        return "";
    }
}
