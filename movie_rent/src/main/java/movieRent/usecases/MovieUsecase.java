package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.movieEntity;
import movieRent.models.MovieModel;
import movieRent.utils.DBConnectionUtil;

public class MovieUsecase {
    private HikariDataSource dataSource;
    private MovieModel movieModel;

    public MovieUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        movieModel = new MovieModel(dataSource);

    }

    public void GetMovieList() {
        movieModel.FindALLMovie();
    }

    public void AddMovie(String movieTitle, String movieGenre) {
        movieEntity movieData = new movieEntity();
        movieData.setMovieTitle(movieTitle);
        movieData.setMovieGenre(movieGenre);
        if(!IsTitleExist(movieTitle)){
        movieModel.CreateMovie(movieData);
        System.out.println("Create Movie Succeed!");
        } else {
            System.out.println(movieTitle + " is already exists.");
        }
    }

    public void DeleteMovie(Integer movie_id) {
        // if (!IsNewsUseThisMovie(name) && IsMovieExist(name)) {
        if (IsMovieExist(movie_id)) {
            if (!IsNewsUseThisMovie(movie_id)) {
                movieModel.DeleteMovie(movie_id);
                System.out.println("Delete movie succeed");
            } else {
                System.out.println("This Movie has Rent, delete movie failed");
            }
        } else {
            System.out.println("movie_id " + movie_id + " is not found, delete movie failed");
        }
    }

    public Boolean IsMovieExist(Integer movie_id) {
        if (movieModel.CheckMovieExist(movie_id)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean IsNewsUseThisMovie(Integer movie_id) {
        if (movieModel.IsRentUseThisMovie(movie_id)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean IsTitleExist(String title) {
        if (movieModel.CheckTitleExist(title)) {
            return true;
        } else {
            return false;
        }
    }
}
