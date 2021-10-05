package uz.indicator.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {
    @Override
    List<Products> findAll();

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be {@literal null}.
     * @return the saved entity; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    @Override
    <S extends Products> S save(S entity);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities.
     */
    @Override
    long count();

    @Override
    void deleteById(Integer integer);
    List<Products> findAllByCategoryId(int id);
    List<Products> findAllByCategoryIdAndTradeMarkId(int categoryId,int tradeMarkId);
    List<Products> findAllByCategoryIdAndTradeMarkIdAndPriceBetween(int categoryId,int tradeMarkId,double a,double b);
    Products findById(int id);
    List<Products> findAllByDeletedFalse();
    Products findByBarcode(String code);
}
