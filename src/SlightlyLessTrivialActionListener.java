/*
 * Event Listeners
 * Autumn 2011 TCSS 305
 * Daniel M. Zimmerman
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * An action listener class that does something less trivial.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class SlightlyLessTrivialActionListener implements ActionListener
{
  /**
   * The dimensions of the window.
   */
  private static final Dimension SIZE = new Dimension(160, 90);
  
  /**
   * The time threshold for clicking too fast.
   */
  private static final long THRESHOLD = 1000;
  
  // Instance Fields
  
  /**
   * The two-actions-ago timestamp.
   */
  private long my_two_actions_ago;
  
  /**
   * The one-action-ago timestamp.
   */
  private long my_one_action_ago;
  
  
  // Interface Methods
  
  /**
   * Handles an ActionEvent. In a less boring way.
   * 
   * @param the_event The event.
   */
  public void actionPerformed(final ActionEvent the_event)
  {
    System.err.println(the_event);
    
    // easter egg time!
    
    if (the_event.getWhen() - my_two_actions_ago < THRESHOLD)
    {
      JOptionPane.showMessageDialog(null, 
                                    "You're clicking too fast. Please stop.", 
                                    "Click Speed Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    my_two_actions_ago = my_one_action_ago;
    my_one_action_ago = the_event.getWhen();
  }

  // Main method, for testing

  /**
   * Creates a JFrame with a single button, to test event listening,
   * with a twist.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("Click On Me!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JButton button = new JButton("A Button");
    button.addActionListener(new SlightlyLessTrivialActionListener());
    frame.add(button);
    frame.setSize(SIZE);
    frame.setVisible(true);
  }
}
