package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.dto.documents_dto.OutgoWithItemsDTO;
import uz.indicator.db.entities.documents.Outgo;

import java.time.LocalDate;
import java.util.List;

public interface OutgoDAO {

    List<Outgo> getAll();

    Outgo getByDocumentNo(String documentNo);

    ObjectAndMessage save(OutgoWithItemsDTO outgo);
    ObjectAndMessage deleteById(int id);

}
