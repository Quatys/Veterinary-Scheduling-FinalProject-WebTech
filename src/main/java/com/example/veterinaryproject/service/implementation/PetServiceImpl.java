package com.example.veterinaryproject.service.implementation;

import com.example.veterinaryproject.model.Pet;
import com.example.veterinaryproject.repository.PetRepository;
import com.example.veterinaryproject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        return optionalPet.orElse(null);
    }

    @Override
    public Pet savePet(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
