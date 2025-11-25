package cwk3;

 
import java.util.*;

/**This class implements the ZAPP interface
 *
 * @author 
 * @version 
 **/
public class Park implements ZAPP
{
    private String parkName;
    private ArrayList<Area> allAreas = new ArrayList<>();
    private ArrayList<Bridge> allBridges =new ArrayList<>();
    private ArrayList<Card> allCards = new ArrayList<>();

    /** constructor
     */
    public Park(String nme) 
    {
        parkName = nme;
        loadAreas();
        setUpBridges();
        loadCards();
        
        
    }
    
    /**
     * Returns all of the details of the park: its name and its areas 
     * including lists of cards in each area.
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder("Park Name: " + parkName + "\n");
        for (Area area : allAreas) 
        {
            result.append(area.toString()).append("\n");
        }
        return result.toString();
    }
    
    /**Returns a String with details of a card
     * @param cardId - id number of the card
     * @return the details of the card as a String, or "No such card"
     */
    public String getCardDetails(int cardId)
    {
    for (Card card: allCards)
        {
            if (card.getCardId() == cardId) 
            {
                return card.toString();
            } 
        }   
        return "No such card";
    } 
    
    /**Returns the name of the area which contains the specified card or null
     * @param ccd - the specified card
     * @return the name of the Area which contains the card, or null
     **/
    public String getCardLocation(int cd)
    {
        for (Area area : allAreas) 
        {
            if (area.isWithinArea(cd) ) 
            {
                return area.getName();
            }
        }
        return null;
    }
    
