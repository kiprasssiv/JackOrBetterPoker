import java.util.*;

public class Game {
    private Random rand = new Random();
    private Scanner input = new Scanner(System.in);
    private Player player = new Player();
    private ResultCheck checker = new ResultCheck();
    private static ArrayList<String> deck = new ArrayList<String>();
    private static ArrayList<String> tableCards = new ArrayList<String>();
    private static ArrayList<String> totalSet = new ArrayList<String>();
    private String[] hearts = {"H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK", "HA"};
    private String[] spades = {"S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK", "SA"};
    private String[] clubs = {"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK", "CA"};
    private String[] diamonds = {"D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK", "DA"};
    private String answers;
    private ArrayList<String> playersHand = new ArrayList<String>();
    private int deletedCardNumber;
    int playerCard;
    int tableCardFromDeck;
    private static int cardAmount = 54;
    private void setDeck() {

        deck.addAll(Arrays.asList(hearts)); //setting everything up
        deck.addAll(Arrays.asList(spades));
        deck.addAll(Arrays.asList(clubs));
        deck.addAll(Arrays.asList(diamonds));
        tableCards.clear();
        playersHand.clear();
        totalSet.clear();
    }
    public void session(){

        System.out.println("WELCOME TO THE POKER GAME");
        setDeck();
        for(int i = 0; i < 2; i++){                         //player cards
            playerCard = rand.nextInt(deck.size());
            player.setPlayerHand(deck.get(playerCard));
            deck.remove(playerCard);
            cardAmount--;
        }
        for(int i = 0; i < 5; i++) {                        //cards that are put on the table
            tableCardFromDeck = rand.nextInt(deck.size());
            tableCards.add(deck.get(tableCardFromDeck));
            deck.remove(tableCardFromDeck);
            cardAmount--;
        }
        System.out.println("Cards on the table: ");
        printingCards();
        while(true){                                                    //player's ability to change the cards
            System.out.println("Do you want to change cards? Yes/No");
            answers = input.nextLine();  // Read user input
            if(answers.equals("Yes"))
            {
                while(true) {
                    System.out.println("Enter the number of the card you want to replace"); //waiting until the end of the input
                    printingCards();
                    answers = input.nextLine();
                    deletedCardNumber = Integer.valueOf(answers);
                    if (deletedCardNumber < 6 && deletedCardNumber > 0) {
                        tableCards.remove(deletedCardNumber-1);
                        tableCardFromDeck = rand.nextInt(deck.size());
                        tableCards.add(deck.get(tableCardFromDeck));
                        deck.remove(tableCardFromDeck);
                        cardAmount--;
                        break;
                    }
                    else
                        System.out.println("Wrong input");
                    if(cardAmount == 0)
                        break;
                }
            }
            else if(answers.equals("No"))
                break;
            else
                System.out.println("Wrong input, it has to be: Yes or No");
            if(cardAmount == 0)
                break;

        }
        playersHand = player.getPlayerHand();
        System.out.println("Your cards: " + playersHand.get(0) + " " + playersHand.get(1));
        totalSet.addAll(playersHand); //all table cards
        totalSet.addAll(tableCards);
        Collections.sort(totalSet);
        if(checker.RoyalFlush(totalSet))
        {
            player.setScore(800);
            System.out.println("YOU HAVE A ROYAL FLUSH");
            return;
        }
        if(checker.FourOfAKind(totalSet))
        {
            player.setScore(25);
            System.out.println("YOU HAVE A FOUR OF A KIND");
            return;
        }
        changePower();
        if(checker.StraightFlush(totalSet))
        {
            player.setScore(50);
            System.out.println("YOU HAVE A STRAIGHT FLUSH");
            return;
        }

        if(checker.FullHouse())
        {
            player.setScore(9);
            System.out.println("YOU HAVE A FULL HOUSE");
            return;
        }
        if(checker.Flush())
        {
            player.setScore(6);
            System.out.println("YOU HAVE A FLUSH");
            return;
        }
        if(checker.Straight(totalSet))
        {
            player.setScore(4);
            System.out.println("YOU HAVE A STRAIGHT");
            return;
        }
        if(checker.ThreeOfAKind())
        {
            player.setScore(3);
            System.out.println("YOU HAVE A THREE OF A KIND");
            return;
        }
        if(checker.TwoPair())
        {
            player.setScore(2);
            System.out.println("YOU HAVE A TWO PAIR");
            return;
        }
        if(checker.JackOrBetter())
        {
            player.setScore(1);
            System.out.println("YOU HAVE A JACK OR BETTER");
            return;
        }
        System.out.println("Your score: " + player.getScore());
    }
    private void changePower(){
        for(int i = 0; i<totalSet.size(); i++) //preparing array for counting
        {
            if(totalSet.get(i).contains("J")) {
                String newS = totalSet.get(i).replaceAll("J","11");
                totalSet.set(i,newS);
            }
            else if(totalSet.get(i).contains("Q")) {
                String newS = totalSet.get(i).replaceAll("Q","12");
                totalSet.set(i,newS);
            }
            else if(totalSet.get(i).contains("K")) {
                String newS = totalSet.get(i).replaceAll("K","13");
                totalSet.set(i,newS);
            }
            else if(totalSet.get(i).contains("A")) {
            String newS = totalSet.get(i).replaceAll("A","14");
            totalSet.set(i,newS);
        }
        }
    }
private void printingCards()
{
    System.out.println("1." + tableCards.get(0) + " " + "2." + tableCards.get(1) + " " + "3." + tableCards.get(2) + " " +
            "4." + tableCards.get(3) + " " + "5." + tableCards.get(4));
}
}
