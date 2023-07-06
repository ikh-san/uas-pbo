package movieRent.views;

import java.util.Scanner;

import movieRent.usecases.UserUsecase;

public class UserView {
    public static void ShowUserMain(String userid) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("List User");

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.GetUserList();

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - User List");
        System.out.println("[2] - Add New User Account");
        System.out.println("[3] - Change Password");
        System.out.println("[4] - Back to Home Page");
        System.out.println("[0] - Logout");
        System.out.println();
        System.out.println("Input Menu (number) : ");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                userUsecase.GetUserList();
                ShowUserMain(userid);
                break;
            case 2:
                ShowAddUser(userid);
                break;
            case 3:
                ShowChangePassword(userid);
                break;
            case 4:
                HomeView.ShowHomePage(userid);
                break;
            default:
                System.out.println("Please input the correct number from menu");
                WelcomeViews.ShowWelcomeView();
                break;
        }
        inputScanner.close();
    }
    public static void ShowAddUser(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("userid: ");
        String sUserid = inputScanner.nextLine();
        System.out.println("password: ");
        String sPassword = inputScanner.nextLine();

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.AddUser(sUserid, sPassword);

        ShowUserMain(userid);
        inputScanner.close();
    }

    private static void ShowChangePassword(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("userid: ");
        String sUserid = inputScanner.nextLine();
        System.out.println("password: ");
        String sPassword = inputScanner.nextLine();

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.ChangePasswordUser(sUserid, sPassword);

        ShowUserMain(userid);
        inputScanner.close();
    }
}