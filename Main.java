import java.util.Scanner;
public class Main {
    public static void main(String [] args) {
        Game game = new Game();
        Scanner input = new Scanner(System.in);
        boolean isPlaying = true;
        String answer;  // Read user input
        while(isPlaying){
            game.session();
            System.out.println("Do you want to play again? Yes/No");
            answer = input.nextLine();  // Read user input
            if(answer.equals("Yes"));
            else if(answer.equals("No"))
                break;
            else{
                while(true) {
                    System.out.println("The answer has to be Yes or No");
                    answer = input.nextLine();  // Read user input
                    if(answer.equals("Yes")){
                        break;
                    }
                    if(answer.equals("No")) {
                        isPlaying = false;
                        break;
                    }
                }
            }
        }
        System.out.println("Thank you for playing");

    }
}
