package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.movieEntity;
import movieRent.models.MovieModel;
import movieRent.utils.DBConnectionUtil;

public class MovieUsecase {
    private HikariDataSource dataSource;
    private MovieModel taskModel;

    public MovieUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        taskModel = new MovieModel(dataSource);

    }

    public void GetMovieList() {
        taskModel.FindALLMovie();
    }

    public void AddMovie(String movieTitle, String movieGenre) {
        movieEntity taskData = new movieEntity();
        taskData.setMovieTitle(movieTitle);
        taskData.setMovieGenre(movieGenre);

        taskModel.CreateMovie(taskData);
        System.out.println("Create Movie Succeed!");
    }

    public void DeleteMovie(Integer id) {
        taskModel.DeleteMovie(id);
        System.out.println("Delete Movie Succeed");
    }
}
