package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveNewAnimal(Animal animal) {
        return animalRepository.save(animal);
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
