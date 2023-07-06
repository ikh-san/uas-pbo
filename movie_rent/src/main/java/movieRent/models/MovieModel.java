package movieRent.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import movieRent.entities.movieEntity;
import movieRent.utils.PrintUtils;

public class MovieModel {
    private DataSource dataSource;
    private PrintUtils printUtils;

    public MovieModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public movieEntity[] FindALLMovie() {
        printUtils = new PrintUtils(dataSource);
        String sql = "SELECT * FROM movie";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // stmt.setString(1, userid);
            ResultSet resultSet = stmt.executeQuery();
            List<movieEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                movieEntity movie = new movieEntity();
                movie.setMovieId(resultSet.getInt("movie_id"));
                movie.setMovieTitle(resultSet.getString("movie_title"));
                movie.setMovieGenre(resultSet.getString("movie_genre"));
                list.add(movie);
            }
            resultSet = stmt.executeQuery();
            printUtils.PrintResult(resultSet);
            return list.toArray(new movieEntity[] {});
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public void CreateMovie(movieEntity movie) {
        String sql = "INSERT INTO movie (movie_title, movie_genre) VALUES (?,?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, movie.getMovieTitle());
            stmt.setString(2, movie.getMovieGenre());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void DeleteMovie(Integer movieid) {
        String sql = "DELETE FROM movie WHERE movie_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, movieid);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
