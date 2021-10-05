package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.items.ReturnProductItem;


public interface ReturnProductItemRepository extends JpaRepository<ReturnProductItem, Integer> {
}
