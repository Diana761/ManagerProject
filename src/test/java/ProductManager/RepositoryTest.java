package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveId() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void WhenRemoveByIdNotExisted() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Doctor Sleep", 560, "Stephen Edwin King");
        Book book2 = new Book(2, "The Catcher in the Rye", 800, "Jerome David Salinger");
        Book book3 = new Book(3, "it", 900, "Stephen Edwin King");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(5)
        );
    }

}

