package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.Truck;
import com.example.demo.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TruckController {


  @Autowired
  private TruckRepository truckRepository;


@GetMapping("/trucks")
public List<Truck> getTrucks(){
  return truckRepository.findAll();
}

  @PostMapping("/truck")
  public ResponseEntity<Object> addTruck(@RequestBody Truck truck){

    Truck newTruck = new Truck();
    newTruck.setModel(truck.getModel());
    newTruck.setManfuctureryear(truck.getManfuctureryear());
   // newTruck.setDriver(truck.getDriver());
    newTruck.setOwner(truck.getOwner());
    Truck savetruck=truckRepository.save(newTruck);
      if (truckRepository.findById(savetruck.getId()).isPresent()) {
        return ResponseEntity.accepted().body("Successfully Created Truck,driver and owner");
      } else
      return ResponseEntity.unprocessableEntity().body("Failed to Create specified Truck");
    }


}
