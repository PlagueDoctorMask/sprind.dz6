package com.example.sprind.dz6.controller;

import com.example.sprind.dz6.domain.Note;
import com.example.sprind.dz6.service.NoteServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteServices noteServices;


    @GetMapping()
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteServices.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id){
        return new ResponseEntity<>(noteServices.getById(id),HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNewNote(@RequestBody Note note){
        return new ResponseEntity<>(noteServices.createNote(note), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        noteServices.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> editNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(noteServices.editNote(id,note), HttpStatus.I_AM_A_TEAPOT);
    }
}
