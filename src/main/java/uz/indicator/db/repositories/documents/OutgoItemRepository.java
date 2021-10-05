package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.items.OutgoItem;

public interface OutgoItemRepository extends JpaRepository<OutgoItem, Integer> {
}
