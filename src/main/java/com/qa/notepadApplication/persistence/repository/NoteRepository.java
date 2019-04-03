package com.qa.notepadApplication.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.notepadApplication.persistence.domain.Note;

public interface NoteRepository extends  JpaRepository<Note, Long> {

}