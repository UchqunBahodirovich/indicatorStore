package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dto.documents_dto.OrderWithItemsDTO;
import uz.indicator.db.entities.documents.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {

    List<Order> getAll();

    Order getByDocumentNo(String documentNo);

    ObjectAndMessage save(OrderWithItemsDTO order);
    ObjectAndMessage deleteById(int id);

}
