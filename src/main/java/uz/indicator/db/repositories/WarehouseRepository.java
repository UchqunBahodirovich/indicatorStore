package uz.indicator.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.Warehouse;


import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {

    Warehouse findById(int id);
    List<Warehouse> findAll();

}
