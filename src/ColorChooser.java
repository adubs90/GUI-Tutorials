/*
 * Color Chooser
 * Autumn 2011 TCSS 305
 */

import java.awt.Color;

import javax.swing.JColorChooser;

/**
 * Demonstrates the use of a color chooser.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public final class ColorChooser
{
  /**
   * Private constructor to prevent instantiation.
   */
  private ColorChooser()
  {
    // do nothing
  }
  
  /**
   * Displays a color chooser, and sends the chosen color
   * to standard output.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String... the_args)
  {
    Color result = null;
    
    do
    {
      result = JColorChooser.showDialog(null, "A Color Chooser", null);
      if (result != null) 
      {
        System.out.println("Color chosen: " + result + " - int " + result.getRGB());
      }
    }
    while (result != null);
  }
}
