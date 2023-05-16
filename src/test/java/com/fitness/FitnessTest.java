package com.fitness;

import com.fitness.model.Fitness;
import com.fitness.repository.FitnessRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FitnessTest {

    @Autowired private FitnessRepository repo;

    @Test
    public void testAddNew(){
        Fitness fitness=new Fitness();

        fitness.setId(2002);
        fitness.setFirstname("Tessy");
        fitness.setLastname("Tessy");
        fitness.setEmail("tessy@gmail.com");
        fitness.setAge(20);
        fitness.setHeight(2);
        fitness.setWeight(70);
        fitness.setSleep_hours(8);

        Fitness savedFitness= repo.save(fitness);

        Assertions.assertThat(savedFitness).isNotNull();
        Assertions.assertThat(savedFitness.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<Fitness> fitnesses= repo.findAll();
        Assertions.assertThat(fitnesses).hasSizeGreaterThan(0);


        for(Fitness fitness: fitnesses){
            System.out.println(fitness);
        }
    }

    @Test
    public void testUpdate(){
     Integer fitnessId=2002;
        Optional<Fitness> optionalFitness=repo.findById(fitnessId);
        Fitness fitness=optionalFitness.get();
        fitness.setFirstname("Berthe");
        repo.save(fitness);
        Fitness updatedTeacher=repo.findById(fitnessId).get();
        Assertions.assertThat(updatedTeacher.getFirstname()).isEqualTo("Berthe");
    }

    @Test
    public void testGet(){

        Integer Id=3;
        Optional<Fitness> optionUser= repo.findById(Id);
        Assertions.assertThat(optionUser).isPresent();
        System.out.println(optionUser.get());

    }

    @Test
    public void testDelete(){
        Integer Id=10;
        repo.deleteById(Id);

        Optional<Fitness> optionUser= repo.findById(Id);
        Assertions.assertThat(optionUser).isNotPresent();

    }
}
