package com.example.noteApp.repositories;

import com.example.noteApp.entities.Notes;
import com.example.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface NoteRepository extends JpaRepository<Notes, Integer> {
    List<Notes> findAllByUserEquals(User user);
    Notes findNotesByOrderid(Integer orderid);
    Optional<Notes> findByOrderid(Integer orderid);

}
