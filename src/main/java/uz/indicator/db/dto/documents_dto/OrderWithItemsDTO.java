package uz.indicator.db.dto.documents_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.documents.Order;
import uz.indicator.db.entities.documents.items.OrderItem;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderWithItemsDTO {
    private Order order;
    private List<OrderItem> items;
}
