import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

/**
   A car shape that can be positioned anywhere on the screen.
*/
public class Car
{
   private int xLeft;
   private int yTop;

   /**
      Constructs a car with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public Car(int initialX, int initialY)
   {
      this.xLeft = initialX;
      this.yTop = initialY;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle2D.Double body = new Rectangle2D.Double(this.xLeft, this.yTop + 10, 60, 10);      
      Ellipse2D.Double frontTire 
         = new Ellipse2D.Double(this.xLeft + 10, this.yTop + 20, 10, 10);
      Ellipse2D.Double rearTire 
         = new Ellipse2D.Double(this.xLeft + 40, this.yTop + 20, 10, 10);

      // The bottom of the front windshield
      Point2D.Double r1 = new Point2D.Double(this.xLeft + 10, this.yTop + 10);
      // The front of the roof
      Point2D.Double r2 = new Point2D.Double(this.xLeft + 20, this.yTop);
      // The rear of the roof
      Point2D.Double r3 = new Point2D.Double(this.xLeft + 40, this.yTop);
      // The bottom of the rear windshield
      Point2D.Double r4 = new Point2D.Double(this.xLeft + 50, this.yTop + 10);

      Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
      
      // draws the car
      g2.setColor(Color.RED);
      g2.fill(body);
      g2.setColor(Color.BLACK);
      g2.fill(frontTire);
      g2.fill(rearTire);
      g2.draw(frontWindshield);      
      g2.draw(roofTop);      
      g2.draw(rearWindshield);      
   }
}
