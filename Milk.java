public class Milk
{
   public static void main(String[] args)
   {
      double milk = 5.5; // gallons
      double jarCapacity = 0.75; // gallons
      double leftoverMilk = 0.0; // gallons

      int completelyFilledJars = (int) (milk / jarCapacity);
      leftoverMilk = (milk % jarCapacity);
      
      System.out.println("Completely filled jars: " + completelyFilledJars);
      System.out.println("Leftover milk: " + leftoverMilk + " gallons");    }
}