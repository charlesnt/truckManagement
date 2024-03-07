package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")

public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;
  @Column(name = "price")
  private double price;

  @Column(name = "quantity")
  private double quantity;

  public Product(){

  }
  public Product( String name, double price, double quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }
}
