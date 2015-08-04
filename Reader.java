package homework7.library;

/**
 * Created by Razer on 10.06.15.
 */
public class Reader {
    private String name;
    private String surname;
    private int id;
    private boolean blackList = false;
    private static int countId = 1;
    private Book[] readerBooks = new Book[5];
    private int countOfBooks = 0;

    Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
        id = countId++;
    }

    Reader() {
        id = countId++;
    }

    public void setBlackList(boolean blackList) {
        this.blackList = blackList;
    }

    public boolean getBlacklist() {
        return blackList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfBooks() {
        return countOfBooks;
    }

    public Book returnElementFromReaderBooks(int id) {
        int k = 0;
        for (int i = 0; i < countOfBooks; i++)
            if (readerBooks[i].getId() == id) {
                k = i;
            }
        return readerBooks[k];
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public void addBook(Book book) {
        if (countOfBooks == readerBooks.length) {
            System.out.println("Sorry,you can take only 3 books");
        } else {
            readerBooks[countOfBooks] = book;
            countOfBooks++;
        }
    }

    public String toString() {

        return "Reader: " + " Name: " + name + "  Surname: " + surname + " Id:  " + id;


    }

    public void showReaderBooks() {
        for (int i = 0; i < countOfBooks; i++) {
            System.out.println(readerBooks[i].toString());
        }
    }
}

