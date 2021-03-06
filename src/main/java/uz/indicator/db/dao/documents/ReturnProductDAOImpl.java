package uz.indicator.db.dao.documents;

import org.springframework.stereotype.Service;
import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dao.Interfaces.ReturnProductDAO;
import uz.indicator.db.dao.Interfaces.WarehouseItemDAO;
import uz.indicator.db.dto.documents_dto.ReturnWithItemsDTO;
import uz.indicator.db.entities.documents.ReturnProduct;
import uz.indicator.db.entities.documents.items.ReturnProductItem;
import uz.indicator.db.repositories.documents.ReturnProductItemRepository;
import uz.indicator.db.repositories.documents.ReturnProductRepository;


import java.util.List;

@Service
public class ReturnProductDAOImpl implements ReturnProductDAO {

    private ReturnProductRepository repository;
    private ReturnProductItemRepository returnProductItemRepository;
    private WarehouseItemDAO warehouseItemDAO;

    public ReturnProductDAOImpl(ReturnProductRepository repository, ReturnProductItemRepository returnProductItemRepository, WarehouseItemDAO warehouseItemDAO) {
        this.repository = repository;
        this.returnProductItemRepository = returnProductItemRepository;
        this.warehouseItemDAO = warehouseItemDAO;
    }

    @Override
    public List<ReturnProduct> getAll() {
        return repository.findAll();
    }

    @Override
    public ReturnProduct getLastReturnByCustomer(int customerId) {
        return repository.findDistinctFirstByCustomerIdAndDeletedFalseOrderByIdDesc(customerId);
    }

    @Override
    public ReturnProduct getByDocumentNo(String documentNo) {
        return repository.findByDocumentNo(documentNo);
    }

    @Override
    public ReturnProduct getByCustomerId(int id) {
        return repository.findByCustomerId(id);
    }

    @Override
    public ObjectAndMessage save(ReturnWithItemsDTO returnProduct) {

        ReturnProduct saved;
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();
        ReturnProduct temp = returnProduct.getReturnProduct();
        this.registerAndSaveReturnOfTheItem(returnProduct.getItems());

        saved = repository.save(temp);
        objectAndMessage.setMessage("Ro'yhatdagi mahsulotlar omborga qaytarildi");

        objectAndMessage.setObject(saved);
        return objectAndMessage;
    }

    @Override
    public ObjectAndMessage deleteById(int id) {
        ObjectAndMessage objectAndMessage = new ObjectAndMessage();
        objectAndMessage.setMessage("The returned products has been removed from the list.");
        objectAndMessage.setObject(null);
        repository.deleteById(id);

        return objectAndMessage;
    }

    private void registerAndSaveReturnOfTheItem(List<ReturnProductItem> list) {
        for (ReturnProductItem item : list) {
            this.warehouseItemDAO.registerReturnToWarehouse(item);
        }

        this.returnProductItemRepository.saveAll(list);
    }

}
