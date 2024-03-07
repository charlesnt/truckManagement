package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "truck")
public class Truck {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "model")
  private String model;
  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "owner_id")
  private Owner owner;
//  @OneToOne(cascade = CascadeType.ALL,mappedBy = "truck")
//  private Driver driver;
  @Column(name = "manyear")
  private String manfuctureryear;

  public Truck( String model, String manfuctureryear) {

    this.model = model;
    this.manfuctureryear = manfuctureryear;
  }

  public Truck() {

  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

//  public Driver getDriver() {
//    return driver;
//  }
//
//  public void setDriver(Driver driver) {
//    this.driver = driver;
//  }

  public String getManfuctureryear() {
    return manfuctureryear;
  }

  public void setManfuctureryear(String manfuctureryear) {
    this.manfuctureryear = manfuctureryear;
  }

  public Long getId() {
    return id;
  }
}
