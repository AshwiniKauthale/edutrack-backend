package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.BatchEntry;
import com.Marvellous.MarvellousFullStack.Repository.BatchEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchEntryService {

    @Autowired
    private BatchEntryRepository batchEntryRepository;

    public void saveEntry(BatchEntry batchEntry) {
        batchEntryRepository.save(batchEntry);
    }

    public List<BatchEntry> getAll() {
        return batchEntryRepository.findAll();
    }

    public Optional<BatchEntry> findById(ObjectId id) {
        return batchEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        batchEntryRepository.deleteById(id);
    }

    // NEW METHOD
    public BatchEntry getBatchById(ObjectId id) {
        return batchEntryRepository.findById(id).orElse(null);
    }
}