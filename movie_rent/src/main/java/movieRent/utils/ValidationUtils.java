package movieRent.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import movieRent.entities.UserEntity;

public class ValidationUtils {
    public static void LoginValidate(UserEntity user) throws Throwable {
        if (user.getUserid().isEmpty()) {
            throw new Throwable("username is blank");
        } else if (user.getPassword().isEmpty()) {
            throw new Throwable("getPassword() is blank");
        }
    }

    public static void RegisterValidate(UserEntity user) throws Throwable {
        if (user.getUserid().isEmpty()) {
            throw new Throwable("username is blank");
        } else if (user.getPassword().isEmpty()) {
            throw new Throwable("password is blank");
        }
    }

}