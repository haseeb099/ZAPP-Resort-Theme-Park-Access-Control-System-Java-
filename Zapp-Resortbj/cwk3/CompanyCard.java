package cwk3;


/**
 * Write a description of class CompanyCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompanyCard extends Card
{

    private String organizationName;

    public CompanyCard(int cardId, String guestName, int luxuryRating,
                       String organizationName) {
        super(cardId, guestName, luxuryRating, 30); 
        this.organizationName = organizationName;
    }

    public String getOrganizationName() 
    {
        return organizationName;
    }

    @Override
    public void useBridge() 
    {
        super.useBridge();
        addCredits(-4);
        addPoints(2);
    }

    @Override
    public String toString() 
    {
        return super.toString() +
               "\nOrganization Name: " + organizationName;
    }
}