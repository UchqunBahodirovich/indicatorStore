package uz.indicator.db.dao.documents;

import org.springframework.stereotype.Service;
import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dao.Interfaces.OrderDAO;
import uz.indicator.db.dto.documents_dto.OrderWithItemsDTO;
import uz.indicator.db.entities.documents.Order;
import uz.indicator.db.entities.documents.items.OrderItem;
import uz.indicator.db.repositories.documents.OrderItemRepository;
import uz.indicator.db.repositories.documents.OrderRepository;


import java.time.LocalDate;
import java.util.List;

@Service
public class OrderDAOImpl implements OrderDAO {

    private OrderRepository repository;
    private OrderItemRepository itemRepository;

    public OrderDAOImpl(OrderRepository repository, OrderItemRepository itemRepository) {
        this.repository=repository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order getByDocumentNo(String documnetNo) {
        return repository.findByDocumentNo(documnetNo);
    }

    @Override
    public ObjectAndMessage save(OrderWithItemsDTO order) {
        Order saved;
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();
        this.registerAndSaveOrderItem(order.getItems());

        Order temp = repository.findById(order.getOrder().getId());

        if (temp != null) {
            temp.setDeleted(false);
            temp.setDocumentNo(order.getOrder().getDocumentNo());

            saved = repository.save(temp);
            objectAndMessage.setMessage("Buyurtma ma'lumotlari yangilandi");
        } else {
            saved =repository.save(order.getOrder());
            objectAndMessage.setMessage("Yangi buyurtma ro'yhatdan o'tkazildi");
        }
        objectAndMessage.setObject(saved);
        return objectAndMessage;
    }

    @Override
    public ObjectAndMessage deleteById(int id) {
        Order order=repository.findById(id);
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();
        objectAndMessage.setMessage("Order has been deleted!");
        order.setDeleted(true);
        objectAndMessage.setObject(null);
        repository.save(order);
        return objectAndMessage;
    }

    private void registerAndSaveOrderItem(List<OrderItem> list) {
        this.itemRepository.saveAll(list);
    }

}
