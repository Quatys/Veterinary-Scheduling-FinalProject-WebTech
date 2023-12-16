package com.example.veterinaryproject.controller;

import com.example.veterinaryproject.model.Pet;
import com.example.veterinaryproject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // home page with a list of pets
    @GetMapping
    public String home(Model model) {
        List<Pet> allPets = petService.getAllPets();
        model.addAttribute("allPets", allPets);
        return "Pet/pets";
    }

    // create page: where we save a new pet
    @GetMapping("/new_pet")
    public String newPetForm(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "Pet/pets";
    }

    // create pet
    @PostMapping("/new_pet")
    public String newPet(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet); // save pet
        return "redirect:/dashboard";
    }

    // update page: where we update pet info
    @GetMapping("/{petId}/edit_pet")
    public String updatePetForm(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        return "Pet/edit-pet";
    }

    // update pet
    @PostMapping("/{petId}/edit_pet")
    public String editPet(@PathVariable("petId") Long petId, @ModelAttribute("pet") Pet pet) {
        pet.setId(petId);
        petService.savePet(pet);
        return "redirect:/Pet/pets";
    }

    // delete pet
    @GetMapping("/{petId}/delete_pet")
    public String removePet(@PathVariable("petId") Long petId) {
        petService.deletePet(petId);
        return "redirect:/Pet/pets";
    }


}
