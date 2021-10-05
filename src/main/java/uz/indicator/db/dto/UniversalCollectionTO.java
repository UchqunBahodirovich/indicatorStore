package uz.indicator.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.Products;
import uz.indicator.db.entities.Warehouse;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversalCollectionTO {

    private List<Products> products;
    private List<Warehouse> warehouses;

}
