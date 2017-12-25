import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/**
 * The class of game for guessing the movie
 * @author dizhang
 * @version 1.0
 */
public class Game {
    private ArrayList<String> movies;
    private String guess_movie;
    private boolean win=false;
    private int[] index;
    private int guess_index;
    private String wrong_letter="";

    /**
     * The construction of game for guessing the movie
     * Read movie from txt and generate list
     * Then generate a guess index
     */
    Game(){
        try {
            movies = new ArrayList<String>();
            this.readMovie();
            this.generateGuess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Read movie from txt and generate list
     * @throws java.io.FileNotFoundException
     * if we can not read the file
     */
    public void readMovie() throws Exception{
        File file = new File("/Users/zhangdi/java_practice/GuessGame/src/movies.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()){
            String Line=fileScanner.nextLine();
            movies.add(Line);
        }
    }

    /**
     * Print the list of movies
     */
    public void printMovieList(){
        for(int i=0;i<movies.size();i++){
            System.out.println(i+"."+movies.get(i));
        }
    }

    /**
     * Generate a guess index
     */
    public void generateGuess(){
        Random generator = new Random();
        guess_index = generator.nextInt(movies.size());
        guess_movie=movies.get(guess_index).toLowerCase();
        //System.out.println(guess_movie);
        index=new int[guess_movie.length()];
        for(int i=0;i<index.length;i++){
            index[i]=0;
        }
    }

    /**
     * get the movie we want to guess
     * @return movies.get(guess_index)
     * string of the name of the movie
     */
    public String getGuessMovie(){
        return movies.get(guess_index);
    }

    /**
     * output the right letter in the movie according to the guess
     * @param guess
     * the letter you guess in the movie
     * @return result
     * the result after the guess
     */
    public String GuessMovie(char guess){

        String result="";
        String right_movie=movies.get(guess_index);
        int find=guess_movie.indexOf(guess,0);
        if (find==-1 && !(guess=='_')){
            wrong_letter+=guess;
        }
        while (!(find==-1)){
            index[find]=1;
            find=guess_movie.indexOf(guess,find+1);
        }
        //
        win=true;
        char symbol=' ';
        for(int i=0;i<guess_movie.length();i++){
            if (index[i]==1 || (symbol==guess_movie.charAt(i))){
                result+=right_movie.charAt(i);
            }else {
                win=false;
                result+='_';
            }
        }
        return result;
    }
    /**
     * Get the String of wrong letters
     * if more than one wrong letters, add space between them
     * @return wrong_letter or delimited_output
     * String of wrong letters
     */
    public String getWrongLetter(){
        if (wrong_letter.length()<=1) {

            return wrong_letter;
        }else{
            //return the form with space
            String delimited_output ="";
            delimited_output+=wrong_letter.charAt(0);
            for(int i=1;i<wrong_letter.length();i++){
                delimited_output+=' ';
                delimited_output+=wrong_letter.charAt(i);
            }
            return delimited_output;
        }
    }

    /**
     * get the number of wrong letters
     * @return wrong_letter.length()
     * length of the wrong letters
     */
    public int getWrongLetterNumber(){
        return wrong_letter.length();
    }
    /**
     * judge the status of game
     * @return win
     * whether the player wins
     */
    public boolean winStatus(){
        return win;
    }
}
