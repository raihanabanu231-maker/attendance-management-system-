package com.janaeswar.AMS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company = "VDart Technologies";
    private String location = "Trichy";

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false) private String name;
    @Column(nullable = false) private String password; // demo only; hash in prod
    @Column(nullable = false) private String role = "EMPLOYEE"; // ADMIN, EMPLOYEE
    @Column(nullable = false) private boolean approved = false;

    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public boolean isApproved() { return approved; }
    public void setId(Long id) { this.id = id; }
    public void setCompany(String company) { this.company = company; }
    public void setLocation(String location) { this.location = location; }
    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
