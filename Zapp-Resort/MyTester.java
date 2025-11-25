import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author Muhammad Haseeb
 * @version 1.1 
 */
public class MyTester 
{   
    
    private void doTest()
    {
        ZAPP fantasia = new Park("Fantasia Pleasure Park");
        Scanner enter = new Scanner(System.in);
        // write your tests here
        testCardDetails(fantasia);
        testCardLocation(fantasia);
        testAllCardsInOneArea(fantasia);
        testAllCardsInAllAreas(fantasia);
        testCanMove(fantasia);
        testMove(fantasia);
        testTopUpCredits(fantasia);
        testConvertPoints(fantasia);
        
        

     }
    private void testCardDetails(ZAPP fantasia) 
    {
        System.out.println("Testing getCardDetails:");
        System.out.println(fantasia.getCardDetails(1)); 
        System.out.println(fantasia.getCardDetails(100)); 
        System.out.println();
    }

    private void testCardLocation(ZAPP fantasia) 
    {
        System.out.println("Testing getCardLocation:");
        System.out.println(fantasia.getCardLocation(1)); 
        System.out.println(fantasia.getCardLocation(100)); 
        System.out.println();
    }

    private void testAllCardsInOneArea(ZAPP fantasia) 
    {
        System.out.println("Testing getAllCardsInOneArea:");
        System.out.println(fantasia.getAllCardsInOneArea("Area1")); 
        System.out.println(fantasia.getAllCardsInOneArea("InvalidArea")); 
        System.out.println();
    }

    private void testAllCardsInAllAreas(ZAPP fantasia) 
    {
        System.out.println("Testing getAllCardsInAllAreas:");
        System.out.println(fantasia.getAllCardsInAllAreas());
        System.out.println();
    }

    private void testCanMove(ZAPP fantasia) 
    {
        System.out.println("Testing canMove:");
        System.out.println(fantasia.canMove(1, "B1")); 
        System.out.println(fantasia.canMove(2, "InvalidBridge")); 
        System.out.println();
    }

    private void testMove(ZAPP fantasia) 
    {
        System.out.println("Testing move:");
        System.out.println(fantasia.move(1, "B1"));  
        System.out.println(fantasia.move(2, "InvalidBridge")); 
        System.out.println();
    }

    private void testTopUpCredits(ZAPP fantasia) 
    {
        System.out.println("Testing topUpCredits:");
        fantasia.topUpCredits(1, 10); 
        System.out.println(fantasia.getCardDetails(1)); 
        System.out.println();
    }

    private void testConvertPoints(ZAPP fantasia) 
    {
        System.out.println("Testing convertPoints:");
        fantasia.convertPoints(1); 
        System.out.println(fantasia.getCardDetails(1));
        System.out.println();
    }
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
