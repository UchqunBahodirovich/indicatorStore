package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.entities.Products;


import java.util.List;

public interface ProductDAO {

    ObjectAndMessage saveProduct(Products product);
    Products getById(int id);
    List<Products> getAll();
    String deleteById(int id);
    List<Products> getByBarCode(String code);
}
