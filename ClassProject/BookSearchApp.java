package ClassProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class BookSearchApp {
   private static List<String> books=new ArrayList<>();

    public static void main(String[] args){

        books.add("System Analysis And Design");
        books.add("Computer Organization And Architecture");
        books.add("Data Structures");
        books.add("Digital Systems Principles And Application");
        books.add("Numerical Methods");
        books.add("Java");
        books.add("Differential Calculus");
        books.add("Integral Calculus");
        books.add("Database System Concepts");
        books.add("Neural Network and Fuzzy Logic and Genetic Algorithms");
        books.add("Methods Of Applied Mathematics");
        books.add("College Higher Algebra");
        books.add("Software Engineering");
        books.add("Art of Programming Cotest");
        books.add("Data And Computer Communications");
        books.add("Information Security and Control");
        books.add("Communication Engineering");
        books.add("Machine Learning ");
        books.add("Numerical Analysis ");
        books.add("Computer  Peripheral and Interfacing ");
        books.add("Artificial Intelligence ");
        books.add("Technical Writing and Presentation ");
        books.add("Operating System ");
        books.add("Microprocessor and Assembly Language ");
        books.add("Compiler Design ");
        books.add("Algorithm Analysis and Design ");
        books.add("Database Management System (DBMS)");
        books.add("Bangladesh Studies ");
        books.add("Laplace Transformation and Fourier Analysis ");
        books.add("Analytical Programming ");
        books.add("Electrical Machine and Instrument ");
        books.add("Data Structure ");
        books.add("Digital Logic Design ");
        books.add("Engineering Physics- II ");
        books.add("Object Oriented Programming (OOP)");
        books.add("Discrete Mathematics ");
        books.add("Co-ordinate Geometry and Differential Equations");
        books.add("Developing English Skills ");
        books.add("Engineering Physics-I ");
        books.add("Basic Electrical Engineering ");
        books.add("Computer Basic ");
        books.add("Structured Programming ");
        books.add("Differential Calculus and Integral Calculus");


        //Frame Design part
        JFrame frame=new JFrame("Book Search App");
        ImageIcon imageicon=new ImageIcon("E:/java/classProject/src/ClassProject/image2.png");
        frame.setIconImage(imageicon.getImage());
        frame.setSize(800,600);
        frame.setLocation(300,50);
        frame.getContentPane().setBackground(Color.decode("#727272"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label=new JLabel("Welcome To BRIU Library");
        label.setBounds(270,5,300,30);
        label.setForeground(Color.decode("#81e4b3"));
        label.setFont(new Font("Serif", Font.BOLD, 22));
        JTextField searchField=new JTextField();
        searchField.setBounds(45,40,700,40);
        searchField.setBorder(null);
        searchField.setFont(new Font("Serif", Font.PLAIN, 19));
        JButton searchButton=new JButton("Search");
        searchButton.setBounds(300,90,100,30);
        searchButton.setBackground(Color.decode("#1c141f"));
        searchButton.setForeground(Color.white);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(420,90,100,30);
        clearButton.setBackground(Color.decode("#8c6699"));
        clearButton.setForeground(Color.white);
        clearButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        JTextArea resultArea=new JTextArea();
        resultArea.setBounds(45,150,700,380);
        resultArea.setMargin(new Insets(10, 10, 5, 5));
        resultArea.setFont(new Font("Open Sans", Font.PLAIN, 19));
        resultArea.setEditable(false);
        frame.add(label);
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(clearButton);
        frame.add(resultArea);


        //Search action part
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query=searchField.getText().toLowerCase();
                resultArea.setText("");
                boolean found =false;
                for (String book:books){
                    if (book.toLowerCase().contains(query)){
                        resultArea.append(book + "\n");
                        found=true;
                    }
                }
                if (!found){
                    resultArea.setText("Sorry , the book can't found at the moment");
                }
                if (query==null || query.trim().isEmpty()){
                    resultArea.setText("");
                }
            }
        });

        //action to clear button part
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                resultArea.setText("");
            }
        });

        resultArea.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    // Text position of the click
                    int offset = resultArea.viewToModel2D(evt.getPoint());
                    int line = resultArea.getLineOfOffset(offset);

                    // start and end specific line
                    int start = resultArea.getLineStartOffset(line);
                    int end = resultArea.getLineEndOffset(line);

                    //trim()->space removed
                    String selectedBook = resultArea.getText(start, end - start).trim();

                    if (!selectedBook.isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"You selected: " +
                                        selectedBook +"\nStatus: Available in BRIU Library",
                                "Book Details",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                //Find error
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
