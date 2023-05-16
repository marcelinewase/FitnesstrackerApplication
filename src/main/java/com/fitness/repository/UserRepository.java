package com.fitness.repository;



import com.fitness.model.UserFitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserFitness, Integer> {


    Optional<UserFitness>  findByEmailAndPassword(String email, String password );
    Optional<UserFitness> findFirstByEmail(String email);

}

