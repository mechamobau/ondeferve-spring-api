package br.com.ondeferve.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ondeferve.api.model.Confirmation;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {

    @Query("select c from Confirmation c where c.event.id = ?1")
    List<Confirmation> findByEventId(Long id);

    @Query("select count(c) > 0 from Confirmation c where event_id = ?1 and user_id = ?2")
    boolean verifyConfirmation(Long event_id, Long user_id);

    @Query("select c from Confirmation c where event_id = ?1 and user_id = ?2")
    Confirmation findConfirmation(Long event_id, Long user_id);
}
