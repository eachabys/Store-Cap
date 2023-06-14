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
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Service
public class NoteServicelmpl implements NoteService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NotesDto> getAllNotesByUserId(Integer userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Notes> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NotesDto(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addNote(NotesDto noteDto, Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Notes note = new Notes(noteDto);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    @Override
    @Transactional
    public void deleteNoteById(Integer noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    @Transactional
    public void updateNoteById(NotesDto noteDto) {
        Optional<Notes> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> { 
           noteRepository.saveAndFlush(note);
        });
    }
    @Override
    public NotesDto getNoteByOrderId(Integer orderId) {
        Notes note = noteRepository.findNotesByOrderid(orderId);
        return new NotesDto(note);
    }

    @Override
    @Transactional
    public void returnOrderById(NotesDto noteDto){
        Optional<Notes> noteOptional = noteRepository.findById(noteDto.getId());
        //if noteOptional is present > then caculate like how many return 5 or 3 should be less than quantity
        //if do calculation
    }


    @Override
    public Optional<NotesDto> getNoteById(Integer noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        if (noteOptional.isPresent()){
            return Optional.of(new NotesDto(noteOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deleteNoteByOrderId(Integer orderId) {
    Notes note = noteRepository.findNotesByOrderid(orderId);
       
    User user = note.getUser(); 
    user.getNotesSet().remove(note);
    System.out.println(user.getName() + " " + user.getNotesSet().contains(note));
    userRepository.save(user);
    noteRepository.delete(note);
    }

    @Override
    @Transactional
    public void updateReturnOrderById(Integer orderId, Integer returnQuantity) {
        Optional<Notes> noteOptional = noteRepository.findByOrderid(orderId);

        noteOptional.ifPresent(note -> {
            int oldQuantity = note.getQuantity();
            //int oldreturnQuantity = note.getQuantity();
            
            Double oldSales = note.getSales();
            double returnamount1=Math.round(oldSales *returnQuantity*100.00/ oldQuantity)/100.00;          
            System.out.println("print "+returnamount1);
            double newSales1 =Math.round((oldSales -returnamount1)*100.00)/100.00;
            System.out.println(newSales1);
            note.setQuantity(oldQuantity - returnQuantity);
            note.setReturnquantity(returnQuantity);
            note.setReturnstatus(returnQuantity > 0 ? 1 : 0);
            note.setSales(newSales1);
            note.setReturnamount(returnamount1);
            noteRepository.saveAndFlush(note);

        });

    }
     
    
    
} 
