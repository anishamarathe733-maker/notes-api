
package com.cognorise.notesapi.controller;

import com.cognorise.notesapi.model.Note;
import com.cognorise.notesapi.service.NoteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@Validated
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Note createNote(@Valid @RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "Note deleted successfully";
    }
}

