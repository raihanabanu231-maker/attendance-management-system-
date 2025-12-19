package com.janaeswar.AMS.Repository;

import com.janaeswar.AMS.Model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
