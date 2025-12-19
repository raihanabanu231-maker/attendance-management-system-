package com.janaeswar.AMS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;

    public Long getId() { return id; }
    public String getCity() { return city; }
    public String getAddress() { return address; }
    public void setId(Long id) { this.id = id; }
    public void setCity(String city) { this.city = city; }
    public void setAddress(String address) { this.address = address; }
}
