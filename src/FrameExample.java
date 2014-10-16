/*
 * Autumn 2011 TCSS 305
 * Frame Example
 */

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A class that creates a frame and puts buttons in it.
 * 
 * @author Daniel M. Zimmerman
 * @version Spring 2011
 */
@SuppressWarnings("serial")
public class FrameExample extends JFrame
{
  /**
   * Constructs the frame, giving it a title and some buttons.
   */
  public FrameExample()
  {
    super("Frame (exciting!)");
    add(new JButton("Click Me!"));
    pack();
  }
  
  /**
   * "Runs" the frame.
   */
  public void start()
  {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }
  
  /**
   * The main method, constructs and displays a frame.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String... the_args)
  {
    final FrameExample fe = new FrameExample();
    fe.start();
  }
}
