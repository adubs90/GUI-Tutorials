/*
 * Event Listeners
 * Autumn 2011 TCSS 305
 */

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An event listener that listens for mouse events, and prints them
 * all to standard error.
 *
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class TrivialMouseListener implements MouseListener
{
  /**
   * The dimensions of the window.
   */
  private static final Dimension SIZE = new Dimension(800, 250);

  /**
   * {@inheritDoc}
   */
  public void mouseClicked(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mouseEntered(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mouseExited(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mousePressed(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mouseReleased(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * Creates a frame and listens for mouse events.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("Fun with Mouse Events");
    final JPanel panel = new JPanel();
    panel.addMouseListener(new TrivialMouseListener());
    frame.add(panel);
    frame.setSize(SIZE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
