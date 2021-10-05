package uz.indicator.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import uz.indicator.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "db_warehouse_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WarehouseItem extends BaseEntity {

    @Nullable
    @Column
    private int warehouseId;

    @Nullable
    @Column
    private int productId;

    @Nullable
    @Column
    private int vendorId;

    @Nullable
    @Column
    private double quantity;

    @Nullable
    @Column
    private double price;

    @Nullable
    @Column
    private double cost;

    @Nullable
    @Column
    private double priceTotal;

    @Nullable
    @Column
    private double costTotal;

}
