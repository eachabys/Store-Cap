package com.example.noteApp.services;

import com.example.noteApp.dtos.NotesDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NotesDto> getAllNotesByUserId(Integer userId);
    @Transactional
    void addNote(NotesDto noteDto, Integer userId);

    @Transactional
    void deleteNoteById(Integer noteId);

    @Transactional
    void updateNoteById(NotesDto noteDto);
    
    @Transactional
    void returnOrderById(NotesDto noteDto);

    Optional<NotesDto> getNoteById(Integer noteId);
    NotesDto getNoteByOrderId(Integer orderId);

    @Transactional
    void deleteNoteByOrderId(Integer orderId);
}
