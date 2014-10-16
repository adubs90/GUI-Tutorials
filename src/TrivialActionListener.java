/*
 * Event Listeners
 * Autumn 2011 TCSS 305
 * Daniel M. Zimmerman
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * An action listener that does something trivial.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class TrivialActionListener implements ActionListener
{
  /**
   * The dimensions of the window.
   */
  private static final Dimension SIZE = new Dimension(160, 90);
  
  // Interface Methods
  
  /**
   * Handles an ActionEvent. In a boring way.
   * 
   * @param the_event The event.
   */
  public void actionPerformed(final ActionEvent the_event)
  {
    System.err.println(the_event);
  }


  // Main method, for testing

  /**
   * Creates a JFrame with a single button, to test event listening.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("Click On Me!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JButton button = new JButton("A Button");
    final ActionListener listener = new TrivialActionListener();
    button.addActionListener(listener);
    frame.add(button, BorderLayout.NORTH);
    frame.setSize(SIZE);
    frame.setVisible(true);
  }
}
