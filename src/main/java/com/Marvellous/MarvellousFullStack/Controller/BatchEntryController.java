package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.BatchEntry;
import com.Marvellous.MarvellousFullStack.Service.BatchEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/batches")
public class BatchEntryController {

    @Autowired
    private BatchEntryService batchEntryService;

    // Get All Batches
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<BatchEntry> list = batchEntryService.getAll();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Get Batch By ID  <-- NEW API
    @GetMapping("/{id}")
    public ResponseEntity<?> getBatch(@PathVariable ObjectId id) {

        BatchEntry batch = batchEntryService.getBatchById(id);

        if (batch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(batch, HttpStatus.OK);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<?> getBatchById(@PathVariable ObjectId myid)
    {
        BatchEntry batch = batchEntryService.findById(myid).orElse(null);

        if(batch != null)
        {
            return new ResponseEntity<>(batch, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create Batch
    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody BatchEntry batch) {

        batchEntryService.saveEntry(batch);

        return new ResponseEntity<>(batch, HttpStatus.CREATED);
    }

    // Delete Batch
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId id) {

        batchEntryService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update Batch
    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateEntry(
            @PathVariable ObjectId id,
            @RequestBody BatchEntry batch) {

        BatchEntry old = batchEntryService.findById(id).orElse(null);

        if (old == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        old.setName(batch.getName());
        old.setFees(batch.getFees());
        old.setTrainer(batch.getTrainer());
        old.setDuration(batch.getDuration());
        old.setDescription(batch.getDescription());

        batchEntryService.saveEntry(old);

        return new ResponseEntity<>(old, HttpStatus.OK);
    }
}