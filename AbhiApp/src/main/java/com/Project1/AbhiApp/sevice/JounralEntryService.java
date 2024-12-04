package com.Project1.AbhiApp.sevice;
import com.Project1.AbhiApp.entity.JounralEntry;
import com.Project1.AbhiApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JounralEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JounralEntry jounralEntry) {
        journalEntryRepository.save(jounralEntry);
    }
    public List<JounralEntry> getAll(){
        return journalEntryRepository.findAll();

    }

    public Optional<JounralEntry> findAllBYId(ObjectId id){
        return journalEntryRepository.findAllById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
