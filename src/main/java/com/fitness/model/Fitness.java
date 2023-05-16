package com.fitness.model;


import jakarta.persistence.*;

@Entity
@Table(name="fitness_table")
public class Fitness {

    public Fitness(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(nullable= false, unique = true, length = 45)
    private String email;
    private int weight;
    private int height;
    private int sleep_hours;
    private int age;

    public Fitness() {
    }

    public Fitness(Integer id, String firstname, String lastname, String email, int weight, int height, int sleep_hours, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.weight = weight;
        this.height = height;
        this.sleep_hours = sleep_hours;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSleep_hours() {
        return sleep_hours;
    }

    public void setSleep_hours(int sleep_hours) {
        this.sleep_hours = sleep_hours;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
