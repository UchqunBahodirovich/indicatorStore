package uz.indicator.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.TradeMark;

import java.util.List;

public interface TradeMarkRepository extends JpaRepository<TradeMark,Integer> {

    @Override
    List<TradeMark> findAll();

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities.
     */
    @Override
    long count();

    /**
     * Deletes the entity with the given id.
     *
     * @param integer must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
     */
    @Override
    void deleteById(Integer integer);
}
