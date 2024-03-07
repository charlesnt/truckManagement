package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
 /* @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "truck_id")
  private Truck truck;*/
 @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "owner_id")
  private Owner owner;


  public Driver(){}
  public Driver(String name) {
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

/*  public Truck getTruck() {
    return truck;
  }

  public void setTruck(Truck truck) {
    this.truck = truck;
  }*/

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
