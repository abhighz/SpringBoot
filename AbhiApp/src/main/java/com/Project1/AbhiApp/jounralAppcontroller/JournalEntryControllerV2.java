package com.Project1.AbhiApp.jounralAppcontroller;
import com.Project1.AbhiApp.entity.JounralEntry;
import com.Project1.AbhiApp.repository.JournalEntryRepository;
import com.Project1.AbhiApp.sevice.JounralEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Project1.AbhiApp.*;

import java.time.LocalDateTime;
import java.util.*;

@RequestMapping("/journal")
@RestController
public class JournalEntryControllerV2{

    //It is the object of JounralEntryService ;
    @Autowired
    private JounralEntryService jounralEntryService;


    @GetMapping
    public List<JounralEntry> getAll() {
        return jounralEntryService.getAll();
    }

    //Sending Data into MongoDB
    @PostMapping
    public JounralEntry createEntry(@RequestBody JounralEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        jounralEntryService.saveEntry(myEntry);
        return myEntry;
    }

//Geting Data from Database by ID
    @GetMapping("/id/{id}")
    public JounralEntry getJournalEntryById(@PathVariable ObjectId id) {
        return jounralEntryService.findAllBYId(id).orElse(null);
    }



    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId id) {
        jounralEntryService.deleteById(id);
        return true;
    }



    @PutMapping("/id/{id}")

    public JounralEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JounralEntry newEntry) {
        JounralEntry old = jounralEntryService.findAllBYId(id).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        jounralEntryService.saveEntry(old);
        return old;
    }
}
