package com.example.springdocker.repository;

import com.example.springdocker.model.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataMongoTest
class AnimalRepositoryTest {

    @Autowired
    AnimalRepository animalRepository;

    @Test
    void findAnimalByCanIPetItTest() {
        String expectedId = "1";
        String expectedName = "Lucas";

        Animal mockAnimal = new Animal();
        mockAnimal.setId(expectedId);
        mockAnimal.setName(expectedName);
        mockAnimal.setCanIPetIt(true);

        animalRepository.save(mockAnimal);

        List<Animal> actual = animalRepository.findAnimalByCanIPetIt(true);

        assertEquals(mockAnimal.getName(), actual.get(0).getName());
    }

    @Test
    void existsAnimalByIdIgnoreCaseAndNameIgnoreCaseTest() {
        String expectedId = "1";
        String expectedName = "Lucas";

        Animal mockAnimal = new Animal();
        mockAnimal.setId(expectedId);
        mockAnimal.setName(expectedName);

        String UpperCaseExpectedId = expectedId.toUpperCase();
        String UpperCaseExpectedName = expectedName.toUpperCase();

        boolean expected = expectedId.equalsIgnoreCase(UpperCaseExpectedId) && expectedName.equalsIgnoreCase(UpperCaseExpectedName);

        boolean actual = animalRepository.existsAnimalByIdIgnoreCaseAndNameIgnoreCase(expectedId, expectedName);

        assertEquals(expected, actual);

    }
}