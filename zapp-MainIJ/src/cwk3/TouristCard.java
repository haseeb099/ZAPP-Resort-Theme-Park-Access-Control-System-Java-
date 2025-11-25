package cwk3;


/**
 * Write a description of class TouristCard here.
 *
 * @author Muhammad Haseeb
 * @version 1.1
 */
public class TouristCard extends Card 
{

    private String tourOperatorName;
    private int operatorId;

    public TouristCard(int cardId, String guestName, int luxuryRating, int credits, String tourOperatorName, int operatorId) 
    {
        super(cardId, guestName, luxuryRating, credits);
        this.tourOperatorName = tourOperatorName;
        this.operatorId = operatorId;
    }

    public String getTourOperatorName() {
        return tourOperatorName;
    }

    public int getOperatorId() {
        return operatorId;
    }

    @Override
    public String toString() 
    {
        return super.toString() +
               "\nTour Operator Name: " + tourOperatorName +
               "\nOperator ID: " + operatorId;
    }
}
