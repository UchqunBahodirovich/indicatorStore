package uz.indicator.db.repositories.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.indicator.db.entities.documents.Outgo;


import java.time.LocalDate;
import java.util.List;

public interface OutgoRepository extends JpaRepository<Outgo,Integer> {

    List<Outgo> findAll();

    Outgo findById(int id);
    Outgo findByDocumentNo(String documentNo);




}
