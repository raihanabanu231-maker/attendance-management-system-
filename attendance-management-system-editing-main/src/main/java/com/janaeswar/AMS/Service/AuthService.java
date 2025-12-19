package com.janaeswar.AMS.Service;

import com.janaeswar.AMS.Model.Employee;
import com.janaeswar.AMS.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final EmployeeRepository employees;

    public AuthService(EmployeeRepository employees) {
        this.employees = employees;
    }

    public Employee register(Employee e) {
        e.setRole("EMPLOYEE");
        e.setApproved(false);
        return employees.save(e);
    }

    public Optional<Employee> login(String email, String password) {
        return employees.findByEmail(email)
                .filter(e -> e.getPassword().equals(password))
                .filter(Employee::isApproved);
    }
}
