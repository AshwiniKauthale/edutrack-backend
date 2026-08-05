package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.TeacherEntry;
import com.Marvellous.MarvellousFullStack.Repository.TeacherRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherEntry> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<TeacherEntry> getTeacherById(ObjectId id) {
        return teacherRepository.findById(id);
    }

    public TeacherEntry saveTeacher(TeacherEntry teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(ObjectId id) {
        teacherRepository.deleteById(id);
    }
}