package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.ReturnProduct;


import java.util.List;

public interface ReturnProductRepository extends JpaRepository<ReturnProduct,Integer> {

    List<ReturnProduct> findAll();
    ReturnProduct findDistinctFirstByCustomerIdAndDeletedFalseOrderByIdDesc(int customerId);
    ReturnProduct findByDocumentNo(String documentNo);
    ReturnProduct findById(int id);
    ReturnProduct findByCustomerId(int id);

}
