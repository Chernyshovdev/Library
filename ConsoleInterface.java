package homework7.library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Razer on 11.06.15.
 */
public class ConsoleInterface extends Book {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    public void interpretatorOfCommand() {
        boolean startOfProgram = true;
        init();
        while (startOfProgram) {
            userMenu();
            int command = scanner.nextInt();
            startOfProgram = executeCommand(command);
        }
    }

    public void userMenu() {
        System.out.println("Please enter number of command");
        System.out.println("1) Show the list of readers");
        System.out.println("2) Show the list of available books");
        System.out.println("3) Add book into library");
        System.out.println("4) Add reader into library");
        System.out.println("5) Give book to reader");
        System.out.println("6) Show list of books readers");
        System.out.println("7) Show list of books specific reader");
        System.out.println("8) Add reader to blacklist");
        System.out.println("9) Show author");
        System.out.println("10) Show new books");
        System.out.println("13) Quit");
    }

    public boolean executeCommand(int command) {
        switch (command) {
            case 1:
                showReaders();//+
                break;
            case 2:
               showBooks();//+
                break;
            case 3:
                addBook();//+
                break;
            case 4:
                addReader();//+
                break;
            case 5:
                getBookToReader();//+
                break;
            case 6:
                showListOfBooksReaders();
                break;
            case 7:
                showListOfBooksSpecificReader();
                break;
            case 8:
                addReaderIntoBlackList();//+
                break;
            case 9:
                searchAuthor();//+
                break;
            case 10:
                showNewBooks();//+
                break;
            case 13:
                return false;
            default:
                System.out.println("    Error,wrong command");
        }

        return true;
    }

    public void addReaderIntoBlackList() {
        showReaders();
        System.out.println("Enter id of reader to add into blacklist");
        int idToBlackList = scanner.nextInt();
        library.returnElementById(idToBlackList).setBlackList(true);
        System.out.println("    Id " + idToBlackList + " successful add into blacklist");
    }

    public void getBookToReader() {
        System.out.println("Enter id of reader that you want to add book:");
        System.out.println();
        showReaders();
        int idReaderToAdd = scanner.nextInt();
        if (library.returnElementById(idReaderToAdd).getBlacklist()) {
            System.out.println("Cant add book,because reader into blacklist");
            return;
        }
        System.out.println("Enter the number of book that you want to add to the reader");
        System.out.println();
//        showBooks();
        int idOfBookToAdd = scanner.nextInt();
        Reader read = library.returnElementById(idReaderToAdd);//idOfBookToAdd); //= new Reader();
        Book book =  library.returnElementFromBooks(idOfBookToAdd - 1);
        book.setAvailable(false);
        read.addBook((Book) library.returnElementFromBooks(idOfBookToAdd - 1));
        System.out.println("Book add successful");

    }

    public void showReaders() {
        for (int i = 0; i < library.getCountOfReaders(); i++) {
            showReader(library.returnElementFromReaders(i));
        }
    }

    public void showReader(Reader read) {
        System.out.println(read.toString());
        // read.showReaderBooks();
    }

    public void showBook(ArrayList<Book> book) {
        System.out.println(book.toString());
    }
    public void showBook(Book book) {
        System.out.println(book.toString());
    }

    public void showBooks() {
        for (int i = 0; i < library.getCountOfBooks(); i++) {
            if (library.returnElementFromBooks(i).getAvailable()) {
                showBook((library.getBooks()));
            }

        }
    }

    public void addBook() {
        library.addBookToLibrary(inputBook());
    }

    public void addReader() {
        library.addReaderToLibrary(inputReader());
    }

    public void searchAuthor() {
        System.out.println("Enter surname of author:");
        String findAuthor = scanner.next();
        for (int i = 0; i < library.getCountOfBooks(); i++) {
            showAuthor( library.returnElementFromBooks(i), findAuthor);
        }

    }

    public void showAuthor(Book book, String findAuthor) {
        if (findAuthor.equals(book.getAuthor()))
            System.out.println(book.toString());
    }

    public void showNewBooks() {
        int year = 2013;
        for (int i = 0; i < library.getCountOfBooks(); i++)
            if (year <= library.returnElementFromBooks(i).getYear()) {
                showBook(library.returnElementFromBooks(i));
            }
    }

    public Book inputBook() {
        System.out.println("Getting new book from console");
        Book newbook = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        newbook.setName(scanner.nextLine());
        System.out.println("Enter author:");
        newbook.setAuthor(scanner.nextLine());
        System.out.println("Enter year ");
        newbook.setYear(scanner.nextInt());
        return newbook;
    }

    public Reader inputReader() {
        System.out.println("Getting new reader from console");
        Reader newreader = new Reader();
        System.out.println("Enter name");
        newreader.setName(scanner.nextLine());
        System.out.println("Enter surname");
        newreader.setSurname(scanner.nextLine());
        return newreader;
    }

    public void showListOfBooksReaders() {
        for (int i = 0; i < library.getCountOfReaders(); i++) {
            for (int j = 0; j < library.returnElementFromReaders(i).getCountOfBooks(); j++)
                showBook(library.returnElementFromReaders(i).returnElementFromReaderBooks(j));
        }
    }

    public void showListOfBooksSpecificReader() {
        showReaders();
        System.out.println("Enter id of Reader to show his book");
        int id = scanner.nextInt();
        library.returnElementById(id).showReaderBooks();
    }

    public void init() {
        Reader reader1 = new Reader("Dima", "Chernyshov");
        Reader reader2 = new Reader("Taras", "Pyvovarov");
        Reader reader3 = new Reader("Viktor", "Rudenko");
        library.addReaderToLibrary(reader1);
        library.addReaderToLibrary(reader2);
        library.addReaderToLibrary(reader3);
        Book book1 = new Book("Garry Potter", "J. K. Rowling", 1997, true);
        Book book2 = new Book("Thinking in Java", "Bruce", 2009, true);
        Book book3 = new Book("Title", "Author", 2014, true);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);


    }
}


