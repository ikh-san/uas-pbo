package movieRent.usecases;

import com.zaxxer.hikari.HikariDataSource;

import movieRent.entities.RentEntity;
import movieRent.models.RentModel;
import movieRent.utils.DBConnectionUtil;

public class RentUsecase {
    private HikariDataSource dataSource;
    private RentModel rentModel;

    public RentUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        rentModel = new RentModel(dataSource);

    }

    public void GetRentList() {
        rentModel.FindALLRent();
    }

    public void AddRent(String userid, Integer movieid) {
        RentEntity rentData = new RentEntity();
        rentData.setUserid(userid);
        rentData.setMovieId(movieid);

        rentModel.CreateRent(rentData);
        System.out.println("Create Rent Succeed!");
    }

    public void DeleteRent(Integer id) {
        rentModel.DeleteRent(id);
        System.out.println("Delete Rent Succeed");
    }

    public void ReturnRent(Integer id) {
        rentModel.ReturnRent(id);
        System.out.println("Return Rent Succeed");
    }
}
