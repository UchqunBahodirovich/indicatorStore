package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.items.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
