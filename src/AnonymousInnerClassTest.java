/*
 * Nested and Inner Classes 
 * Autumn 2011 TCSS 305
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Tests the use of anonymous inner classes to listen for button events.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AnonymousInnerClassTest extends JPanel
{
  /**
   * The number of buttons to create.
   */
  public static final int NUM_BUTTONS = 2500;

  /**
   * Constructs a new AnonymousInnerClassTest, by creating a bunch of buttons.
   */
  public AnonymousInnerClassTest()
  {
    super();
    createButtons();
  }

  /**
   * Creates some buttons.
   */
  private void createButtons()
  {
    for (int i = 0; i < NUM_BUTTONS; i++)
    {
      add(createButton(new NamedObject(String.valueOf(i + 1))));
    }
  }

  /**
   * Creates a single button that calls a method on the specified object when
   * pressed.
   * 
   * @param the_object The object.
   * @return the button.
   */
  private JButton createButton(final NamedObject the_object)
  {
    final JButton button = new JButton(the_object.toString());
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        the_object.doSomething();
      }
    });

    return button;
  }

  /**
   * Creates a frame and adds a bunch of buttons, to illustrate inner classes as
   * listeners.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFrame frame = new JFrame("My Frame");
    frame.add(new AnonymousInnerClassTest());
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
