package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Service.AuthService;
import com.janaeswar.AMS.dto.LoginRequest;
import com.janaeswar.AMS.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public Employee register(@RequestBody RegisterRequest req) {
        Employee e = new Employee();
        e.setName(req.getName());
        e.setEmail(req.getEmail());
        e.setPassword(req.getPassword());
        return authService.register(e);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest req) {
        Optional<Employee> emp = authService.login(req.getEmail(), req.getPassword());
        if (emp.isPresent()) {
            Employee e = emp.get();
            return Map.of("success", true, "employeeId", e.getId(), "name", e.getName(),
                    "role", e.getRole(), "approved", e.isApproved());
        }
        return Map.of("success", false, "message", "Invalid credentials or not approved");
    }
}
