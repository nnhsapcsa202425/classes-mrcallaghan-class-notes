import java.util.Scanner;

public class DistanceConverter
{
   public static void main(String[] args)
   {
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the number of yards to be converted to feet and inches: ");
      
      final double FEET_PER_YARD = 3;
      final double INCHES_PER_FOOT = 12;

      double yards = s.nextDouble();
      double feet = yards * FEET_PER_YARD;
      double inches = feet * INCHES_PER_FOOT;

      System.out.println(yards + " yards are " + feet + " feet");
      System.out.println(yards + " yards are " + inches + " inches");
   }
}