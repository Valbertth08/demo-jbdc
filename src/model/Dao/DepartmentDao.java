package model.Dao;

import model.entites.Department;

import java.util.List;

public interface DepartmentDao {

    void insert (Department obj);
    void update (Department obj);
    void delateById(Integer id);
    Department findByid(Integer id);
    List<Department> findAll();

}
