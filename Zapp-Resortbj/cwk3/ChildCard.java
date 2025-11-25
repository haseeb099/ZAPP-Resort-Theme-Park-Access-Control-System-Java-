package cwk3;


/**
 * Write a description of class ChildCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChildCard extends Card 
{

    private int parentCardNumber;
    private int zonesVisited;

    public ChildCard(int cardId, String guestName, int parentCardNumber) 
    {
        super(cardId, guestName, 10, 0);
        this.parentCardNumber = parentCardNumber;
        this.zonesVisited = 0;
    }

    public int getParentCardNumber() 
    {
        return parentCardNumber;
    }

    public int getZonesVisited() 
    {
        return zonesVisited;
    }
}
