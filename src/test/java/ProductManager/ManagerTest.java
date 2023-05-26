package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWithoutProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenTheNameIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("it");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenMultipleValuesAreFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");
        Book book4 = new Book(4, "it 2", 900, "Stephen Edwin King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("it");
        Product[] expected = {book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenNoValueIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");
        Book book4 = new Book(4, "it 2", 900, "Stephen Edwin King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("x");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenTheRequestIsEmpty() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");
        Book book4 = new Book(4, "it 2", 900, "Stephen Edwin King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("");
        Product[] expected = {book1, book2, book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenThePhoneNameIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(3, "Iphone13", 100_000, "APPLE");
        Smartphone smartphone2 = new Smartphone(6, "Iphone14", 18_000, "APPLE");

        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Iphone13");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

}