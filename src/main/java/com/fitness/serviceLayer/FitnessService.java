package com.fitness.serviceLayer;


import java.util.Optional;


import com.fitness.model.Fitness;
import com.fitness.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FitnessService {
    @Autowired
    private FitnessRepository repo;

    public List<Fitness> listAll(){
        return (List<Fitness>) repo.findAll();
    }

    public void save(Fitness fitness) {
        repo.save(fitness);
    }

    public Fitness get(Integer id) throws UserNotFoundExcpetion {
        Optional<Fitness> result = repo.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundExcpetion("Couldn't find the teacher with Id" +id);
    }

    public void  delete( Integer id) throws UserNotFoundExcpetion {
         Long count= repo.countById(id);
         if(count==null || count==0){
             throw new UserNotFoundExcpetion("Couldn't find the teacher with Id" +id);
         }
          repo.deleteById(id);
    }
}

