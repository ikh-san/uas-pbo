package movieRent.entities;

public class movieEntity {
    private Integer movie_id;
    private String movie_title;
    private String movie_genre;

    public Integer getMovieId() {
        return movie_id;
    }

    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieGenre() {
        return movie_genre;
    }

    public void setMovieGenre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovieTitle() {
        return movie_title;
    }

    public void setMovieTitle(String movie_title) {
        this.movie_title = movie_title;
    }
}
