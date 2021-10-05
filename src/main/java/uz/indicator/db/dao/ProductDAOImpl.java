package uz.indicator.db.dao;

import org.springframework.stereotype.Service;
import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dao.Interfaces.ProductDAO;
import uz.indicator.db.entities.Products;
import uz.indicator.db.repositories.CategoryRepository;
import uz.indicator.db.repositories.ProductRepository;
import uz.indicator.db.repositories.TradeMarkRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private TradeMarkRepository tradeMarkRepository;

    public ProductDAOImpl(ProductRepository productRepository , TradeMarkRepository tradeMarkRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository=categoryRepository;
        this.tradeMarkRepository=tradeMarkRepository;
    }

    @Override
    public ObjectAndMessage saveProduct(Products product) {
        Products saved;
        ObjectAndMessage oam = new ObjectAndMessage();

        Products temp = productRepository.findById(product.getId());
        if (temp != null) {
            temp = product;

            saved = productRepository.save(temp);
            oam.setMessage("Mahsulot haqidagi ma'lumot yangilandi");
        } else {
            saved = productRepository.save(product);
            oam.setMessage("Yangi mahsulot yaratildi");
        }
        oam.setObject(saved);
        return oam;
    }

    @Override
    public Products getById(int id) {
    return productRepository.findById(id);
    }

    @Override
    public List<Products> getByBarCode(String code) {
        List<Products> products=new ArrayList<>();
        products.add(productRepository.findByBarcode(code));
        return products;
    }

    @Override
    public List<Products> getAll() {
        return productRepository.findAllByDeletedFalse();
    }

    @Override
    public String deleteById(int id) {
        Products product = productRepository.findById(id);
        product.setDeleted(true);
        productRepository.save(product);
        return "User successfully deleted!";
    }

}
