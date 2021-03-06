package uz.indicator.db.dao.documents;

import org.springframework.stereotype.Service;
import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dao.Interfaces.IncomeDAO;
import uz.indicator.db.dao.Interfaces.WarehouseItemDAO;
import uz.indicator.db.dto.documents_dto.IncomeWithItemsDTO;
import uz.indicator.db.entities.documents.Income;
import uz.indicator.db.entities.documents.items.IncomeItem;
import uz.indicator.db.repositories.documents.IncomeItemRepository;
import uz.indicator.db.repositories.documents.IncomeRepository;


import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeDAOImpl implements IncomeDAO {

    private IncomeRepository repository;
    private IncomeItemRepository itemRepository;
    private WarehouseItemDAO warehouseItemDAO;

    public IncomeDAOImpl(IncomeRepository incomeRepository, IncomeItemRepository itemRepository, WarehouseItemDAO warehouseItemDAO) {
        repository = incomeRepository;
        this.itemRepository = itemRepository;
        this.warehouseItemDAO = warehouseItemDAO;
    }

    @Override
    public List<Income> getAll() {
        return repository.findAll();
    }




    @Override
    public Income getByDocumentNo(String documentNo) {
        return repository.findByDocumentNo(documentNo);
    }


    @Override
    public ObjectAndMessage save(IncomeWithItemsDTO incomeWithItems) {
        Income saved;
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();

        Income temp = incomeWithItems.getIncome();
        this.saveAndRegisterIncomeItems(incomeWithItems.getItems());

        saved = repository.save(temp);
        objectAndMessage.setMessage("Mahsulotlar kirimi ro'yhatdan o'tkazildi.");

        objectAndMessage.setObject(saved);
        return objectAndMessage;
    }

    @Override
    public ObjectAndMessage deleteById(int id) {
        Income income = repository.findById(id);
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();
        objectAndMessage.setMessage("Income has been deleted!");
        income.setDeleted(true);
        objectAndMessage.setObject(null);

        return objectAndMessage;
    }

    private void saveAndRegisterIncomeItems(List<IncomeItem> list) {
        for (IncomeItem item : list) {
            warehouseItemDAO.registerIncomeToWarehouse(item);
        }
        itemRepository.saveAll(list);
    }

}
