/*
 * Intro to Swing 
 * Autumn 2011 TCSS 305
 * Daniel M. Zimmerman
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Demonstrates composite layout of a bunch of widgets.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class CompositeLayout extends JFrame
{ 
  /**
   * Constructs a frame to demonstrate composite layout.
   */
  public CompositeLayout()
  {
    super("Composite Layout");
    setupComponents();
  }
  
  /**
   * Sets up the components in this frame.
   */
  private void setupComponents()
  {
    final JPanel north_panel = new JPanel(new FlowLayout());
    final JPanel south_panel = new JPanel(new GridLayout(1, 2));
//    final JPanel south_panel = new JPanel(new BorderLayout());
    final JLabel left = new JLabel("Lower Left", SwingConstants.LEFT);
    final JLabel right = new JLabel("Lower Right", SwingConstants.RIGHT);
//    final JLabel left = new JLabel("Lower Left");
//    final JLabel right = new JLabel("Lower Right");
    south_panel.add(left, BorderLayout.WEST);
    south_panel.add(right, BorderLayout.EAST);
    
    final JButton button1 = new JButton("Button 1");
    final JButton button2 = new JButton("Button Two");
    north_panel.add(button1);
    north_panel.add(button2);
    
    add(north_panel, BorderLayout.NORTH);
    add(new JButton("Center Button"), BorderLayout.CENTER);
    add(south_panel, BorderLayout.SOUTH);  
    
    pack();
  }
  
  
  /**
   * Does some composite layout and displays it.
   * 
   * @param the_args Command line arguments (ignored).
   */
  
  public static void main(final String... the_args)
  {
    final JFrame frame = new CompositeLayout();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }
}
