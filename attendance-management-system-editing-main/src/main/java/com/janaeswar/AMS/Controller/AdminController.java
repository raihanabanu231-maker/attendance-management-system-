package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    private final EmployeeService employeeService;
    public AdminController(EmployeeService employeeService) { this.employeeService = employeeService; }

    @GetMapping("/employees")
    public List<Employee> listEmployees() { return employeeService.all(); }

    @PostMapping("/approve/{id}")
    public Map<String, Object> approve(@PathVariable Long id, @RequestParam boolean approved) {
        Employee e = employeeService.approve(id, approved);
        return Map.of("success", true, "employeeId", e.getId(), "approved", e.isApproved());
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return Map.of("success", true, "message", "Employee deleted");
    }
}
