package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
    private final EmployeeRepository repo;
    public EmployeeController(EmployeeRepository repo) { this.repo = repo; }

    @GetMapping("/{id}")
    public Optional<Employee> get(@PathVariable Long id) { return repo.findById(id); }

    @GetMapping("/email/{email}")
    public Optional<Employee> getByEmail(@PathVariable String email) { return repo.findByEmail(email); }
}
