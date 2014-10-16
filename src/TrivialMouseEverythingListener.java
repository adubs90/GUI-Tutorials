/*
 * Event Listeners
 * Autumn 2011 TCSS 305
 */

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An event listener that listens for all possible mouse events.
 * All events are simply printed to standard error.
 *
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class TrivialMouseEverythingListener extends MouseAdapter
  // implements MouseInputListener, MouseWheelListener
{
  /**
   * The dimensions of the window.
   */
  private static final Dimension SIZE = new Dimension(800, 600);
  
  // Interface Methods

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
   * {@inheritDoc}
   */
  public void mouseWheelMoved(final MouseWheelEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mouseDragged(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * {@inheritDoc}
   */
  public void mouseMoved(final MouseEvent the_event)
  {
    System.err.println(the_event);
  }

  /**
   * Creates a frame and listens for mouse events of all kinds.
   *
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("The Most Fun with Mouse Events");
    final JPanel panel = new JPanel();
    final TrivialMouseEverythingListener listener =
      new TrivialMouseEverythingListener();
    panel.addMouseListener(listener);
    panel.addMouseMotionListener(listener);
    panel.addMouseWheelListener(listener);
    frame.add(panel);
    frame.setSize(SIZE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
