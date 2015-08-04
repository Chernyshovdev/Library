package homework7.library;

import java.io.Serializable;

/**
 * Created by Razer on 10.06.15.
 */
public class Book implements Serializable {
    private String name;
    private String author;
    private int year;
    private int id;
    private static int counter = 1;
    private boolean available;

    public Book(String name, String author, int year, boolean available) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
        id = counter++;
    }

    public Book() {
        id = counter++;
        available = true;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }


    public int getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Book: " + " Name: " + name + " Author: " + author + " Year: " + year + " Id: " + id;
    }
}
