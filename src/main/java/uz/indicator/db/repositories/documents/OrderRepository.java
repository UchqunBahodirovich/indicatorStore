package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAll();

    Order findById(int id);
    Order findByDocumentNo(String documentNo);

}
