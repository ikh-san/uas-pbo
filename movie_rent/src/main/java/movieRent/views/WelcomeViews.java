package movieRent.views;

import java.util.Scanner;

public class WelcomeViews {
    public static void main(String[] args) {
        ShowWelcomeView();
    }

    public static void ShowWelcomeView() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to Movie Rent Apps");
        System.out.println("=======================");
        System.out.println();
        System.out.println("[1] - Login Page");
        System.out.println("[2] - Create Account");
        System.out.println("[0] - Exit");
        System.out.println();
        System.out.print("Input Menu (number) : ");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 1:
                System.out.println("Go to Login Page");
                LoginView.ShowLoginPage();
                break;
            case 2:
                System.out.println("Go to Create User Page");
                UserView.ShowAddUser("new");
                break;
            case 0:
                System.out.println("Application Closed!");
                System.exit(0);
                break;
            default:
                System.out.println("Please input the correct number from menu");
                ShowWelcomeView();
                break;
        }
        inputScanner.close();
    }
}
