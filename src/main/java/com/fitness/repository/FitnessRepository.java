package com.fitness.repository;

import com.fitness.model.Fitness;
import org.springframework.data.repository.CrudRepository;

public interface FitnessRepository extends CrudRepository<Fitness, Integer> {
    public Long countById(Integer id);
}
