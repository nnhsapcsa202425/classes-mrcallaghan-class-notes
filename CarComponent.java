import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{  
   @Override
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;  // cast to Graphics2D object

      Car car1 = new Car(0, 0); // initialize a new Car object
      
      int x = this.getWidth() - 60;
      int y = this.getHeight() - 30;

      Car car2 = new Car(x, y); // initialize a 2nd Car object
      
      // draw cars
      car1.draw(g2);
      car2.draw(g2);      
   }
}
