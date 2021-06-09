package com.premiumshopcarbackend.repositories;

import com.premiumshopcarbackend.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRespository extends JpaRepository<Car, Integer> {

    List<Car> findByNomeContains(String name);
}
