package model.Dao;

import model.entites.Department;
import model.entites.Seller;

import java.util.List;

public interface SellerDao {
    void insert (Seller obj);
    void update (Seller obj);
    void delateById(Integer id);
    Department findByid(Integer id);
    List<Seller> findAll();

}
