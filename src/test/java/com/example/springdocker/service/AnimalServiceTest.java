package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


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

        List<Animal> actual = animalService.getAnimals();

        assertEquals("1", actual.get(0).getId());
        assertEquals("Lucas", actual.get(0).getName());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();

    }

    @Test
    void saveSuccess(){
        String expectedId = "1";
        String expectedName = "Lucas";

        Animal mockAnimal = new Animal();
        mockAnimal.setId(expectedId);
        mockAnimal.setName(expectedName);

        when(mockRepository.existsAnimalByIdIgnoreCaseAndNameIgnoreCase(anyString(), anyString()))
                .thenReturn(false);


        // -----------------------------------

        Animal actual = animalService.saveNewAnimal(mockAnimal);

        // ----------------------------------

        assertEquals(mockAnimal.getId(), actual.getId());
        assertEquals(mockAnimal.getName(), actual.getName());


    }

    @Test
    void saveNotValid(){
        Animal mockAnimal = new Animal();

        assertThrows(ResponseStatusException.class, () -> animalService.saveNewAnimal(mockAnimal));

        verify(mockRepository, times(0)).save(any());
        verify(mockRepository, times(0)).existsAnimalByIdIgnoreCaseAndNameIgnoreCase(anyString(), anyString());
    }

    @Test
    void saveDuplicate(){
        String expectedId = "1";
        String expectedName = "Lucas";

        Animal mockAnimal = new Animal();
        mockAnimal.setId(expectedId);
        mockAnimal.setName(expectedName);

        when(mockRepository.existsAnimalByIdIgnoreCaseAndNameIgnoreCase(anyString(), anyString()))
            .thenReturn(true);


        assertThrows(ResponseStatusException.class, () -> animalService.saveNewAnimal(mockAnimal));

        verify(mockRepository, times(0)).save(isA(Animal.class));
    }

}