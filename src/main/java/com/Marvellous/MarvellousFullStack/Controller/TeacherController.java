package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.TeacherEntry;
import com.Marvellous.MarvellousFullStack.Service.TeacherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://edutrack-frontend-topaz.vercel.app"
})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherEntry>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable ObjectId id) {

        return teacherService.getTeacherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TeacherEntry> addTeacher(
            @RequestBody TeacherEntry teacher) {

        return new ResponseEntity<>(
                teacherService.saveTeacher(teacher),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(
            @PathVariable ObjectId id,
            @RequestBody TeacherEntry teacher) {

        return teacherService.getTeacherById(id)
                .map(oldTeacher -> {

                    oldTeacher.setName(teacher.getName());
                    oldTeacher.setEmail(teacher.getEmail());
                    oldTeacher.setMobile(teacher.getMobile());
                    oldTeacher.setQualification(teacher.getQualification());
                    oldTeacher.setSubject(teacher.getSubject());

                    teacherService.saveTeacher(oldTeacher);

                    return ResponseEntity.ok(oldTeacher);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable ObjectId id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.noContent().build();
    }
}