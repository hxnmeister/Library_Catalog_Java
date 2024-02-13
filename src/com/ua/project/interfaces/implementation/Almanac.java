package com.ua.project.interfaces.implementation;

import com.ua.project.interfaces.HasAuthor;
import com.ua.project.interfaces.HasTitle;
import com.ua.project.interfaces.Printable;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class Almanac implements Printable, HasTitle {
    private String title;
    private List<Book> books;

    public Almanac(String title, List<Book> books) {
        this.title = title;
        this.books = books;
    }
    public Almanac() {
        this("AlmanacTITLE", new ArrayList<Book>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book pushBook(Book book) {
        this.books.add(book);
        return book;
    }

    public Book removeBookByIndex(int index) {
        return index >= 0 ? this.books.remove(index) : null;
    }

    public Book popBook() {
        return this.books.removeLast();
    }

    @Override
    public void print() {
        System.out.println(" Printing Almanac \"" + this.getTitle() + "\"...");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(" Title: " + this.getTitle() + "\n Books:");

        books.forEach((value) -> {
            builder.append("\n  - ").append(value);
        });

        return builder.toString();
    }
}
