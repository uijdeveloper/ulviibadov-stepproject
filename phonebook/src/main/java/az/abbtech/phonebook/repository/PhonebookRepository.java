package az.abbtech.phonebook.repository;

import az.abbtech.phonebook.entity.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, UUID> {

    Phonebook findPhoneBookEntityById(String userId);

}

