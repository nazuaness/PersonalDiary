package com.diary.web.Repository;

import com.diary.web.Entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Notes, Long> {
    Notes findByNoteName(String noteName);
}
