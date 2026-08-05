package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.ClassroomEntry;
import com.Marvellous.MarvellousFullStack.Repository.ClassroomRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository repository;

    public List<ClassroomEntry> getAllClassrooms() {
        return repository.findAll();
    }

    public Optional<ClassroomEntry> getClassroomById(ObjectId id) {
        return repository.findById(id);
    }

    public ClassroomEntry saveClassroom(ClassroomEntry classroom) {
        return repository.save(classroom);
    }

    public void deleteClassroom(ObjectId id) {
        repository.deleteById(id);
    }
}