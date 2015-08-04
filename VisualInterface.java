package homework7.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Razer on 27.07.15.
 */
public class VisualInterface extends JFrame {

    private static final String TITLE = "Library";
    private JButton addBookButton;
    private JButton addReaderButton;
    private JButton showReaderButton;
    private JButton exitButton;
    private JButton showBooksButton;
    private JButton showNewBooksButton;
    private JButton searchAuthorButton;
    private JButton addToBlackListButton;
    private JButton showBlackList;
    private JButton getBookToReader;
    private JButton deleteReaderButton;
    private JTextArea textArea = new JTextArea();
    LibraryController controller = new LibraryController(textArea);

    public VisualInterface() {
        super(TITLE);
        init();
    }

    private void init() {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setupTextArea();
        setupButtons();
        controller.readFromFile();
    }

    private void setupTextArea() {
        textArea.setLineWrap(true);
        textArea.setEditable(true);
        textArea.setBackground(Color.GRAY);
        getContentPane().add(textArea);
    }

    private void setupButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(13, 1));
        getContentPane().add(buttonPanel, BorderLayout.WEST);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addBookButton = new JButton("Add book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addBookButton();
            }
        });
        buttonPanel.add(addBookButton);


        addReaderButton = new JButton("Add reader");
        addReaderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addReaderButton();
            }
        });
        buttonPanel.add(addReaderButton);

        deleteReaderButton = new JButton("Delete reader");
        deleteReaderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteReaderButton();
            }
        });
        buttonPanel.add(deleteReaderButton);

        getBookToReader = new JButton("Get book to reader");
        getBookToReader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getBookToReader();
            }
        });
        buttonPanel.add(getBookToReader);

        showBooksButton = new JButton("Show books");
        showBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showBooksButton();
            }
        });
        buttonPanel.add(showBooksButton);

        showNewBooksButton = new JButton("Show new books");
        showNewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showNewBooks();
            }
        });
        buttonPanel.add(showNewBooksButton);

        searchAuthorButton = new JButton("Search by author");
        searchAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchAuthorButton();
            }
        });
        buttonPanel.add(searchAuthorButton);

        showReaderButton = new JButton("Show reader");
        showReaderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showReaderButton();
            }
        });
        buttonPanel.add(showReaderButton);

        addToBlackListButton = new JButton("Add reader to blacklist");
        addToBlackListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addToBlackListButton();
            }
        });
        buttonPanel.add(addToBlackListButton);

        showBlackList = new JButton("Show blacklist");
        showBlackList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showBlacklistButton();
            }
        });
        buttonPanel.add(showBlackList);

        exitButton = new JButton("Exit");
        //exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.red);
        //exitButton.setOpaque(true);//?
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exitButton();
            }
        });
        buttonPanel.add(exitButton);
    }

    private JPanel myFrame() {
        JTextField nameOfBook = new JTextField(40);
        JLabel nameLabel = new JLabel("Name of book:");
        nameLabel.setLabelFor(nameOfBook);
        JTextField author = new JTextField(40);
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setLabelFor(author);
        JTextField year = new JTextField(4);
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setLabelFor(year);

        return null;
    }

}
