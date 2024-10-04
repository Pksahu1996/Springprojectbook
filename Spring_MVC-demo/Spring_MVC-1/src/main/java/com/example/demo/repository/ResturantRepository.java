package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Resturant;

public interface ResturantRepository extends JpaRepository<Resturant, Long> {
}
