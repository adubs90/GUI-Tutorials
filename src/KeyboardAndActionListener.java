/*
 * Event Listeners 
 * Autumn 2011 TCSS 305
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Illustrates how keyboard and action events work with text entry.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class KeyboardAndActionListener implements KeyListener, ActionListener
{
  /**
   * Detects a key pressed event.
   * 
   * @param the_event The event.
   */
  public void keyPressed(final KeyEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * Detects a key released event.
   * 
   * @param the_event The event.
   */
  public void keyReleased(final KeyEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * Detects a key typed event.
   * 
   * @param the_event The event.
   */
  public void keyTyped(final KeyEvent the_event)
  {
    System.err.println(the_event);
    System.err.println("Char Value: " + (int) the_event.getKeyChar());
  }

  /**
   * Detects an action event.
   * 
   * @param the_event The event.
   */
  public void actionPerformed(final ActionEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * Creates a frame with a text field and a label, and listens for key and
   * action events.
   * 
   * @param the_args Command line arguments (ignored).
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("Text Entry");
    final JLabel label = new JLabel("Text Field");
    final JTextField text_field = new JTextField(40);
    final FlowLayout layout = new FlowLayout();

    final KeyboardAndActionListener listener = new KeyboardAndActionListener();

    text_field.addActionListener(listener);
    text_field.addKeyListener(listener);

    frame.setLayout(layout);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(label);
    frame.add(text_field);
    frame.add(new JButton("Hi!"));
    frame.pack();
    frame.setVisible(true);
  }
}
