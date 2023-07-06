package movieRent.views;

import java.util.Scanner;

public class HomeView {
    public static void ShowHomePage(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - Movie Page");
        System.out.println("[2] - Rent Page");
        System.out.println("[3] - User Page");
        System.out.println("[0] - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Menu (number) : ");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                MovieView.ShowListmovie(userid);
                break;
            case 2:
                RentView.ShowListrent(userid);
                break;
            case 3:
                UserView.ShowUserMain(userid);
                break;
            default:
                System.out.println("Please input the correct number from menu");
                ShowHomePage(userid);
                break;
        }
        inputScanner.close();
    }
}
