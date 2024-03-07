package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {
  @Autowired
  private DriverRepository driverRepository;


  @GetMapping("/drivers")
  public List<Driver> getDrivers(){
    return driverRepository.findAll();
  }
}
