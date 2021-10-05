package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dto.documents_dto.IncomeWithItemsDTO;
import uz.indicator.db.entities.documents.Income;


import java.time.LocalDate;
import java.util.List;

public interface IncomeDAO {

    List<Income> getAll();
    Income getByDocumentNo(String documentNo);

    ObjectAndMessage save(IncomeWithItemsDTO incomeWithItemsDTO);
    ObjectAndMessage deleteById(int id);

}
