package uz.indicator.db.dto.documents_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.documents.Income;
import uz.indicator.db.entities.documents.items.IncomeItem;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class IncomeWithItemsDTO {
    private Income income;
    private List<IncomeItem> items;
}
