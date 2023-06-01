package com.example.noteApp.services;

import com.example.noteApp.dtos.NotesDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NotesDto> getAllNotesByUserId(Long userId);
    @Transactional
    void addNote(NotesDto noteDto, Long userId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NotesDto noteDto);

    Optional<NotesDto> getNoteById(Long noteId);
}
