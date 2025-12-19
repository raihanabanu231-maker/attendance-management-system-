package com.janaeswar.AMS.Service;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> all() { return repo.findAll(); }
    public Employee approve(Long id, boolean approved) {
        Employee e = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        e.setApproved(approved);
        return repo.save(e);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
