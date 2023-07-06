package movieRent.views;

import java.util.Scanner;

import movieRent.usecases.MovieUsecase;

public class MovieView {
    public static void ShowListmovie(String userid) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("User: " + userid);
        System.out.println("Movie Rent App");
        System.out.println("==========================");

        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.GetMovieList();

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - Movie List");
        System.out.println("[2] - Add New Movie");
        System.out.println("[3] - Delete Movie");
        System.out.println("[4] - Back to Home Page");
        System.out.println("[0] - Logout");
        System.out.println();
        System.out.print("Input Menu (number) : ");
        Integer menu = inputScanner.nextInt();
        System.out.println();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                movieUsecase.GetMovieList();
                ShowListmovie(userid);
                break;
            case 2:
                ShowAddMovie(userid);
                break;
            case 3:
                ShowDeleteMovie(userid);
                break;
            case 4:
                HomeView.ShowHomePage(userid);
                break;
            default:
                System.out.println("Please input the correct number from menu");
                ShowListmovie(userid);
                break;
        }

        inputScanner.close();
    }

    private static void ShowAddMovie(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.print("Movie Title: ");
        String iTitle = inputScanner.nextLine();
        System.out.print("Movie Genre: ");
        String iGenre = inputScanner.nextLine();

        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.AddMovie(iTitle, iGenre);

        ShowListmovie(userid);
        inputScanner.close();
    }

    private static void ShowDeleteMovie(String userid) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("movie id: ");
        Integer iMovieId = inputScanner.nextInt();

        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.DeleteMovie(iMovieId);

        ShowListmovie(userid);
        inputScanner.close();
    }
}
