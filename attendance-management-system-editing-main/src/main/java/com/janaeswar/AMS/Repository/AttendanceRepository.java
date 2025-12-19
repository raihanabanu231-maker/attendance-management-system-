package com.janaeswar.AMS.Repository;

import com.janaeswar.AMS.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
