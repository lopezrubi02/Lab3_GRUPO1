package com.example.laboratorio3.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private int departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "manager_id")
    private int managerId;

    //@Column(name = "location_id")
    //private int locationId;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Locations locations;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }
}
