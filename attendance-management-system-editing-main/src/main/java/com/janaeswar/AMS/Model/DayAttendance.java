package com.janaeswar.AMS.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "day_attendance")
public class DayAttendance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private Long employeeId;
    @Column(nullable = false) private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    @Column(nullable = false) private String status = "CHECKED_OUT"; // CHECKED_IN | CHECKED_OUT
    private String shift;
    private String department;

    public Long getId() { return id; }
    public Long getEmployeeId() { return employeeId; }
    public LocalDate getDate() { return date; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public String getStatus() { return status; }
    public String getShift() { return shift; }
    public String getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }
    public void setStatus(String status) { this.status = status; }
    public void setShift(String shift) { this.shift = shift; }
    public void setDepartment(String department) { this.department = department; }
}
