package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.StudentEntry;
import com.Marvellous.MarvellousFullStack.Service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    // ================= GET ALL =================

    @GetMapping
    public ResponseEntity<List<StudentEntry>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    // ================= GET BY ID =================

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(
            @PathVariable ObjectId id) {

        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ================= ADD =================

    @PostMapping
    public ResponseEntity<StudentEntry> addStudent(
            @RequestBody StudentEntry student) {

        StudentEntry saved =
                studentService.saveStudent(student);

        return new ResponseEntity<>(
                saved,
                HttpStatus.CREATED);
    }

    // ================= UPDATE =================

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable ObjectId id,
            @RequestBody StudentEntry student) {

        return studentService.getStudentById(id)
                .map(oldStudent -> {

                    oldStudent.setName(student.getName());
                    oldStudent.setEmail(student.getEmail());
                    oldStudent.setMobile(student.getMobile());
                    oldStudent.setCourse(student.getCourse());
                    oldStudent.setBatch(student.getBatch());
                    oldStudent.setAddress(student.getAddress());

                    studentService.saveStudent(oldStudent);

                    return ResponseEntity.ok(oldStudent);

                }).orElse(ResponseEntity.notFound().build());
    }

    // ================= DELETE =================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable ObjectId id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}