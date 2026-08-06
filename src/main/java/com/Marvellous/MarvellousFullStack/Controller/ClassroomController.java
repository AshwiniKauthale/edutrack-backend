package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.ClassroomEntry;
import com.Marvellous.MarvellousFullStack.Service.ClassroomService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://edutrack-frontend-topaz.vercel.app"
})
public class ClassroomController {

    @Autowired
    private ClassroomService service;

    @GetMapping
    public ResponseEntity<?> getAllClassrooms() {
        return ResponseEntity.ok(service.getAllClassrooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassroom(@PathVariable ObjectId id) {

        return service.getClassroomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addClassroom(@RequestBody ClassroomEntry classroom) {

        return new ResponseEntity<>(
                service.saveClassroom(classroom),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClassroom(
            @PathVariable ObjectId id,
            @RequestBody ClassroomEntry classroom) {

        return service.getClassroomById(id)
                .map(old -> {

                    old.setRoomNumber(classroom.getRoomNumber());
                    old.setBuilding(classroom.getBuilding());
                    old.setCapacity(classroom.getCapacity());
                    old.setBatchName(classroom.getBatchName());
                    old.setTeacherName(classroom.getTeacherName());

                    service.saveClassroom(old);

                    return ResponseEntity.ok(old);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassroom(@PathVariable ObjectId id) {

        service.deleteClassroom(id);

        return ResponseEntity.noContent().build();
    }
}