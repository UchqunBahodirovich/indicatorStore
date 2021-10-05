package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.items.IncomeItem;

public interface IncomeItemRepository extends JpaRepository<IncomeItem, Integer> {
}
