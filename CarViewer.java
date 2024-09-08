import javax.swing.JFrame;

public class CarViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();  // create frame object
      // set frame attributes
      frame.setSize(300, 400);
      frame.setTitle("Two cars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // initialize a CarComponent() component object
      CarComponent component = new CarComponent();
      // add the component to the frame
      frame.add(component);

      frame.setVisible(true);
   }
}
