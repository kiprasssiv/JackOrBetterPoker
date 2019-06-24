import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class ResultCheck {
    private static int diamonds = 0;
    private static int spades = 0;
    private static int hearts = 0;
    private static int clubs = 0;
    static boolean jackOrBetter = false;
    private static int amountS[] = new int[13]; //amount of different card powers
    public boolean RoyalFlush(ArrayList<String> cardsOnTheTable) {
        jackOrBetter = false;
        String card = new String();
        diamonds = 0;
        spades = 0;
        hearts = 0;
        clubs = 0;
        for(int i = 0; i < 13; i++)
            amountS[i] = 0;
        for(int i = 0; i < cardsOnTheTable.size(); i++){
            card = cardsOnTheTable.get(i);
            if(card.contains("1") || card.contains("J") || card.contains("Q") || card.contains("K") || card.contains("A")){
                jackOrBetter = true;
                if(card.contains("D")){
                    diamonds++;
                }
                if(card.contains("S")){
                    spades++;
                }
                if(card.contains("H")){
                    hearts++;
                }
                if(card.contains("C")){
                    clubs++;
                }
            }
        }
        if(diamonds == 5 || spades == 5 || hearts == 5 || clubs == 5)
            return true;
        else
            return false;
    }
    public boolean StraightFlush(ArrayList<String> cardsOnTheTable) {
        String card = new String();
        boolean isStraightFlush = false;
        diamonds = 0;
        spades = 0;
        hearts = 0;
        clubs = 0;
        System.out.println(cardsOnTheTable);
        for(int i = 0; i < cardsOnTheTable.size(); i++){
            card = cardsOnTheTable.get(i);
            if(card.contains("D")){
                diamonds++;
            }
            if(card.contains("S")){
                spades++;
            }
            if(card.contains("H")){
                hearts++;
            }
            if(card.contains("C")){
                clubs++;
            }
        }
        if(diamonds < 5 && spades < 5 && hearts < 5 && clubs < 5)
            return false;
        int startOfTheSign = -1;
        int endOfTheSign = -1;
        //Serching for a straight flush among diamonds
        if(diamonds >= 5){
            for(int i = 0; i < 7;i++){
                if(cardsOnTheTable.get(i).contains("D") && startOfTheSign == -1)
                    startOfTheSign = i;
                if(!cardsOnTheTable.get(i).contains("D") && startOfTheSign != -1){
                    endOfTheSign = i;
                    break;
                }
            }
            String begin = cardsOnTheTable.get(startOfTheSign).replaceAll("D","");
            String end = cardsOnTheTable.get(endOfTheSign).replaceAll("D","");
            if(Integer.valueOf(end) - Integer.valueOf(begin) == 4)
                isStraightFlush = true;
        }
        //Serching for a straight flush among spades
        if(spades >= 5){
            for(int i = 0; i < 7;i++){
                if(cardsOnTheTable.get(i).contains("S") && startOfTheSign == -1)
                    startOfTheSign = i;
                if(!cardsOnTheTable.get(i).contains("S") && startOfTheSign != -1){
                    endOfTheSign = i;
                    break;
                }
            }
            String begin = cardsOnTheTable.get(startOfTheSign).replaceAll("S","");
            String end = cardsOnTheTable.get(endOfTheSign).replaceAll("S","");
            if(Integer.valueOf(end) - Integer.valueOf(begin) == 4)
                isStraightFlush = true;
        }
        //Serching for a straight flush among hearts
        if(hearts >= 5){
            for(int i = 0; i < 7;i++){
                if(cardsOnTheTable.get(i).contains("H") && startOfTheSign == -1)
                    startOfTheSign = i;
                if(!cardsOnTheTable.get(i).contains("H") && startOfTheSign != -1){
                    endOfTheSign = i;
                    break;
                }
            }
            String begin = cardsOnTheTable.get(startOfTheSign).replaceAll("H","");
            String end = cardsOnTheTable.get(endOfTheSign).replaceAll("H","");
            if(Integer.valueOf(end) - Integer.valueOf(begin) == 4)
                isStraightFlush = true;
        }
        //Serching for a straight flush among clubs
        if(clubs >= 5){
            for(int i = 0; i < 7;i++){
                if(cardsOnTheTable.get(i).contains("C") && startOfTheSign == -1)
                    startOfTheSign = i;
                if(!cardsOnTheTable.get(i).contains("C") && startOfTheSign != -1){
                    endOfTheSign = i;
                    break;
                }
            }
            String begin = cardsOnTheTable.get(startOfTheSign).replaceAll("C","");
            String end = cardsOnTheTable.get(endOfTheSign).replaceAll("C","");
            if(Integer.valueOf(end) - Integer.valueOf(begin) == 4)
                isStraightFlush = true;
        }
        if(isStraightFlush)
            return true;
        else
            return false;
    }
    public boolean FourOfAKind(ArrayList<String> cardsOnTheTable) {
        String card = new String();
        for(int i = 0; i < cardsOnTheTable.size(); i++){
            card = cardsOnTheTable.get(i);
            if(card.contains("2")){
                amountS[0]++;
            }
            if(card.contains("3")){
                amountS[1]++;
            }
            if(card.contains("4")){
                amountS[2]++;
            }
            if(card.contains("5")){
                amountS[3]++;
            }
            if(card.contains("6")){
                amountS[4]++;
            }
            if(card.contains("7")){
                amountS[5]++;
            }
            if(card.contains("8")){
                amountS[6]++;
            }
            if(card.contains("9")){
                amountS[7]++;
            }
            if(card.contains("A")){
                amountS[8]++;
            }
            if(card.contains("B")){
                amountS[9]++;
            }
            if(card.contains("C")){
                amountS[10]++;
            }
            if(card.contains("D")){
                amountS[11]++;
            }
            if(card.contains("E")){
                amountS[12]++;
            }
        }
        Arrays.sort(amountS);
        if(amountS[12]>=4)
            return true;
        else
            return false;

    }
    public boolean FullHouse() {
        boolean threeOnes = false;
        boolean pair = false;
        for(int i = 12; i > 0; i--)
        {
            if(amountS[i] == 3)
                threeOnes = true;
            if(amountS[i] == 2 && threeOnes)
            {
                pair = true;
                break;
            }
        }
        if(pair)
            return true;
        else
            return false;
    }
    public boolean Flush() {
        if(diamonds < 5 && spades < 5 && hearts < 5 && clubs < 5)
            return false;
        else
            return true;
    }
    public boolean ThreeOfAKind() {
        if(amountS[12]>=3)
            return true;
        else
            return false;
    }
    public boolean Straight(ArrayList<String> cardsOnTheTable) {
        int whereToStart = 6;
        int powerDifference = 0;
        int cardPower[] = new int[7];
        String cutString = new String();
        for(int i = 0 ; i < 7; i++)
        {
            if(cardsOnTheTable.get(i).contains("C")){
                cutString = cardsOnTheTable.get(i).replaceAll("C","");
                cardPower[i] = Integer.valueOf(cutString);
            }
            if(cardsOnTheTable.get(i).contains("D")){
                cutString = cardsOnTheTable.get(i).replaceAll("D","");
                cardPower[i] = Integer.valueOf(cutString);
            }
            if(cardsOnTheTable.get(i).contains("H")){
                cutString = cardsOnTheTable.get(i).replaceAll("H","");
                cardPower[i] = Integer.valueOf(cutString);
            }
            if(cardsOnTheTable.get(i).contains("S")){
                cutString = cardsOnTheTable.get(i).replaceAll("S","");
                cardPower[i] = Integer.valueOf(cutString);
            }
        }
        Arrays.sort(cardPower);
        for(int i = 6; i > 0; i--){
            for(int h = i-1; h > 0 ; h--){
                if(cardPower[i] - cardPower[h] == 1)
                {
                    powerDifference++;
                }
                if(cardPower[i] - cardPower[h] == 0)
                    ;
                else{
                    powerDifference = 0;
                    whereToStart--;
                    i = whereToStart;
                }
            }
        }
        if(powerDifference >= 5)
            return true;
        else
            return false;
    }
    public boolean TwoPair() {
        int counter = 0;
        for(int i = 12; i > 0; i--)
        {
            if(amountS[i] == 2)
                counter++;
            if(counter == 2)
                break;
        }
        if(counter >= 2)
            return true;
        else
            return false;
    }
    public boolean JackOrBetter() {
        if(jackOrBetter)
            return true;
        else
            return false;
    }
}
