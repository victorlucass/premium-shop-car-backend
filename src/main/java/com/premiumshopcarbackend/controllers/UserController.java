package com.premiumshopcarbackend.controllers;

import com.premiumshopcarbackend.DTO.UserDTO;
import com.premiumshopcarbackend.entities.User;
import com.premiumshopcarbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> listAll = service.findAll();
        return ResponseEntity.ok().body(listAll);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User userSelect = service.findById(id);
        return ResponseEntity.ok().body(userSelect);
    }


    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserDTO dto){
        User obj = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid @PathVariable Integer id, @RequestBody UserDTO dto){
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
