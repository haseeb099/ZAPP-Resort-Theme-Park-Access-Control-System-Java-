 

   
/**
 * A Card has an id number, name, a luxury rating, number of credits and points.
 * 
 * @author Muhammad Haseeb
 * @version 1.1
 */
public class Card 
{
     private int cardId;
    private String guestName;
    private int luxuryRating;
    private int credits;
    private int points;

public Card(int cardId, String guestName, int luxuryRating, int credits) {
    this.cardId = cardId;
    this.guestName = guestName;
    this.luxuryRating = luxuryRating;
    this.credits = credits;
    this.points = 0;
    
    }

public int getCardId() {
    return cardId;
}

public int getLuxuryRating() {
    return luxuryRating;
}

public int getCredits() {
    return credits;
}

public String getGuestName() 
{
    return guestName;
}

public void addCredits(int amount) 
{
    credits -= amount;
}

public boolean hasEnoughCreditsForBridge() 
{
    return credits >= 4;
}

public void useBridge() {
    if (hasEnoughCreditsForBridge()) {
        addCredits(-4); 
        addPoints(1);
    }
}

public void convertPointsToCredits()
{
    int convertedCredits = points / 3;
    credits += convertedCredits;
    points %=3;
}

public void addPoints(int amount)
{
    points += amount;
    
}

public String toString()
{
    String s;
    s = "Card ID : " + cardId +
        "\nGuest Name: " + guestName +
        "\nLuxury Rating: " + luxuryRating +
        "\nNumber of Credits: " + credits +
        "\nNumber of Points: " + points;
    return s;
    


}

    
    
}

