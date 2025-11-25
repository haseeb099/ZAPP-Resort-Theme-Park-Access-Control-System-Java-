package cwk3;

 

  
/**
 * Write a description of class CardTester here.
 *
 * @author Muhammad Haseeb
 * @version 1.1
 */
public class CardTester
{
    public static void main(String[] args)
    {
        Card card1 = new Card(0012, "Steve", 5, 10);
        Card card2 = new Card(0013, "Emma", 5, 10);
        
        System.out.println("Initial Card Information:");
        System.out.println("Card 1:\n" + card1);
        System.out.println("Card 2:\n" + card2);
        
        System.out.println("\nUsing Bridge:");
        card1.convertPointsToCredits();
        card2.convertPointsToCredits();
        
        System.out.println("\nUpdated Card Information:");
        System.out.println("Card1:\n" + card1);
        System.out.println("Card2:\n" + card2);
       
    }
        
    
}
