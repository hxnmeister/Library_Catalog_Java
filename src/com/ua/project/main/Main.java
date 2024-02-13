package com.ua.project.main;

import com.ua.project.interfaces.implementation.Almanac;
import com.ua.project.models.Author;
import com.ua.project.interfaces.implementation.Book;
import com.ua.project.interfaces.implementation.Newspaper;
import com.ua.project.util.helpers.InputHelpers;
import com.ua.project.util.helpers.SearchingHelpers;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String searchTitle;
        final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        List<Book> books = new ArrayList<Book>(List.of(new Book[]{
            new Book(292, new Author("Christopher", "Golden"), "The House of Last Resort", "Horror"),
            new Book(320, new Author("C.S.", "Robertson"), "The Trials of Marjorie Crowe", "Mystery"),
            new Book(320, new Author("Arushi", "Avachat"), "Arya Khanna's Bollywood Moment", "Romance"),
            new Book(464, new Author("Amélie Wen", "Zhao"), "Dark Star Burning, Ash Falls White", "Fantasy"),
            new Book(320, new Author("Moshe", "Kasher"), "Subculture Vulture: A Memoir in Six Scenes", "Memoir"),
            new Book(302, new Author("Lynn", "Walker"), "A Perfectly Good Fantasy: A Memoir", "Memoir"),
            new Book(216, new Author("Taiyo", "Matsumoto"), "Tokyo These Days, Vol. 1", "Manga"),
            new Book(208, new Author("Gege", "Akutami"), "Jujutsu Kaisen #25", "Manga"),
            new Book(267, new Author("Kiersten", "White"), "Haunted Holiday", "Mystery"),
            new Book(400, new Author("Krystal", "Sutherland"), "The Invocations", "Fantasy"),
        }));
        List<Almanac> almanacs = new ArrayList<Almanac>(Arrays.asList(new Almanac[]{
                new Almanac("Almanac 1", new ArrayList<Book>(List.of(new Book[]{
                        new Book(288, new Author("Marcia", "Biederman"), "The Disquieting Death of Emma Gill: Abortion, Death, and Concealment in Victorian New England", "True Crime"),
                        new Book(528, new Author("Michele", "Norris"), "Our Hidden Conversations: What Americans Really Think About Race and Identity", "Nonfiction"),
                        new Book(192, new Author("Jules", "Gill-Peterson"), "A Short History of Trans Misogyny", "Nonfiction, History"),
                        new Book(544, new Author("Jonathan", "Bliter"), "Everyone Who Is Gone Is Here: The United States, Central America, and the Making of a Crisis", "Nonfiction"),
                        new Book(352, new Author("Rachel", "Slade"), "Making It in America: The Almost Impossible Quest to Manufacture in the U.S.A.", "Nonfiction")
                }))),
                new Almanac("Almanac 2", new ArrayList<Book>(List.of(new Book[]{
                        new Book(816, new Author("Sarah J.", "Maas"), "House of Flame and Shadow", "Fantasy"),
                        new Book(352, new Author("Georgia", "Summers"), "The City of Stardust", "Fantasy"),
                        new Book(292, new Author("Christopher", "Golden"), "The House of Last Resort", "Horror"),
                        new Book(320, new Author("Snubnum", "Khan"), "The Djinn Waits a Hundred Years", "Fantasy")
                }))),
                new Almanac("Almanac 3", new ArrayList<Book>(new ArrayList<Book>(List.of(new Book[]{
                        new Book(304, new Author("Michael", "Easter"), "The Comfort Crisis: Embrace Discomfort To Reclaim Your Wild, Happy, Healthy Self", "Nonfiction"),
                        new Book(307, new Author("Adam M.", "Grant"), "Think Again: The Power of Knowing What You Don't Know", "Nonfiction"),
                        new Book(304, new Author("Marisa", "Meltzer"), "Glossy: Ambition, Beauty, and the Inside Story of Emily Weiss's Glossier", "Nonfiction")
                }))))
        }));
        List<Newspaper> newspapers = new ArrayList<Newspaper>(List.of(new Newspaper[]{
                new Newspaper("The New York Times", new Date(), List.of(
                        "Headline 1",
                        "Headline 2",
                        "Headline 3"
                )),
                new Newspaper("The Guardian", new Date(), List.of(
                        "Headline 4",
                        "Headline 5",
                        "Headline 6"
                )),
                new Newspaper("The Guardian", new Date(), List.of(
                        "Headline 7",
                        "Headline 8",
                        "Headline 9"
                )),
                new Newspaper("The Times", new Date(), List.of(
                        "Headline 10",
                        "Headline 11",
                        "Headline 12"
                )),
                new Newspaper("The Wall Street Journal", new Date(), List.of(
                        "Headline 13",
                        "Headline 14",
                        "Headline 15"
                )),
        }));
        List<Book> booksSearchResult;
        List<Almanac> almanacsSearchResult;
        List<Newspaper> newspapersSearchResult;

        while(true) {
            try {
                switch(getMainMenuChoice()) {
                    case 1:
                        System.out.println("\n Books:\n");
                        displayListInfo(books.listIterator());
                        break;
                    case 2:
                        System.out.println("\n Almanacs:\n");
                        displayListInfo(almanacs.listIterator());
                        break;
                    case 3:
                        System.out.println("\n Newspapers:\n");
                        displayListInfo(newspapers.listIterator());
                        break;
                    case 4:
                        System.out.println("\n Catalog:\n");
                        displayListInfo(books.listIterator(), almanacs.listIterator(), newspapers.listIterator());
                        break;
                    case 5:
                        Author searchAuthor = new Author();
                        searchAuthor.fillBio();

                        switch(getSearchMenuChoice()) {
                            case 1:
                                booksSearchResult = SearchingHelpers.searchBooksByAuthor(books.listIterator(), searchAuthor);

                                displayListInfo(booksSearchResult.listIterator());
                                break;
                            case 2:
                                almanacsSearchResult = SearchingHelpers.searchAlmanacsByAuthor(almanacs.listIterator(), searchAuthor);

                                displayListInfo(almanacsSearchResult.listIterator());
                                break;
                            case 0:
                                break;
                            default:
                                throw new IllegalStateException("\n Input out of range!\n Try again!\n");
                        }
                        break;
                    case 6:
                        searchTitle = InputHelpers.getStringInputByLength("\n Enter title: ", 1);
                        booksSearchResult = SearchingHelpers.searchByTitle(books.listIterator(), searchTitle);

                        displayListInfo(booksSearchResult.listIterator());
                        break;
                    case 7:
                        searchTitle = InputHelpers.getStringInputByLength("\n Enter title: ", 1);
                        newspapersSearchResult = SearchingHelpers.searchByTitle(newspapers.listIterator(), searchTitle);

                        displayListInfo(newspapersSearchResult.listIterator());
                        break;
                    case 0:
                        System.out.println(" Program shutting down...");
                        System.exit(0);
                        break;
                    default:
                        throw new IllegalStateException("\n Input out of range!\n Try again!\n");
                }
            }
            catch(InputMismatchException e){
                System.out.println("\n Please, enter number!");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static short getMainMenuChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Available actions:");
        System.out.println("  1. Display books;");
        System.out.println("  2. Display almanacs;");
        System.out.println("  3. Display newspapers;");
        System.out.println("  4. Display whole catalog;");
        System.out.println("  5. Search by author;");
        System.out.println("  6. Search by book title;");
        System.out.println("  7. Search by newspaper title;");
        System.out.println("  0. Exit;");

        System.out.print("\n Input line: ");
        return scanner.nextShort();
    }

    public static short getSearchMenuChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Search in:");
        System.out.println("  1. Books;");
        System.out.println("  2. Almanacs;");
        System.out.println("  0. Return to main menu;");

        System.out.print("\n Input line: ");
        return scanner.nextShort();
    }

    public static <T extends ListIterator> void displayListInfo(T... values) {
        for (T value : values) {
            while(value.hasNext()) {
                System.out.println(value.next());
                System.out.println("-".repeat(25));
            }
        }
    }
}
