package uz.indicator.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.WarehouseItem;


import java.util.List;

public interface WarehouseItemRepository extends JpaRepository<WarehouseItem, Integer> {

    List<WarehouseItem> findAllByDeletedTrue();
    List<WarehouseItem> findAllByProductIdAndDeletedFalse(int productId);
    List<WarehouseItem> findAllByWarehouseIdAndDeletedFalse(int warehouseId);
    List<WarehouseItem> countByWarehouseIdAndProductIdAndDeletedFalse(int warehouseId, int productId);
    WarehouseItem findByWarehouseIdAndProductIdAndDeletedFalse(int warehouseId, int productId);
    WarehouseItem findByWarehouseIdAndProductId(int warehouseId, int productId);
    double countAllByWarehouseId(int warehouseId);

}
