import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame implements ActionListener {

    JFrame frame;
    JLabel title;
    JTextField textField;

    JButton guessButton;
    JButton deleteButton;
    JButton clearButton;
    JButton ZerotoTen;
    JButton ZerotoTwenty;
    JButton ZerotoFifty;
    JButton ZerotoHundred;

    int numberToGuess;
    int numberGuessed;

    //creating an array for the buttons
    JButton[] operators = new JButton [7];

    //constructor for the game
    public GuessingGame() {

        //creating the frame for the game
        frame = new JFrame("Guess the Number!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);

        //creating the header for the game
        title = new JLabel("GUESS THE NUMBER!");
        title.setForeground(Color.BLACK);
        title.setBackground(Color.GRAY);
        title.setOpaque(true);
        title.setBounds(50, 0, 400, 100);
        title.setFont(new Font("Sans-Serif", Font.BOLD, 36));

        //creating the textfield
        textField = new JTextField();
        textField.setBounds(150, 225,  200, 50);
        //making it so only numbers can be inputted into the textfield by the user
        textField.addKeyListener(new KeyAdapter(){
        public void keyPressed (KeyEvent key){
        
            if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9'){
                textField.setEditable(true);
            } else {
                textField.setEditable(false);
            }
        }
        });
        
        //creating all of the buttons needed for the game
        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        ZerotoTen = new JButton("0-10");
        ZerotoTen.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        ZerotoTwenty = new JButton("0-20");
        ZerotoTwenty.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        ZerotoFifty = new JButton("0-50");
        ZerotoFifty.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        ZerotoHundred = new JButton("0-100");
        ZerotoHundred.setFont(new Font("Sans-Serif", Font.BOLD, 20));

        //putting the operator buttons in the operator array
        operators[0] = deleteButton;
        operators[1] = guessButton;
        operators[2] = ZerotoTen;
        operators[3] = ZerotoTwenty;
        operators[4] = ZerotoFifty;
        operators[5] = ZerotoHundred;
        operators[6] = clearButton;

        //for loop that makes the operator buttons usable by the user
        for (int i = 0; i < 7; i++) {
            operators[i].addActionListener(this);
        }

        //setting the positions for the game's buttons
        ZerotoTen.setBounds(50, 150, 100, 50);
        ZerotoTwenty.setBounds(150, 150, 100, 50);
        ZerotoFifty.setBounds(250, 150, 100, 50);
        ZerotoHundred.setBounds(350, 150, 100, 50);
        guessButton.setBounds(300, 300, 100, 50);
        deleteButton.setBounds(100, 300, 100, 50);
        clearButton.setBounds(200, 300, 100, 50);
        
        //adding all of the buttons and fields to the frame and making it visible
        frame.add(title);
        frame.add(textField);
        frame.add(ZerotoTen);
        frame.add(ZerotoTwenty);
        frame.add(ZerotoFifty);
        frame.add(ZerotoHundred);
        frame.add(guessButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.setVisible(true);

    }

    //method that makes the buttons functional
    public void actionPerformed (ActionEvent buttonClicked){

        //deleting the last number in the textField when the delete button is clicked
        if (buttonClicked.getSource() == deleteButton) {
                
            String Nums = textField.getText();
            textField.setText(Nums.substring(0, Nums.length() - 1));
        }

        //clearing the textField when the clear button is clicked
        if (buttonClicked.getSource() == clearButton) {
                
            textField.setText("");
        }

        //if statement for if the zerototen button is clicked
        if (buttonClicked.getSource() == ZerotoTen) {

            //creating a random number from 0-10
            Random rand = new Random();
            numberToGuess = rand.nextInt(11);
            
            //putting a grey border around the the zerototen button and putting a white border around the others
            ZerotoTen.setBackground(Color.GRAY);
            ZerotoTen.setOpaque(true);
            ZerotoTwenty.setBackground(Color.WHITE);
            ZerotoTwenty.setOpaque(true);
            ZerotoFifty.setBackground(Color.WHITE);
            ZerotoFifty.setOpaque(true);
            ZerotoHundred.setBackground(Color.WHITE);
            ZerotoFifty.setOpaque(true);

        }

        //if statement for if the zerototwenty button is clicked
        if (buttonClicked.getSource() == ZerotoTwenty) {

            //creating a random number from 0-20
            Random rand = new Random();
            numberToGuess = rand.nextInt(21);

            //putting a grey border around the the zerototwenty button and putting a white border around the others
            ZerotoTen.setBackground(Color.WHITE);
            ZerotoTen.setOpaque(true);
            ZerotoTwenty.setBackground(Color.GRAY);
            ZerotoTwenty.setOpaque(true);
            ZerotoFifty.setBackground(Color.WHITE);
            ZerotoFifty.setOpaque(true);
            ZerotoHundred.setBackground(Color.WHITE);
            ZerotoHundred.setOpaque(true);

        }

        //if statement for if the zerotofifty button is clicked
        if (buttonClicked.getSource() == ZerotoFifty) {
            
            //creating a random number from 0-50
            Random rand = new Random();
            numberToGuess = rand.nextInt(51);

            //putting a grey border around the zerotofifty button and putting a white border around the others
            ZerotoTen.setBackground(Color.WHITE);
            ZerotoTen.setOpaque(true);
            ZerotoTwenty.setBackground(Color.WHITE);
            ZerotoTwenty.setOpaque(true);
            ZerotoFifty.setBackground(Color.GRAY);
            ZerotoFifty.setOpaque(true);
            ZerotoHundred.setBackground(Color.WHITE);
            ZerotoHundred.setOpaque(true);

        }

        //if statement for if the zerotohundred button is clicked
        if (buttonClicked.getSource() == ZerotoHundred) {

            //creating a random number from 0-100
            Random rand = new Random();
            numberToGuess = rand.nextInt(101);

            //putting a grey border around the zerotohundred button and putting a white border around the others
            ZerotoTen.setBackground(Color.WHITE);
            ZerotoTen.setOpaque(true);
            ZerotoTwenty.setBackground(Color.WHITE);
            ZerotoTwenty.setOpaque(true);
            ZerotoFifty.setBackground(Color.WHITE);
            ZerotoFifty.setOpaque(true);
            ZerotoHundred.setBackground(Color.GRAY);
            ZerotoHundred.setOpaque(true);

        }

        //if statement for if the guessbutton is clicked
        if (buttonClicked.getSource() == guessButton) {

            //set the user's guess as the number that was inputted into the textfield
            numberGuessed = Integer.parseInt(textField.getText());

            //if the user's guess is right, relay a nice message
            if (numberGuessed == numberToGuess) {

                textField.setText("You got it!!");
            
            //if the user's guess is higher than the numbertoguess, tell them their guess is too high
            } else if (numberGuessed > numberToGuess) {

                textField.setText("Too high!!");
            
            //if the user's guess is less than the number to guess, tell them their guess is too low
            } else if (numberGuessed < numberToGuess) {

                textField.setText("Too low!!");
            }

        }

    }
    
    public static void main (String[] args){

        GuessingGame newGame = new GuessingGame();
    }
    
}
