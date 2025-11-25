package cwk3;

 

  
/**
 * A bridge provides a one-way connection between two areas. It
 has a bridge code and information about both the source and
 the destination area
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bridge
{
    private String code;
    private Area fromArea;
    private Area toArea;
    
    public Bridge (String code, Area fromArea, Area toArea)
    {
        this.code = code;
        this.fromArea = fromArea;
        this.toArea = toArea;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public Area getFromArea()
    {
        return fromArea;
    }
    
    public Area getToArea()
    {
        return toArea;
    }
    
    
    public boolean canEnterBridge(Card card)
    {
        int cardId = card.getCardId();
        if (fromArea.isWithinArea(cardId) && card.getLuxuryRating() < toArea.getLuxuryRating() && toArea.isFull() && !card.hasEnoughCreditsForBridge() && card == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String moveCardToDestination(Card card)
    {
        int cardId = card.getCardId();
        if (fromArea.isWithinArea(cardId))
        {
            return "Card is not in the source area for the bridge.";
        }
        else if (card.getLuxuryRating() < toArea.getLuxuryRating())
        {
            return "Luxury rating is lower than the rating of the destination area.";
        }
        
        else if (toArea.isFull())
        {
            return "Destination area has reached its maximum capacity.";
        }
        
        else if (!card.hasEnoughCreditsForBridge())
        {
            return "Card does not have enough credits for the crossing.";
        }
        
        else if (card == null)
        {
            return "Invalid card.";
        }
        
        else
        {
            toArea.enter(card);
            fromArea.leave(card);
            return "Card " + cardId + "added to Area " + toArea.getName();
        }
    }
    
    public String toString()
    {
        return "Bridge Code: " + code +
               "\nFrom Area: " + fromArea.getAreaNumber() + " - " + fromArea.getName() +
               "\nTo Area: " + toArea.getAreaNumber() + " - " + toArea.getName();
    }
}
