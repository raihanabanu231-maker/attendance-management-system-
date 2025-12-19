package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.DayAttendance;
import com.janaeswar.AMS.Service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {
    private final AttendanceService service;
    public AttendanceController(AttendanceService service) { this.service = service; }

    @PostMapping("/checkin")
    public Map<String, Object> checkIn(@RequestBody Map<String, Object> body) {
        Long employeeId = Long.valueOf(body.get("employeeId").toString());
        String department = (String) body.getOrDefault("department", "General");
        String shift = (String) body.getOrDefault("shift", "Morning");
        DayAttendance a = service.checkIn(employeeId, department, shift);
        return Map.of("success", true, "attendanceId", a.getId(), "status", a.getStatus(),
                "checkInTime", a.getCheckInTime(), "date", a.getDate());
    }

    @PostMapping("/checkout/{employeeId}")
    public Map<String, Object> checkOut(@PathVariable Long employeeId) {
        DayAttendance a = service.checkOut(employeeId);
        return Map.of("success", true, "attendanceId", a.getId(), "status", a.getStatus(),
                "checkOutTime", a.getCheckOutTime(), "date", a.getDate());
    }

    @GetMapping("/employee/{employeeId}")
    public List<DayAttendance> history(@PathVariable Long employeeId) { return service.history(employeeId); }

    @GetMapping("/department")
    public List<DayAttendance> departmentRange(@RequestParam String department,
                                               @RequestParam String from,
                                               @RequestParam String to) {
        return service.departmentRange(department, LocalDate.parse(from), LocalDate.parse(to));
    }

    @GetMapping
    public List<DayAttendance> all() { return service.all(); }
}
