package movieRent.entities;
public class RentEntity extends movieEntity {

    private Integer rent_id;
    private String rent_date;
    private String return_date;
    private String userid;

    public Integer getRentId() {
        return rent_id;
    }

    public void setRentId(Integer rent_id) {
        this.rent_id = rent_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRentDate() {
        return rent_date;
    }

    public void setRentDate(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturnDate() {
        return return_date;
    }

    public void setReturnDate(String return_date) {
        this.return_date = return_date;
    }
}