package com.Marvellous.MarvellousFullStack.Controller;

import com.Marvellous.MarvellousFullStack.Entity.AttendanceEntry;
import com.Marvellous.MarvellousFullStack.Service.AttendanceService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // ================= GET ALL =================

    @GetMapping
    public ResponseEntity<List<AttendanceEntry>> getAllAttendance() {

        List<AttendanceEntry> attendance =
                attendanceService.getAllAttendance();

        return ResponseEntity.ok(attendance);
    }

    // ================= GET BY ID =================

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendance(
            @PathVariable ObjectId id) {

        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ================= ADD =================

    @PostMapping
    public ResponseEntity<AttendanceEntry> addAttendance(
            @RequestBody AttendanceEntry attendance) {

        AttendanceEntry saved =
                attendanceService.saveAttendance(attendance);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ================= UPDATE =================

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendance(
            @PathVariable ObjectId id,
            @RequestBody AttendanceEntry attendance) {

        return attendanceService.getAttendanceById(id)
                .map(oldAttendance -> {

                    oldAttendance.setStudentName(attendance.getStudentName());
                    oldAttendance.setBatchName(attendance.getBatchName());
                    oldAttendance.setDate(attendance.getDate());
                    oldAttendance.setStatus(attendance.getStatus());

                    attendanceService.saveAttendance(oldAttendance);

                    return ResponseEntity.ok(oldAttendance);

                }).orElse(ResponseEntity.notFound().build());
    }

    // ================= DELETE =================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendance(
            @PathVariable ObjectId id) {

        attendanceService.deleteAttendance(id);

        return ResponseEntity.noContent().build();
    }
}