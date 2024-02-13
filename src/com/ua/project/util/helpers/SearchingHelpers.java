package com.ua.project.util.helpers;

import com.ua.project.models.Author;
import com.ua.project.interfaces.HasTitle;
import com.ua.project.interfaces.implementation.Almanac;
import com.ua.project.interfaces.implementation.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SearchingHelpers {
    public static List<Book> searchBooksByAuthor(ListIterator<Book> searchList, final Author author) {
        List<Book> authorsMatched = new ArrayList<Book>();

        while(searchList.hasNext()){
            Book currentBook = searchList.next();

            if(currentBook.getAuthor().equals(author)){
                authorsMatched.add(currentBook);
                continue;
            }
        }

        return authorsMatched;
    }

    public static <T extends HasTitle> List<T> searchByTitle(ListIterator<T> searchList, final String title) {
        List<T> titlesMatched = new ArrayList<T>();

        while(searchList.hasNext()){
            T currentBook = searchList.next();

            if(currentBook.getTitle().toLowerCase().contains(title.toLowerCase())){
                titlesMatched.add(currentBook);
                continue;
            }
        }

        return titlesMatched;
    }


    public static List<Almanac> searchAlmanacsByAuthor(ListIterator<Almanac> searchList, final Author author) {
        List<Almanac> authorsMatched = new ArrayList<Almanac>();

        while(searchList.hasNext()){
            Almanac currentAlmanac = searchList.next();

            for (Book book : currentAlmanac.getBooks()) {
                if(book.getAuthor().equals(author)){
                    authorsMatched.add(currentAlmanac);
                    break;
                }
            }
        }

        return authorsMatched;
    }
}
