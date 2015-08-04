package homework7.library;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Razer on 10.06.15.
 */
public class Library {
    String path = "/Users/johnsmith/IdeaProjects/ACO3/src/homework7/library/" + NAME_OF_FILE;
    ParserManager manager = new ParserManager();
    private ArrayList<Reader> readers = new ArrayList<Reader>();
    private ArrayList<Book> books = new ArrayList<Book>();
    public static final String NAME_OF_FILE = "Library.txt";


    public void addReaderToLibrary(Reader read) {

        readers.add(read);
    }

    public void deleteReaderFromLibrary(int id){
        readers.remove(id);
    }

    public int getCountOfReaders() {
        return readers.size();
    }

    public int getCountOfBooks() {
        return books.size();
    }

    public void addBookToLibrary(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Reader returnElementFromReaders(int i) {
        return readers.get(i);
    }

    public Reader returnElementById(int id) {
        int k = 0;
        for (int i = 0; i < getCountOfReaders(); i++)
            if (readers.get(i).getId() == id) {
                k = i;
            }
        return readers.get(k);
    }

    public Book returnElementFromBooks(int i) {
        return books.get(i);
    }

    public String showBook(Book book) {
        return book.toString();
    }

    public String showBooks() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getCountOfBooks(); i++) {
            if (returnElementFromBooks(i).getAvailable()) {
                builder.append(showBook((returnElementFromBooks(i)))).append("\n");
            }
        }
        return builder.toString();
    }

    public Reader createReader(String name, String surname) {
        Reader newreader = new Reader();
        newreader.setName(name);
        newreader.setSurname(surname);
        return newreader;
    }

    public String showReader(Reader read) {
        return read.toString();
    }

    public String showReaders() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getCountOfReaders(); i++) {
            builder.append(showReader(returnElementFromReaders(i))).append("\n");
        }
        return builder.toString();
    }

    public String showNewBooks() {
        int yearOfBook = 2013;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getCountOfBooks(); i++)
            if (yearOfBook <= returnElementFromBooks(i).getYear()) {
                //showBook(returnElementFromBooks(i));
                builder.append(returnElementFromBooks(i)).append("\n");
            }
        return builder.toString();
    }

    public String searchAuthor(String findAuthor) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getCountOfBooks(); i++) {
            if (findAuthor.equals(returnElementFromBooks(i).getAuthor()))
                builder.append(returnElementFromBooks(i)).append("\n");
        }
        return builder.toString();

    }

    public Boolean addReaderIntoBlackList(int idToBlackList) {
        Boolean result;
        if (idToBlackList > getCountOfReaders()) {
            result = false;
        } else {
            returnElementById(idToBlackList).setBlackList(true);
            result = true;
        }
        return result;
    }

    public String showBlacklist() {
        int i = getCountOfReaders() - 1;
        StringBuilder builder = new StringBuilder();
        while (i != -1) {
            if (returnElementFromReaders(i).getBlacklist() == true) {
                builder.append(returnElementFromReaders(i));
            }
            i--;
        }
        return builder.toString();
    }

    public void saveToFile() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter Writer = new FileWriter(file);
        Writer.write(manager.ConvertObjectToString(books));
        Writer.close();
    }

    public void readFromFile() {
        try {
            books = manager.ConvertStringToObject(this.path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}











