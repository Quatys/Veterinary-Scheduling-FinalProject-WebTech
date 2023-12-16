package com.example.veterinaryproject.service;

import com.example.veterinaryproject.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(Long id);
    Pet savePet(Pet pet);
    void deletePet(Long id);
}
