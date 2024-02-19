package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        // Given
        World world = new World();

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83000000")));

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Nigeria", new BigDecimal("206000000")));
        africa.addCountry(new Country("Egypt", new BigDecimal("104000000")));

        world.addContinent(europe);
        world.addContinent(africa);

        // When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        // Then
        assertEquals(new BigDecimal("431000000"), totalPopulation);
    }
}