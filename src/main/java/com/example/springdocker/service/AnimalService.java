package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.AnimalRepository;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrik Melander
 * Date: 2021-05-11
 * Time: 11:31
 * Project: SoloProject
 * Copyright: MIT
 */
@RequiredArgsConstructor
@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public void saveNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public List<String> getPetableAnimals() {
        // hämtar alla Foods som vi kan laga
        List<Animal> petableAnimals = animalRepository.findAnimalByCanIPetIt(true);

        // returnerar endast Animals namnen i en lista
        return petableAnimals.stream()
                .map(animal -> animal.getName())
                .collect(Collectors.toList());
    }
}
