package com.lscudeler.unittest.service;

import com.lscudeler.unittest.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach  //com essa notação essa classe será executada antes de cada um dos testes unitários
    public void setUp(){
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18 ")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18 ")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        Assertions.assertTrue(personService.isAdult(adult)); //Verifica se o resultado retorna true
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null ")
    void isAdult_ShouldThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.isAdult(null));
    }

    @Test
    @DisplayName("Should return list with only adults ")
    void filterRemovingNotAdult_ReturnLisWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(23);
        //List<Person> personList = List.of(person1, person2, person3);
        List personList = new ArrayList<>();
        personList.addAll(Arrays.asList(person1, person2, person3));
        Assertions.assertEquals(2,personService.filterRemovingNotAdult(personList).size());
    }

}