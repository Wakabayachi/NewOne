package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookLibraryTestSuite {
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    @BeforeEach
    void setUp() {
        libraryDatabaseMock = mock(LibraryDatabase.class);
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    void testListBooksInHandsOfZeroBooks() {
        // Given
        LibraryUser user = new LibraryUser("John", "Doe", "123456789");
        List<Book> booksInHandsOfUser = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksInHandsOfUser);

        // When
        List<Book> result = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(0, result.size());
    }

    @Test
    void testListBooksInHandsOfOneBook() {
        // Given
        LibraryUser user = new LibraryUser("John", "Doe", "123456789");
        List<Book> booksInHandsOfUser = new ArrayList<>();
        booksInHandsOfUser.add(new Book("Title", "Author", 2000));
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksInHandsOfUser);

        // When
        List<Book> result = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(1, result.size());
    }

    @Test
    void testListBooksInHandsOfFiveBooks() {
        // Given
        LibraryUser user = new LibraryUser("John", "Doe", "123456789");
        List<Book> booksInHandsOfUser = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            booksInHandsOfUser.add(new Book("Title" + i, "Author", 2000));
        }
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksInHandsOfUser);

        // When
        List<Book> result = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(5, result.size());
    }
}