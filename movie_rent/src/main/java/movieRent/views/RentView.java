package movieRent.views;

import java.util.Scanner;

import movieRent.usecases.MovieUsecase;
import movieRent.usecases.RentUsecase;
import movieRent.usecases.UserUsecase;

public class RentView {
    public static void ShowListrent(String userid) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("User: " + userid);
        System.out.println("Movie Rent App");
        System.out.println("==========================");

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.GetRentList();

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - Rent List");
        System.out.println("[2] - Add New Rent");
        System.out.println("[3] - Return Rent");
        System.out.println("[0] - Back to Welcome Page");
        System.out.println();
        System.out.print("Input Menu (number) : ");
        Integer menu = inputScanner.nextInt();
        System.out.println();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                rentUsecase.GetRentList();
                ShowListrent(userid);
                break;
            case 2:
                ShowAddRent(userid);
                break;
            case 3:
                ShowReturnRent(userid);
                break;
            default:
                System.out.println("Please input the correct number from menu");
                ShowListrent(userid);
                break;
        }

        inputScanner.close();
    }

    private static void ShowAddRent(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("==========================");
        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.GetMovieList();
        System.out.print("Movie ID: ");
        Integer iMovieID = inputScanner.nextInt();
        inputScanner.nextLine();
        UserUsecase userUsecase = new UserUsecase();
        userUsecase.GetUserList();
        System.out.print("Renter ID: ");
        String iRenterID = inputScanner.nextLine();

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.AddRent(iRenterID, iMovieID);

        ShowListrent(userid);
        inputScanner.close();
    }

    private static void ShowDeleteRent(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("rent id: ");
        Integer iRentId = inputScanner.nextInt();

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.DeleteRent(iRentId);

        ShowListrent(userid);
        inputScanner.close();
    }

    private static void ShowReturnRent(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.print("rent id: ");
        Integer iRentId = inputScanner.nextInt();

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.ReturnRent(iRentId);

        ShowListrent(userid);
        inputScanner.close();
    }
}
