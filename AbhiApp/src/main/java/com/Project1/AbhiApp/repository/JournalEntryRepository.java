package com.Project1.AbhiApp.repository;
import com.Project1.AbhiApp.entity.JounralEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JournalEntryRepository extends MongoRepository<JounralEntry, ObjectId> {
    Optional<JounralEntry> findAllById(ObjectId id);
}
