package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        validateAnimal(animal);



        boolean found = animalRepository.existsAnimalByIdIgnoreCaseAndNameIgnoreCase(animal.getId(), animal.getName());
        if (found) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Animal already exists.");
        }

        animalRepository.save(animal);
        return animal;
    }

    public List<String> getPetableAnimals() {
        // hämtar alla Foods som vi kan laga
        List<Animal> petableAnimals = animalRepository.findAnimalByCanIPetIt(true);

        // returnerar endast Animals namnen i en lista
        return petableAnimals.stream()
                .map(animal -> animal.getName())
                .collect(Collectors.toList());
    }

    private void validateAnimal(Animal animal) {
        if (animal.getId() == null || animal.getName() == null || animal.getId().isEmpty() || animal.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Both Id and Name must exist.");
        }
    }
}
