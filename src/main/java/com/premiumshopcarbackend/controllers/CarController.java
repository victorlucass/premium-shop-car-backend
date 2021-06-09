package com.premiumshopcarbackend.controllers;

import com.premiumshopcarbackend.DTO.CarDTO;
import com.premiumshopcarbackend.entities.Car;
import com.premiumshopcarbackend.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarServices service;

    @GetMapping()
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = service.findAll();
        return ResponseEntity.ok().body(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Integer id) {
        Car carSelect = service.findById(id);
        return ResponseEntity.ok().body(carSelect);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Car>> getPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
    ){
        Page<Car> list = service.findByPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Car>> getFilterName(@RequestParam("name") String name ){
        List<Car> listFilter = service.findByName(name);
        return ResponseEntity.ok().body(listFilter);
    }

    @PostMapping()
    public ResponseEntity<Car> save(@Valid @RequestBody CarDTO dto) {
        Car car = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(car.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@Valid @PathVariable Integer id, @RequestBody CarDTO dto) {
        dto.setId(id);
        service.update(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