    /** Given the name of a area, returns the area id number
     * or -1 if area does not exist
     * @param name of area
     * @return id number of area
     */
    public int getAreaNumber(String ww)
    {
        for (Area area : allAreas) 
        {
            if (area.getName() == ww) 
            {
                return area.getAreaNumber();
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all the cards on specified area
     * @param area is the name of the area 
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInOneArea(String areaName)
    {
       Area area = getArea(areaName);
        if (area != null) 
        {
            return area.listAllCards();
        } 
        else
        {
            return "Area not Found";
        }
    } 

    /**Returns a String representation of all the cards in all areas including the name of each area
     * @return a String representation of all cards on specified area
     **/
    public String getAllCardsInAllAreas()
    {
       StringBuilder result = new StringBuilder();
        for (Area area : allAreas)
        {
            result.append("Area: ").append(area.getName()).append("\n").append(area.listAllCards()).append("\n");
        }
        return result.toString();
    }


    
    /**Returns true if a Card is allowed to move using the bridge, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card on the system
     * AND the bridge code is the code for a bridge on the system
     * @param trId is the id of the card requesting the move
     * @param brCode is the code of the bridge by which the card wants to move
     * @return true if the card is allowed on the bridge journey, false otherwise 
    **/
    public boolean canMove(int trId, String brCode)
    {   
        Card card = getCard(trId);
        Bridge bridge = getBridge(brCode);
           
        if ( card == null || bridge == null)
            {
                return false;
            }
            else 
            {
                return bridge.canEnterBridge(card);
            }
    }     

    /**Returns the result of a card requesting to move over a bridge.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination area
     * AND the destination area is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source area
     * AND the card id is for a card in the system
     * AND the bridge code is the code for a bridge on the system
     * If the bridge crossing can be made, the card information is removed from 
     * the source area, added to the destination area, card details updated and a suitable message returned.
     * a suitable message returned.
     * If bridge journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param brCode is the code of the bridge by which the card wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int pCardId, String brCode )
    {   //other checks optional
        Card card = getCard(pCardId);
        Bridge bridge = getBridge(brCode);

        if (card == null && bridge == null) 
        {
            if (bridge.canEnterBridge(card))
            {
                Area source = bridge.getFromArea();
                Area destination = bridge.getToArea();
                source.leave(card);
                destination.enter(card);
                return "Move successful: " + card.toString() + "move from" + source.getName() + "to" + destination.getName();
            }
            else
            {
            
                return "Move unsucessful: " + bridge.moveCardToDestination(card);
            
            }
        }
        return "Card or bridge not found";
    }     

    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits purchased to be added to cards information
     */
    public void topUpCredits(int id, int creds)
    {
        Card card = getCard(id);
        if (card != null) 
        {
            card.addCredits(creds);
        }
    }
    
    /** Allows a card to convert points to credits
     *  @param cdId the id of the card toping up their credits
     */
    public void convertPoints(int cdId)
    {
        Card card = getCard(cdId);
        if (card != null) 
        {
            card.convertPointsToCredits();
        }
    }
    
    
   
    //***************private methods**************
    private void loadAreas()
    {
        Area area0 = new Area(0, "Lobby", 0, 1000);
        Area area1 = new Area(1, "Concourse", 1, 100);
        Area area2 = new Area(2, "Waterworld", 3, 10);
        Area area3 = new Area(3, "WildWest", 5, 2);
        Area area4 = new Area(4, "Solitaire", 1, 1);
        allAreas.add(area0);
        allAreas.add(area1);
        allAreas.add(area2);
        allAreas.add(area3);
        allAreas.add(area4);
    }
        
    
    private void setUpBridges()
    {
        Area area0 = allAreas.get(0);
        Area area1 = allAreas.get(1);
        Area area2 = allAreas.get(2);
        Area area3 = allAreas.get(3);
        Area area4 = allAreas.get(4);
        Bridge bridge1 = new Bridge("ABC1", area0, area1);
        Bridge bridge2 = new Bridge("BCD2", area1, area0);
        Bridge bridge3 = new Bridge("CDE3", area1, area2);
        Bridge bridge4 = new Bridge("DEF4", area2, area1);
        Bridge bridge8 = new Bridge("JKL8", area2, area3);
        Bridge bridge5 = new Bridge("EFG5", area3, area1);
        Bridge bridge6 = new Bridge("GHJ6", area1, area4);
        Bridge bridge7 = new Bridge("HJK7", area4, area1);
        allBridges.add(bridge1);
        allBridges.add(bridge2);
        allBridges.add(bridge3);
        allBridges.add(bridge4);
        allBridges.add(bridge5);
        allBridges.add(bridge6);
        allBridges.add(bridge7);
    }
    
    private void loadCards()
    {
       Card card1 = new Card(1000, "Lynn", 5, 10);
       Card card2 = new Card(1001, "May", 3, 20);
       Card card3 = new Card(1002, "Nils", 10, 20);
       Card card4 = new Card(1003, "Olek", 2, 12);
       Card card5 = new Card(1004, "Pan", 3, 4);
       Card card6 = new Card(1005, "Quin", 1, 5);
       Card card7 = new Card(1006, "Raj", 10, 6);
       Card card8 = new Card(1007, "Sol", 7, 20);
       Card card9 = new Card(1008, "Tel", 6, 24);
       Card card10 = new TouristCard(2, "Guest2", 3, 15, "TourOperator1", 123);
       Card card11 = new ChildCard(3, "ChildGuest", 1);
       Card card12 = new CompanyCard(4, "CompanyGuest", 5, "Company1");
       allCards.add(card1);
       allCards.add(card2);
       allCards.add(card3);
       allCards.add(card4);
       allCards.add(card5);
       allCards.add(card6);
       allCards.add(card7);
       allCards.add(card8);
       allCards.add(card9);
       allCards.add(card10);
       allCards.add(card11);
       allCards.add(card12);
    }
 
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
    private Card getCard(int id)
    {
        for (Card card : allCards) 
        {
            if (card.getCardId() == id) 
            {
                return card;
            }
        }
        return null;
    }
    
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Area getArea(String areaName)
    {
        for (Area area : allAreas) {
            if (area.getName().equals(areaName))
            {
                return area;
            }
        }
        return null;
    }
    
    /** Returns the area with the name specified by the parameter
     * @return the area with the specified name
     **/
    private Bridge getBridge(String br)
    {
        for (Bridge bridge : allBridges) {
            if (bridge.getCode().equals(br)) {
                return bridge;
            }
        }
        return null;
    }
    
    
}