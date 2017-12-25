import java.util.Scanner;

public class GuessGame {
    public static void main(String [] args) throws Exception {
        Game game= new Game();
        String result=game.GuessMovie('_');
        int valid_start= (int) 'a';
        int valid_end= (int) 'z';
        Scanner scanner = new Scanner(System.in);

        //game.printMovieList();
        System.out.println("You are guessing:"+result);
        System.out.println(("").length());
        System.out.println("You have (0) wrong letter:");
        for(int i=0;i<26;i++){
            System.out.println("Guess a letter:");
            String input=scanner.nextLine();
            char guess=input.charAt(0);

            //check if the input is not valid
            if (input.length()>1 || ! ((int) guess >=valid_start) || ! ((int) guess <=valid_end) ){
                System.out.println("Invalid input,");
            }else {
                result = game.GuessMovie(input.charAt(0));

                //check if the player win the game
                if(game.winStatus()){
                    System.out.println("You win!");
                    System.out.println("You have guessed '"+game.getGuessMovie()+"' correctly.");
                    break;
                }
                else{
                    System.out.println("You are guessing "+result);
                }
            }
            if (game.getWrongLetterNumber()==0) {
                System.out.println("You have (" + game.getWrongLetterNumber() + ") wrong letter:");
            }else {
                System.out.println("You have (" + game.getWrongLetterNumber() + ") wrong letter:"+game.getWrongLetter());
            }
        }
        if(! game.winStatus()){
            System.out.println("You lose!");
            System.out.println("The Movie is '"+game.getGuessMovie()+"'.");
        }
    }
}
