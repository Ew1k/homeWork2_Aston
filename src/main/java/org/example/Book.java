package org.example;
import java.util.Objects;

public  class Book implements Comparable<Book> {


    private final String title;
    private final String author;
    private final int pages;
    private final int year;


    public Book(String title, String author, int pages, int year) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;

    }

    public  String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {

        return Integer.compare(this.pages, other.pages);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;

        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return pages == book.pages &&  year == book.year && Objects.equals(title,book.title) && Objects.equals(author, book.author);

    }
    @Override
    public int hashCode() {
        return Objects.hash(title,author,pages,year);

    }

    @Override
    public String toString () {
        return "Книга[" + "Название: " +  title + "," + " Автор: " +  author + "," + " Страниц: " +  pages + " Год: " + year+ "]";



    }





}
