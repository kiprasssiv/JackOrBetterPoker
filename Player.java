import java.util.ArrayList;

public class Player {
    private static int score;
    private static ArrayList<String> playerHand = new ArrayList<String>();
    public Player() {
        score = 0;
    }
    public void setPlayerHand(String card) {

       this.playerHand.add(card);
    }
    public ArrayList<String> getPlayerHand() {
        return playerHand;
    }
    public void Veikia(){
        System.out.println("VEIKIA");
    }
    public void setScore(int score) {
        Player.score += score;
    }
    public static int getScore() {
        return score;
    }


}
