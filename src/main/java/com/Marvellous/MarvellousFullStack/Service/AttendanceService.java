package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.Entity.AttendanceEntry;
import com.Marvellous.MarvellousFullStack.Repository.AttendanceRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Save Attendance
    public AttendanceEntry saveAttendance(AttendanceEntry attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get All Attendance
    public List<AttendanceEntry> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get Attendance By ID
    public Optional<AttendanceEntry> getAttendanceById(ObjectId id) {
        return attendanceRepository.findById(id);
    }

    // Delete Attendance
    public void deleteAttendance(ObjectId id) {
        attendanceRepository.deleteById(id);
    }
}