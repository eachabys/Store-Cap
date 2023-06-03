package com.example.noteApp.controllers;

import com.example.noteApp.dtos.NotesDto;
import com.example.noteApp.services.NoteService;
import com.example.noteApp.services.NoteServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/orders")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/user/{userId}")
    public List<NotesDto> getNotesByUser(@PathVariable Integer userId){
        return noteService.getAllNotesByUserId(userId);
    }

    @GetMapping("/{noteId}")
    public Optional<NotesDto> getNoteById(@PathVariable Integer noteId){
        return noteService.getNoteById(noteId);
    }

    @PostMapping("/note/{userId}")
    public void addNote(@RequestBody NotesDto noteDto,@PathVariable Integer userId){
        noteService.addNote(noteDto, userId);
    }

    @DeleteMapping("/note/{noteId}")
    public void deleteNoteById(@PathVariable Integer noteId){
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNote(@RequestBody NotesDto noteDto){
        noteService.updateNoteById(noteDto);
    }
    @PutMapping("/return")
    public void returnOrder(@RequestBody NotesDto noteDto){
        noteService.returnOrderById(noteDto);
        //need to create a noteService layer method handing calcualtion
     }

    
}
