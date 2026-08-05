package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.AssignmentEntry;
import com.Marvellous.MarvellousFullStack.Repository.AssignmentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repository;

    public List<AssignmentEntry> getAllAssignments() {
        return repository.findAll();
    }

    public Optional<AssignmentEntry> getAssignmentById(ObjectId id) {
        return repository.findById(id);
    }

    public AssignmentEntry saveAssignment(AssignmentEntry assignment) {
        return repository.save(assignment);
    }

    public void deleteAssignment(ObjectId id) {
        repository.deleteById(id);
    }
}