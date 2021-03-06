package uz.indicator.db.dto.documents_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.documents.ReturnProduct;
import uz.indicator.db.entities.documents.items.ReturnProductItem;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnWithItemsDTO {

    private ReturnProduct returnProduct;
    private List<ReturnProductItem> items;

}
