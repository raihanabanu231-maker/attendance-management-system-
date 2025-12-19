package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")   // ✅ Admin base path
public class AdminController {

    private final EmployeeService service;

    public AdminController(EmployeeService service) {
        this.service = service;
    }

    // Admin view of all employees
    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        return service.all();
    }

    // Admin approves employee
    @PutMapping("/employees/{id}/approve")
    public Employee approveEmployee(@PathVariable Long id) {
        return service.approve(id);
    }

    // Admin deletes employee
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }
}
