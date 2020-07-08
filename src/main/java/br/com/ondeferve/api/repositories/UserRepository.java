package br.com.ondeferve.api.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ondeferve.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select count(u) > 0 from User u where u.username = ?1")
    boolean existsByUsername(String username);

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Transactional
    @Query("delete from User u where u.username = ?1")
    void deleteByUsername(String username);

}