package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dto.documents_dto.ReturnWithItemsDTO;
import uz.indicator.db.entities.documents.ReturnProduct;


import java.util.List;

public interface ReturnProductDAO {

    List<ReturnProduct> getAll();
    ReturnProduct getLastReturnByCustomer(int customerId);
    ReturnProduct getByDocumentNo(String documentNo);
    ReturnProduct getByCustomerId(int id);
    ObjectAndMessage save(ReturnWithItemsDTO returnProduct);
    ObjectAndMessage deleteById(int id);

}
