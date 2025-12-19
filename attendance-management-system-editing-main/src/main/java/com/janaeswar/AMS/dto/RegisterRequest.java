package com.janaeswar.AMS.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String department;
    private String shift;
    private String gender;
    private String bloodGroup;

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getDepartment() { return department; }
    public String getShift() { return shift; }
    public String getGender() { return gender; }
    public String getBloodGroup() { return bloodGroup; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setDepartment(String department) { this.department = department; }
    public void setShift(String shift) { this.shift = shift; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
}
