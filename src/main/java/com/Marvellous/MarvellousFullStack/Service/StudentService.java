package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.StudentEntry;
import com.Marvellous.MarvellousFullStack.Repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<StudentEntry> getAllStudents() {
        return repository.findAll();
    }

    public Optional<StudentEntry> getStudentById(ObjectId id) {
        return repository.findById(id);
    }

    public StudentEntry saveStudent(StudentEntry student) {
        return repository.save(student);
    }

    public void deleteStudent(ObjectId id) {
        repository.deleteById(id);
    }
}