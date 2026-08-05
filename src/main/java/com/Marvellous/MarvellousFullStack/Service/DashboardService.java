package com.Marvellous.MarvellousFullStack.Service;

import com.Marvellous.MarvellousFullStack.DTO.DashboardChartDTO;
import com.Marvellous.MarvellousFullStack.DTO.DashboardStats;
import com.Marvellous.MarvellousFullStack.Repository.*;
import com.Marvellous.MarvellousFullStack.Repository.BatchEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private BatchEntryRepository batchRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public DashboardStats getDashboardStats() {

        DashboardStats stats = new DashboardStats();

        stats.setStudents(studentRepository.count());

        stats.setTeachers(teacherRepository.count());

        stats.setBatches(batchRepository.count());

        stats.setClassrooms(classroomRepository.count());

        stats.setAttendance(attendanceRepository.count());

        stats.setAssignments(assignmentRepository.count());

        return stats;
    }

    public DashboardChartDTO getChartData() {

        DashboardChartDTO chart = new DashboardChartDTO();

        chart.setStudents(studentRepository.count());

        chart.setTeachers(teacherRepository.count());

        chart.setBatches(batchRepository.count());

        chart.setClassrooms(classroomRepository.count());

        chart.setAttendance(attendanceRepository.count());

        chart.setAssignments(assignmentRepository.count());

        return chart;
    }
}