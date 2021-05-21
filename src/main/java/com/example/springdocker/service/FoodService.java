package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository repository;

    public List<Food> getFoods() {
        return repository.findAll();
    }

    public Food saveNewFood(Food food) {
        validateFood(food);
        return repository.save(food);
    }

    public List<String> getCookableFoods() {
        // hämtar alla Foods som vi kan laga
        List<Food> cookableFoods = repository.findFoodByCanICookIt(true);

        // returnerar endast Food namnen i en lista
        return cookableFoods.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());
    }

    private void validateFood(Food food){
        if (food.getName() == null || food.getName().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing food name");
        }
    }
}
