package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Owner;
import com.example.demo.entity.Truck;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {

  @Autowired
  private OwnerRepository ownerRepository;

  @Autowired
  private TruckRepository truckRepository;


  @GetMapping("/owners")
  public List<Owner> findOwners(){

      return  ownerRepository.findAll();
  }


  @PostMapping("/owner")
  public ResponseEntity<Object> addOwner(@RequestBody Owner owner){

    System.out.println("Owner save called...");

    // a new Owner
    Owner ownerIn = new Owner(owner.getName());

    // list of trucks
    List<Truck> blogs = new ArrayList<>();
    for (Truck truckIn : owner.getTrucks()) {
      // new Blog
      Truck truck = new Truck(truckIn.getModel(), truckIn.getManfuctureryear());
      // set owner to truck
      truck.setOwner(ownerIn);
      // add blog to list
      blogs.add(truck);
    }

    List<Driver> drivers = new ArrayList<>();
    for (Driver driverIn : owner.getDrivers()) {
      // new Blog
      Driver driver = new Driver(driverIn.getName());
      // set owner to truck
      driver.setOwner(ownerIn);
      // add blog to list
      drivers.add(driver);
    }

    // add blog list to Owner
    ownerIn.setTrucks(blogs);
    ownerIn.setDrivers(drivers);

    // save Owner
    Owner ownerOut = ownerRepository.save(ownerIn);
    System.out.println("Owner out :: " + ownerOut);

    System.out.println("Saved!!!");
    return ResponseEntity.accepted().body("Successfully Created Truck,driver and owner");

//  Owner newOwner = new Owner();
//  newOwner.setName(newOwner.getName());

//  List<Driver> driverList=new ArrayList<>();
//  List<Truck> truckList=new ArrayList<>();


//    for(Driver dr:owner.getDrivers()){
//      Driver newDriver= new Driver(owner.getName());
//      newDriver.setOwner(dr.getOwner());
//      driverList.add(newDriver);
//    }
//    newOwner.setDrivers(driverList);


//    for(Truck tr: owner.getTrucks()){
//      Truck newTruck= new Truck(tr.getModel(), tr.getManfuctureryear());
//      newTruck.setOwner(tr.getOwner());
//      truckList.add(newTruck);
//    }
//    newOwner.setTrucks(truckList);
//
//    Owner saveOwner = ownerRepository.save(newOwner);
//    if (ownerRepository.findById(saveOwner.getId()).isPresent()) {
//      return ResponseEntity.accepted().body("Successfully Created Truck,driver and owner");
//    } else
//      return ResponseEntity.unprocessableEntity().body("Failed to Create specified Truck");
  }
}
