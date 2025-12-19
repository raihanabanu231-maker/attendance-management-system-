package com.janaeswar.AMS.Service;

import com.janaeswar.AMS.Model.Holiday;
import com.janaeswar.AMS.Repository.HolidayRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HolidayService {
    private final HolidayRepository repo;
    public HolidayService(HolidayRepository repo) { this.repo = repo; }
    public List<Holiday> all() { return repo.findAll(); }
    public Holiday add(Holiday h) { return repo.save(h); }
    public void delete(Long id) { repo.deleteById(id); }
}
