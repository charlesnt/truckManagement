package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;
  @Column(name = "name")
  private String name;
  @OneToMany(fetch = FetchType.LAZY , mappedBy = "owner", cascade = CascadeType.ALL)
  private List<Driver> drivers;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
  private List<Truck> trucks;


  public Owner() { }

  public Owner(String name) {
    this.name = name;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Driver> getDrivers() {
    return drivers;
  }

  public void setDrivers(List<Driver> drivers) {
    this.drivers = drivers;
  }

  public List<Truck> getTrucks() {
    return trucks;
  }

  public void setTrucks(List<Truck> trucks) {
    this.trucks = trucks;
  }
}
