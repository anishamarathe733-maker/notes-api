
package com.cognorise.notesapi.service;

import com.cognorise.notesapi.model.Note;
import com.cognorise.notesapi.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Get all notes
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Create a new note
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    // Get note by ID
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Note not found"));
    }

    // Update note
    public Note updateNote(Long id, Note updatedNote) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Note not found"));

        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());

        return noteRepository.save(note);
    }

    // Delete note
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Note not found"));

        noteRepository.delete(note);
    }
}
