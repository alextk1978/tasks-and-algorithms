package tasks;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Alexey Tkachenko
 */
class Book {
    private String title;
    private String isbn;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static Book releaseBook(Book book, String isbn) {
        if (Objects.isNull(book.isbn)) {
            book.setIsbn(isbn);
        }
        return book;
    }

    public String getTitleAndIsbnWithSeparator(String separator) {
        return title + separator + isbn;
    }
}

class Main {
    public static void main(String[] args) {
        Function <String, Book> f1 = Book::new;
        Book book = f1.apply("1234");
        Function <Book, String> f2 = Book::getIsbn;
        Function <String, String> f3 = book::getTitleAndIsbnWithSeparator;
        BiFunction<Book, String, Book> f4 = Book::releaseBook;
//        BiFunction<String, String, Book> f5 = book::getTitleAndIsbnWithSeparator;
    }
}
