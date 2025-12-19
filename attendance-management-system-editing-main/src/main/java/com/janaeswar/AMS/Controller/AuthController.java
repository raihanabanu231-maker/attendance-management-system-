package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Employee register(@RequestBody Employee e) {
        return authService.register(e);
    }

    @GetMapping("/login")
    public Optional<Employee> login(@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }
}
