package com.ua.project.interfaces.implementation;

import com.ua.project.models.Author;
import com.ua.project.interfaces.HasTitle;
import com.ua.project.interfaces.Printable;

public class Book implements Printable, HasTitle {
    private int pagesAmount;
    private Author author;
    private String title;
    private String genre;

    public Book(int pagesAmount, Author author, String title, String genre) {
        this.pagesAmount = pagesAmount;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }
    public Book() {
        this(1, new Author("Somename", "Somelastname"), "SimpleTitle", "BookGenre");
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println(" Printing Book \"" + this.getTitle() + "\"...");
    }

    @Override
    public String toString() {
        return " Book Title: " + this.getTitle() +
                "\n Author: " + this.getAuthor() +
                "\n Genre: " + this.getGenre() +
                "\n Pages: " + this.getPagesAmount();
    }
}
