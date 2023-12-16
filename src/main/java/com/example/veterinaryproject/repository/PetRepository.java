package com.example.veterinaryproject.repository;

import com.example.veterinaryproject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
