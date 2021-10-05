package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.Income;


import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {

    @Override
    List<Income> findAll();

    Income findById(int id);
    Income findByDocumentNo(String documentNo);


}
