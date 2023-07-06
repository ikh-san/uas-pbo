package movieRent.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import movieRent.entities.RentEntity;

public class RentModel {
    private DataSource dataSource;

    public RentModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RentEntity[] FindALLRent() {
        String sql = "SELECT a.*,b.movie_title,b.movie_genre FROM rent a left join movie b on a.movie_id = b.movie_id";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            // stmt.setString(1, userid);
            ResultSet resultSet = stmt.executeQuery();
            List<RentEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                RentEntity rent = new RentEntity();
                rent.setRentId(resultSet.getInt("rent_id"));
                rent.setRentDate(resultSet.getString("rent_date"));
                rent.setReturnDate(resultSet.getString("return_date"));
                rent.setMovieId(resultSet.getInt("movie_id"));
                rent.setUserid(resultSet.getString("userid"));
                rent.setMovieTitle(resultSet.getString("movie_title"));
                rent.setMovieGenre(resultSet.getString("movie_genre"));
                list.add(rent);
            }
            return list.toArray(new RentEntity[] {});
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public void CreateRent(RentEntity movie) {
        String sql = "INSERT INTO rent (rent_date, return_date, movie_id, userid) VALUES (now(),NULL,?,?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, movie.getMovieId());
            stmt.setString(2, movie.getUserid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void DeleteRent(Integer rentid) {
        String sql = "DELETE FROM rent WHERE rent_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rentid);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void ReturnRent(Integer rentid) {
        String sql = "Update rent SET return_date = now() WHERE rent_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rentid);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
