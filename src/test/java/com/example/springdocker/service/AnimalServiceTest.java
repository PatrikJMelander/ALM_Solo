package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        Animal mockAnimal = new Animal();
        mockAnimal.setId("1");
        mockAnimal.setName("Lucas");
        mockAnimal.setGorgeous(true);
        mockAnimal.setCanIPetIt(true);

        when(mockRepository.findAll()).thenReturn(Arrays.asList(mockAnimal));

        //mockRepository.save(mockAnimal);

        List<Animal> actual = animalService.getAnimals();

        assertEquals("1", actual.get(0).getId());
        assertEquals("Lucas", actual.get(0).getName());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();

    }

    @Test
    void save(){
        //Animal a = new Animal();
        //animalService.saveNewAnimal(a);
    }
}