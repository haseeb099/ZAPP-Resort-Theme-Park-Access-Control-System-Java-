import java.util.*;
/**
 * A Area is part of a ZAPP resort.Each area has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * area at any one time. Each area must maintain a list of all people (cards)
 * currently on the area. These lists are updated whenever cards enter or leave 
 * an area,so that it is always possible to say how many people (cards) are in the area 
 * and who they are.
 * 
 * @author Muhammad Haseeb
 * @version 1.1
 */

public class Area 
{
   private int areaNumber;
    private String name;
    private int luxuryRating;
    private int capacity;
    private ArrayList<Card> cardsInArea;

public Area(int areaNumber, String name, int luxuryRating, int capacity)
{
    this.areaNumber = areaNumber;
    this.name = name;
    this.luxuryRating = luxuryRating;
    this.capacity = capacity;
    this.cardsInArea = new ArrayList<Card>();
}

public int getAreaNumber()
{
    return areaNumber;
}

public String getName()
{
    return name;
}

public int getLuxuryRating()
{
    return luxuryRating;
}

public int getCapacity()
{
    return capacity;
}

public int noOfCards()
{
    return cardsInArea.size();
}

public void enter(Card card)
{
    cardsInArea.add(card);
}

public void leave(Card card)
{
    cardsInArea.remove(card);
}

public boolean isFull()
{
    if (cardsInArea.size() >= capacity)
    {
    return true;
    }
    else
    {
    return false;
    }
}

public String listAllCards()
{
    String ss = "";
    if (cardsInArea.size() > 0)
    {
        for (Card card : cardsInArea)
        {
            ss = ss + "\n" + card.toString();
        }
        return ss + "\n********************";
    }
    return "\nNO Card" + "\n********************";
}

public Card findDetailsOfCard(int cardId)
{
    for (int indx = 0; indx<cardsInArea.size(); indx++)
    {
        Card card = cardsInArea.get(indx);
        if (card.getCardId() == cardId);
        {
        return card;
        }
    }
    return null;
}

public boolean isWithinArea(int cardId)
{
    for (int indx = 0; indx<cardsInArea.size(); indx++)
    {
        Card card = cardsInArea.get(indx);
        if (card.getCardId() == cardId)
        {
            return true;
        }
    }
    return false;
}

public String toString()
{
    return ("\n" + areaNumber + " " + name
                 + "\nLuxury Rating: " + luxuryRating
                 + "\nCapacity: " +capacity
                 + "\n****Card List****" + cardsInArea.size()); 
}
    
}
