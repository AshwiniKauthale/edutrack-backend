package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.AssignmentEntry;
import com.Marvellous.MarvellousFullStack.Service.AssignmentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<AssignmentEntry>> getAllAssignments() {

        return ResponseEntity.ok(
                assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAssignment(
            @PathVariable ObjectId id) {

        return assignmentService.getAssignmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AssignmentEntry> addAssignment(
            @RequestBody AssignmentEntry assignment) {

        return new ResponseEntity<>(
                assignmentService.saveAssignment(assignment),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAssignment(
            @PathVariable ObjectId id,
            @RequestBody AssignmentEntry assignment) {

        return assignmentService.getAssignmentById(id)
                .map(oldAssignment -> {

                    oldAssignment.setTitle(assignment.getTitle());
                    oldAssignment.setBatchName(assignment.getBatchName());
                    oldAssignment.setDueDate(assignment.getDueDate());
                    oldAssignment.setDescription(assignment.getDescription());
                    oldAssignment.setStatus(assignment.getStatus());

                    assignmentService.saveAssignment(oldAssignment);

                    return ResponseEntity.ok(oldAssignment);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssignment(
            @PathVariable ObjectId id) {

        assignmentService.deleteAssignment(id);

        return ResponseEntity.noContent().build();
    }
}