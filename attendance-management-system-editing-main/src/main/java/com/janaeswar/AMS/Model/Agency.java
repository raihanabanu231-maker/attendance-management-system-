package com.janaeswar.AMS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
}
