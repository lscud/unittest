package com.lscudeler.unittest.service;

import com.lscudeler.unittest.dominio.Person;

import java.util.Objects;

public class PersonService {
    public boolean isAdult(Person person) {
        //Objects.requireNonNull(person, "Person can´t be null");
        if(person == null){
            throw new IllegalArgumentException();
        }
        return person.getAge() >= 18;
    }
}
