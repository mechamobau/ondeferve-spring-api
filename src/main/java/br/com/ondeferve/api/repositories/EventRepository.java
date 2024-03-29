package br.com.ondeferve.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ondeferve.api.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
