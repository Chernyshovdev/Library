package homework7.library;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Razer on 29.07.15.
 */
public class LibraryController {

    JTextArea textArea;
    private Library library = new Library();
    private final JFrame parent = new JFrame();

    public LibraryController(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void exitButton() {
        int exit = JOptionPane.showConfirmDialog(null, "Do you want to exit?", " ", JOptionPane.YES_NO_OPTION);
        if (exit == 0) {
            try {
                library.saveToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
            parent.dispose();
        }
    }

    public void addToBlackListButton() {
        if (!notEmptyReaders()) {
            textArea.setText(" ");
            textArea.append(library.showReaders() + "\n");
            String idStr = JOptionPane.showInputDialog(parent,
                    "Enter id of reader to add to blacklist:", null);
            int idToBlackList = Integer.parseInt(idStr);
            Boolean result = library.addReaderIntoBlackList(idToBlackList);
            if (!result) {
                JOptionPane.showMessageDialog(parent, "Error invalid id");
            } else {
                JOptionPane.showMessageDialog(parent, "Reader successfully add to blacklist!");
            }
        }
    }

    public void showReaderButton() {
        if (!notEmptyReaders()) {
            textArea.setText(" ");
            textArea.append(library.showReaders());
        }
    }

    public void searchAuthorButton() {
        String author = JOptionPane.showInputDialog(parent,
                "Enter author:", null);
        textArea.setText(" ");
        if(author==null){
            return;
        }
        String bookToSearch = library.searchAuthor(author);
        if (bookToSearch.length() != 0) {
            textArea.append(bookToSearch);
        } else {
            textArea.append("No book found with this author");
        }
    }

    public void showNewBooks() {
        if (!notEmptyBooks()) {
            textArea.setText(" ");
            textArea.append(library.showNewBooks());
        }
    }

    public void showBooksButton() {
        if (!notEmptyBooks()) {
            textArea.setText(" ");
            textArea.append(library.showBooks());
        }
    }

    public void addReaderButton() {
        String name = JOptionPane.showInputDialog(parent,
                "Enter name:", null);
        String surname = JOptionPane.showInputDialog(parent,
                "Enter surname:", null);
        Reader newReader = library.createReader(name, surname);
        library.addReaderToLibrary(newReader);
    }

    public void addBookButton() {
        Book newbook = new Book();
        String name = JOptionPane.showInputDialog(parent,
                "Enter name of book:", null);
        String author = JOptionPane.showInputDialog(parent,
                "Enter author:", null);
        String yearStr = JOptionPane.showInputDialog(parent,
                "Enter year:", null);
        newbook.setName(name);
        newbook.setAuthor(author);
        int year = Integer.parseInt(yearStr);
        newbook.setYear(year);
        library.addBookToLibrary(newbook);
    }

    public Boolean notEmptyBooks() {
        boolean empty = false;
        if (library.getCountOfBooks() == 0) {
            empty = true;
            JOptionPane.showMessageDialog(parent, "Error,empty library!", " ", JOptionPane.ERROR_MESSAGE);
        }
        return empty;
    }

    public boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean notEmptyReaders() {
        boolean empty = false;
        if (library.getCountOfReaders() == 0) {
            empty = true;
            JOptionPane.showMessageDialog(parent, "Error,empty library!", " ", JOptionPane.ERROR_MESSAGE);
        }
        return empty;
    }

    public void showBlacklistButton() {
        textArea.setText(" ");
        textArea.append(library.showBlacklist());
    }

    public void getBookToReader() {
        textArea.setText(" ");
        textArea.append(library.showReaders());
        String idReaderToAddStr = JOptionPane.showInputDialog(parent,
                "Enter id of reader that you want to add book:", null);
        int idReaderToAdd = Integer.parseInt(idReaderToAddStr);
        if (library.returnElementById(idReaderToAdd).getBlacklist()) {
            JOptionPane.showMessageDialog(parent, "Cant add book,because reader into blacklist!", " ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        textArea.append(library.showBooks());
        String idOfBookToAddStr = JOptionPane.showInputDialog(parent,
                "Enter id of book that you want to add to the reader:", null);
        int idOfBookToAdd = Integer.parseInt(idOfBookToAddStr);
        Reader read = library.returnElementById(idReaderToAdd);//idOfBookToAdd); //= new Reader();
        Book book = library.returnElementFromBooks(idOfBookToAdd - 1);
        book.setAvailable(false);
        read.addBook(book);
        textArea.append("Book add successful");
    }

    public void showListOfBooksSpecificReader(){
        textArea.setText(" ");
        textArea.append(library.showReaders());
        String idSTR  = JOptionPane.showInputDialog(parent,
                "Enter id of Reader to show his book:", null);
        int id=Integer.parseInt(idSTR);
        library.returnElementById(id).showReaderBooks();
    }

    public void deleteReaderButton() {
        if (!notEmptyReaders()) {
            textArea.setText(" ");
            textArea.append(library.showReaders() + "\n");
        }
        String idStr = JOptionPane.showInputDialog(parent,
                "Enter id of reader to delete from library:", null);
        int id = Integer.parseInt(idStr);
        if (checkString(idStr)) {
            if (id < 1 || id > library.getCountOfReaders()) {
                JOptionPane.showMessageDialog(parent, "Error invalid id!", " ", JOptionPane.ERROR_MESSAGE);
            } else {
                library.deleteReaderFromLibrary(id - 1);
            }
        } else {
            JOptionPane.showMessageDialog(parent, "You entered not integer!", " ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showListOfBooksReaders() {
        textArea.setText(" ");
        for (int i = 0; i < library.getCountOfReaders(); i++) {
            for (int j = 0; j < library.returnElementFromReaders(i).getCountOfBooks(); j++)
                textArea.append(library.showBook(library.returnElementFromReaders(i).returnElementFromReaderBooks(j)));
        }
    }

    public void readFromFile() {
        library.readFromFile();
    }
}
