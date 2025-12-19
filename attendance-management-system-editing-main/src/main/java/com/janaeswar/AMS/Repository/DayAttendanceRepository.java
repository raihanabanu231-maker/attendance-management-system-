package com.janaeswar.AMS.Repository;

import com.janaeswar.AMS.Model.DayAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayAttendanceRepository extends JpaRepository<DayAttendance, Long> {
    Optional<DayAttendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
    List<DayAttendance> findByEmployeeIdOrderByDateDesc(Long employeeId);
    List<DayAttendance> findByDepartmentAndDateBetween(String department, LocalDate from, LocalDate to);
}
