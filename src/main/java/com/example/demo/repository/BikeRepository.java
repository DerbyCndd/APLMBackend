package com.example.demo.repository;

import com.example.demo.domain.bike.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike,String> {
}
