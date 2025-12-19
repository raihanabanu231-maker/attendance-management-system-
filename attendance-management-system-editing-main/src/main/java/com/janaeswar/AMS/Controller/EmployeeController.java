package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")   // ✅ Different base path
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Employees can view all employees
    @GetMapping
    public List<Employee> all() {
        return service.all();
    }

    // Employees can delete their own record (different path)
    @DeleteMapping("/self/{id}")   // ✅ avoids conflict with AdminController
    public void deleteSelf(@PathVariable Long id) {
        service.delete(id);
    }
}
