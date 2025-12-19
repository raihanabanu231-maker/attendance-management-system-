package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Holiday;
import com.janaeswar.AMS.Service.HolidayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin
public class HolidayController {
    private final HolidayService service;
    public HolidayController(HolidayService service) { this.service = service; }

    @GetMapping
    public List<Holiday> all() { return service.all(); }

    @PostMapping
    public Holiday add(@RequestBody Holiday h) { return service.add(h); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
