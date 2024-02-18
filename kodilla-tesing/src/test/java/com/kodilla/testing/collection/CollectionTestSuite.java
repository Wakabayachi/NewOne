// CollectionTestSuite.java
package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for OddNumbersExterminator")
class CollectionTestSuite {

    private OddNumbersExterminator exterminator;

    @BeforeEach
    void setUp() {
        exterminator = new OddNumbersExterminator();
        System.out.println("Preparing to execute test...");
    }

    @AfterEach
    void tearDown() {
        exterminator = null;
        System.out.println("Test finished.");
    }

    @Test
    @DisplayName("Testing empty list")
    void testOddNumbersExterminatorEmptyList() {
        // Given
        List<Integer> emptyList = new ArrayList<>();
        // When
        List<Integer> result = exterminator.exterminate(emptyList);
        // Then
        assertTrue(result.isEmpty(), "List should be empty");
    }

    @Test
    @DisplayName("Testing normal list")
    void testOddNumbersExterminatorNormalList() {
        // Given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        // When
        List<Integer> result = exterminator.exterminate(numbers);
        // Then
        assertEquals(2, result.size(), "List size should be 2");
        assertTrue(result.contains(2), "List should contain 2");
        assertTrue(result.contains(4), "List should contain 4");
    }
}