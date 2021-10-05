package uz.indicator.db.dto.documents_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.documents.Outgo;
import uz.indicator.db.entities.documents.items.OutgoItem;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OutgoWithItemsDTO {

    private Outgo outgo;
    private List<OutgoItem> items;

}
