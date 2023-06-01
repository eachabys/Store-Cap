package com.example.noteApp.services;

import com.example.noteApp.dtos.NotesDto;
import com.example.noteApp.entities.Notes;
import com.example.noteApp.entities.User;
import com.example.noteApp.repositories.NoteRepository;
import com.example.noteApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServicelmpl implements NoteService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NotesDto> getAllNotesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Notes> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NotesDto(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addNote(NotesDto noteDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Notes note = new Notes(noteDto);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    @Override
    @Transactional
    public void deleteNoteById(Long noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    @Transactional
    public void updateNoteById(NotesDto noteDto) {
        Optional<Notes> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> {
           //note.setBody(noteDto.getBody()); 
           noteRepository.saveAndFlush(note);
        });
    }

    @Override
    public Optional<NotesDto> getNoteById(Long noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        if (noteOptional.isPresent()){
            return Optional.of(new NotesDto(noteOptional.get()));
        }
        return Optional.empty();
    }

    /*@Override
    public List<String> orderDetails(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByOrderid(notesDto.getOrderid());

        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8080/home.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("http://localhost:8080/error.html");
            }
        } else {
            response.add("http://localhost:8080/error.html");
        }
        return response;
    }*/

} 