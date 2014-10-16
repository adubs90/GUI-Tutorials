/*
 * Event Listeners
 * Autumn 2011 TCSS 305
 */

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An event listener that listens for mouse motion and scroll
 * wheel events, and prints them all to standard error.
 *
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class TrivialMouseMotionAndScrollWheelListener
  implements MouseMotionListener, MouseWheelListener
{
  /**
   * The dimensions of the window.
   */
  private static final Dimension SIZE = new Dimension(800, 600);
  
  // Interface Methods

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
   * Creates a frame and listens for mouse motion and scroll wheel events.
   *
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("More Fun with Mouse Events");
    final JPanel panel = new JPanel();
    final TrivialMouseMotionAndScrollWheelListener listener =
      new TrivialMouseMotionAndScrollWheelListener();
    panel.addMouseMotionListener(listener);
    panel.addMouseWheelListener(listener);
    frame.add(panel);
    frame.setSize(SIZE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
