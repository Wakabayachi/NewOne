// ShapeCollectorTestSuite.java
package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for ShapeCollector")
class ShapeCollectorTestSuite {

    private ShapeCollector shapeCollector;

    @BeforeEach
    void setUp() {
        shapeCollector = new ShapeCollector();
    }

    @Nested
    @DisplayName("Tests for adding and removing shapes")
    class AddAndRemoveTests {
        @Test
        void testAddFigure() {
            // Given
            Shape circle = new Circle(5);

            // When
            shapeCollector.addFigure(circle);

            // Then
            assertEquals("Circle", shapeCollector.showFigures());
        }

        @Test
        void testRemoveFigure() {
            // Given
            Shape square = new Square(4);
            shapeCollector.addFigure(square);

            // When
            boolean result = shapeCollector.removeFigure(square);

            // Then
            assertTrue(result);
            assertEquals("", shapeCollector.showFigures());
        }
    }

    @Nested
    @DisplayName("Tests for getting shapes")
    class GetShapeTests {
        @Test
        void testGetFigure() {
            // Given
            Shape triangle = new Triangle(3, 4);
            shapeCollector.addFigure(triangle);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertNotNull(retrievedShape);
            assertEquals("Triangle", retrievedShape.getShapeName());
            assertEquals(6.0, retrievedShape.getField(), 0.001);
        }

        @Test
        void testGetFigureWithInvalidIndex() {
            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertNull(retrievedShape);
        }
    }
}