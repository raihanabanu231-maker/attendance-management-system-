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
    @Column(nullable = false) private String status = "CHECKED_OUT"; // CHECKED_IN/CHECKED_OUT

    public Long getId() { return id; }
    public Long getEmployeeId() { return employeeId; }
    public LocalDate getDate() { return date; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public String getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }
    public void setStatus(String status) { this.status = status; }
}
