package com.pet.repository;

import com.pet.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Generates code for CRUD and custom methods by extending
@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Integer> {

}
