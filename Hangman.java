package Programming_Examples102.Hangman;

import java.util.ArrayList;
class Hangman {
    private ArrayList<String> usedLetters = new ArrayList<String>();
    private String wordHypen;
    private String question;
    private int remainingRights = 6;
    private int numberOfWrongAnswers;
    private String newWord;
    
  

//second part
//since I want to create new String which contains "-" i will create new method and create it from there.
//BahadirGunenc 22003672
public Hangman(String question){
    this.question = question;
    wordHypen = lineString(question);
}
private String lineString(String word){
    String newWord= "";
    for(int i = 0 ; i < word.length();i++){
        if(Character.toString(word.charAt(i)).equals(" ")){
            newWord = newWord + " ";
        }
        else{
            
            newWord = newWord + "-";
        }
    }
    this.newWord = newWord; //ben ekledim
    return newWord;
}



     //@author Konuralp Kılınç 22101791//
    //Hangman class' codes//
    //initializing the array list that holds the input of the player//
    
    //this method lets the game check if the input of the player is already used or not and changes some essential elements//
    public void tryThis(String newLetter){
        //we use this if statement to prevent the bug that will occur when the helperMethodForTryThis try to compare null arrayList elements with newLetter// 
        

        if(usedLetters.size()==0){
            usedLetters.add(newLetter);
            return;
        }
        //if the player tried this letter already the code will force them to try another one//
        if(helperMethodForTryThis(newLetter)){
            System.out.println("You have already used this letter. Try something else.");
        }
        /*if the player pass the barrier of their mind and try another letter than they tried before the code will immediately add the new word to the arrayList
            and check if the letter is found in the word**/
        else {
            usedLetters.add(newLetter);
            /*when the letter is found in the word the for loop will do the same thing my friend Emir did and check where is the letter at in the string of the word
                (it may be a duplicate sry for that) and replace the underscore or hypen with the letter which the player input and congrulates the player**/
            if(this.isAnyLetterFound()){
                for(int searcher = 0; searcher<usedLetters.size(); searcher++){
                    if(this.wordHypen.substring(searcher,searcher+1).equals(newLetter)){
                        newWord = newWord.substring(0,searcher) + newLetter + newWord.substring(searcher+1 , newWord.length());
                    }
                }
                
                System.out.println("Wow you found the letter(s) in the word");
            }
            /*when the letter is not found in the word the else statement will decrease the remainingRights of the player and lets the player to know that is not because 
                that he/she is bad but it is happen because of the unlucky situation**/
            else {
                remainingRights--;
                
                System.out.println("Unlucky");
            }
        }
    }
    //this method helps the tryThis method to check whether the letter is included in the arrayList or not//
    public boolean helperMethodForTryThis(String newLetter){
        for(int searcher = 0; searcher<usedLetters.size(); searcher++){
            if(usedLetters.get(searcher).equals(newLetter)){
                return true;
            }
        }
        return false;
    }
    //this method helps my friend Burak with his while loop in the main class by checking the remaining right(s) and is the word found or not//
    public boolean isGamefinished(){
        if(remainingRights==0){
            return true;
        }
        if(isWordFound()){
            return true;
        }
        return false;
    }
    // Emir Tuglu 22003165
    // Include into Hangman class
    
    private boolean isWordFound() {
        return (this.wordHypen).equals(this.question);
    }
    public String getWordHyphen() {
        return this.wordHypen;
    }

    public int getNumberOfWrongAnswers() {
        return this.numberOfWrongAnswers;
    }

    public void printTriedLetters() {
        boolean first = true;
        System.out.print("Tried Letters: ");
        Character[] triedLetters = (Character[])usedLetters.toArray();
        for (Character letter : triedLetters) {
            if (!first) {
                System.out.print(", "); // Putting a comma before each element except the 1st element.
            }
            else {
                first = false;
            }
            System.out.print(Character.toUpperCase(letter));
        }
    }

    public boolean isAnyLetterFound() {
        for (int i = 0; i < this.wordHypen.length(); i++) {
            if (this.wordHypen.charAt(i) != '-') {
                return true;
            }
        }
        return false;
    }
    public String getQuestion(){
        return this.question;
    }
    //@author Yiğit Yayla 22003108
//This method receives numberOfWrongAnswers and prints the hangman scheme accordingly
    //USER CAN MAKE MAXIMUM 6 WRONG ANSWERS
    //INCLUDE INTO THE HANGMAN CLASS
    public void printMan(){
        int numberOfWrongAnswers = 6 - remainingRights;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 8; j++){
                if(i == 0){
                    if(j <= 4 && j >= 2){
                        System.out.print("_");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(i == 1){
                    if(j == 2 || j == 5){
                         System.out.print("|");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(i == 2){
                    if(j == 2){
                         if( numberOfWrongAnswers >= 1){
                             System.out.print("O"); //Head
                         }
                         else{
                             System.out.print(" ");
                         }   
                    }
                   
                    else if(j == 5){
                        System.out.print("|");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(i == 3){
                    if(j == 1){
                         if(numberOfWrongAnswers >= 3){
                             System.out.print("/"); //left arm
                         }
                         else{
                             System.out.print(" ");
                         }
                    }
                    else if(j == 2){
                         if(numberOfWrongAnswers >= 2){
                             System.out.print("|"); //torso part1
                         }
                         else{
                             System.out.print(" ");
                         }
                    }
                    else if(j == 3){
                         if(numberOfWrongAnswers >= 4){
                             System.out.print("\\"); //right arm
                         }
                         else{
                             System.out.print(" ");
                         }
                    }
                    else if(j == 5){
                     System.out.print("|"); // print stick
                    }   
                    else{
                        System.out.print(" ");
                    }
                }
                else if( i == 4){
                    if(j == 2){
                       if(numberOfWrongAnswers >= 2){
                           System.out.print("|"); //torso part2
                       }
                       else{
                           System.out.print(" ");
                       }   
                    }
                     else if( j == 5){
                         System.out.print("|");
                     }
                     else{
                         System.out.print(" ");
                     }
                }
                else if(i == 5){
                    if(j == 1){
                     if(numberOfWrongAnswers >= 5){
                         System.out.print("/"); //left leg
                     }
                     else{
                         System.out.print(" ");
                     }
                    }
                     else if(j == 3){
                         if(numberOfWrongAnswers >= 6){
                             System.out.print("\\"); //right leg
                         }
                         else{
                             System.out.print(" ");
                         }
                     }
 
                     
                     if(j == 5){
                         System.out.print("|"); // print stick
                     }
                     else if( j != 5 && j != 3 && j != 1){
                         System.out.print(" ");
                     }
                       
                }
                else if(i == 6){
                   if(j == 5){
                     System.out.print("|"); // print stick
                    }
                    else{
                        System.out.print(" ");
                    }   
                }
            }
            System.out.println();
        }
        System.out.println("--------");
     }
    public String getScoredWord() {
        return newWord;
    }
    public int getRemainingTries() {
        return remainingRights;
    }
    public ArrayList<String> getUsedLetters(){
        ArrayList<String> value = (ArrayList<String>)(this.usedLetters.clone());
        return value;
    }
}

