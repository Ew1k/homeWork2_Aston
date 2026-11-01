package org.example;

import java.util.List;
import java.util.stream.Collectors;


public  class Student {

    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {

        if (books == null || books.size() < 5) {
            throw new IllegalArgumentException("У студента " + name  + " обязано быть 5 книг");

        }

        this.name = name;
        this.books = books;

    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "\nStudent: " + name +
                "\nСписок книг:\n" +
                books.stream()
                        .map(Book::toString)
                        .collect(Collectors.joining("\n"));
    }

}
