package com.janaeswar.AMS.Service;

import com.janaeswar.AMS.Model.DayAttendance;
import com.janaeswar.AMS.Repository.DayAttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {
    private final DayAttendanceRepository repo;

    public AttendanceService(DayAttendanceRepository repo) { this.repo = repo; }

    public DayAttendance checkIn(Long employeeId) {
        LocalDate today = LocalDate.now();
        DayAttendance a = repo.findByEmployeeIdAndDate(employeeId, today).orElseGet(() -> {
            DayAttendance na = new DayAttendance();
            na.setEmployeeId(employeeId);
            na.setDate(today);
            return na;
        });
        if ("CHECKED_IN".equals(a.getStatus())) {
            throw new RuntimeException("Already checked in for today");
        }
        a.setCheckInTime(LocalDateTime.now());
        a.setStatus("CHECKED_IN");
        return repo.save(a);
    }

    public DayAttendance checkOut(Long employeeId) {
        LocalDate today = LocalDate.now();
        DayAttendance a = repo.findByEmployeeIdAndDate(employeeId, today)
                .orElseThrow(() -> new RuntimeException("No check-in found for today"));
        if (!"CHECKED_IN".equals(a.getStatus())) {
            throw new RuntimeException("Already checked out");
        }
        a.setCheckOutTime(LocalDateTime.now());
        a.setStatus("CHECKED_OUT");
        return repo.save(a);
    }

    public List<DayAttendance> history(Long employeeId) {
        return repo.findByEmployeeIdOrderByDateDesc(employeeId);
    }

    public List<DayAttendance> all() { return repo.findAll(); }
}
