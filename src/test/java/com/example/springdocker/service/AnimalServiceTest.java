package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patrik Melander
 * Date: 2021-05-14
 * Time: 10:39
 * Project: SoloProject
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    AnimalService animalService;

    @Mock
    AnimalRepository mockRepository;

    @BeforeEach
    public void init(){
        animalService = new AnimalService(mockRepository);
    }

    @Test
    public void getAll(){
        animalService.getAnimals();
    }

    @Test
    void save(){
        //Animal a = new Animal();
        //animalService.saveNewAnimal(a);
    }
}