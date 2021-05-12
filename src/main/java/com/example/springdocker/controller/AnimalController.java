package com.example.springdocker.controller;

import com.example.springdocker.model.Animal;
import com.example.springdocker.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }
    @PostMapping("/animals")
    public void saveNewAnimal(@RequestBody Animal animal) {
        animalService.saveNewAnimal(animal);
    }

    @GetMapping("/animals/petable")
    public List<String> getPetableAnimals() {
        return animalService.getPetableAnimals();
    }
}
