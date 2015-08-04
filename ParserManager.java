package homework7.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Razer on 28.07.15.
 */
public class ParserManager {
    private ArrayList<Book> ListOfBookFromFile = new ArrayList<Book>();
    private static String CHAR_TO_SEARCH = ":";

    public String ConvertObjectToString(ArrayList<Book> books) {
        StringBuilder Builder = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            String name = books.get(i).getName();
            String author = books.get(i).getAuthor();
            int year = books.get(i).getYear();
            //int id = books.get(i).getId();
            Builder.append(name + CHAR_TO_SEARCH + author + CHAR_TO_SEARCH + year + CHAR_TO_SEARCH + "\n");
        }

        return Builder.toString();
    }

    public ArrayList<Book> ConvertStringToObject(String nameOfFile) throws FileNotFoundException {
        String oneBook;
        try (Scanner in = new Scanner(new File(nameOfFile))) {
            while (in.hasNext()) {
                oneBook = in.nextLine();
                String [] parts =oneBook.split(CHAR_TO_SEARCH);
                String name=parts[0];
                String author=parts[1];
                String year =parts[2];
                Book newBook = new Book();
                newBook.setName(name);
                newBook.setAuthor(author);
                newBook.setYear(Integer.parseInt(year));
                ListOfBookFromFile.add(newBook);
            }
        }
        return ListOfBookFromFile;
    }
}
