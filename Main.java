package Programming_Examples102.Hangman;

import java.util.Scanner;

/**
 * this code provides a simple game of hangman with the help of a Hangman class and a dictionary
 * 06.02.2022
 * @author Burak Oruk
 * combined by Musa Yiğit Yayla
 */

public class Main {

    public static void main(String[] args) {

        String[] words = new String[]{"glasses","textbook","printer","mask","computer","knife", "software", "goalkeeper","striker", 
"actress","basketball","author","programmer","garbage", "developer","science","trousers","paper","novel","watch","suspension",
"midfielder","afternoon","midnight","singer","battery","course","language","mathematics","graduate","academician","workload",
"creativity","hardworking","screen","keyboard","input"};
    int selected =(int)(Math.random()*words.length);
    boolean finish = false;
    String question = words[selected];
    Hangman game = new Hangman(question);
        
        // arrays containing the word depositery will be placed here

        String chosenWord = words[(int)(Math.random() * words.length)];  // a random word from the array at the line 13 will be randomly chosen and initialized

        Hangman hangman = new Hangman(chosenWord);  // an object of Hangman has been initialized with the chosen word

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println( 

                "Your word: " + 
                hangman.getScoredWord() // print the a version of the word that is modified with "-" to hide unfounded words 
                + "\n" + 
                "Used Letters: " +
                hangman.getUsedLetters() // print all the letters that been tried
                + "\n" + 
                "Number of your remaining tries: " +
                hangman.getRemainingTries() // remainig tries out of total (6 by default)

            );
            
            hangman.printMan(  ); // prints the current state of the "man" depending on the number of wrong guesses

            String letter = scanner.next().charAt(0) + ""; // taking a guess from the user
            hangman.tryThis(letter); // passing this letter to the Hangman

        } while ( ! ( hangman.isGamefinished() ) ); // checking if the game is finished or not by any means
        
        scanner.close(); // closing the scanner, obviously

        //finalizing the game and informing the user
        
        if ( hangman.isGamefinished() ){
            System.out.println( "Congratulations, you have found the secret word with great success!"); // "clap clap"
        }
        else {
            if ( hangman.isAnyLetterFound() ) {
                System.out.println( "Was this the word you're looking for: " + hangman.getQuestion() );
            }
            else {
                System.out.println( "You couldn't manage to find any hidden letter. Good luck next time!" );
            }
            hangman.printMan();
        }
        
    }
}
