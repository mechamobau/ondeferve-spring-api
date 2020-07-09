package br.com.ondeferve.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ondeferve.api.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {


    @Query("select p from Photo p where p.event.id = ?1")
    List<Photo> findByEventId(Long id);
}
