/*
 * Intro to Swing - File Choosers
 * Autumn 2011 TCSS 305
 * Daniel M. Zimmerman
 */

import javax.swing.JFileChooser;

/**
 * A quick test of a file chooser.
 * 
 * @author Daniel M. Zimmerman
 * @version 0.9
 */
public final class FileChooserTest
{
  /**
   * Private constructor to prevent instantiation.
   */
  private FileChooserTest()
  {
    // do nothing
  }

  /**
   * Tests a file dialog.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final JFileChooser file_chooser = new JFileChooser();

    int result = file_chooser.showOpenDialog(null);

    while (result != JFileChooser.APPROVE_OPTION)
    {
      System.out.println("You didn't choose a file, so file is " +
                         file_chooser.getSelectedFile() + " and you have to choose again.");
      result = file_chooser.showOpenDialog(null);
    }

    System.out.println("You chose file " + file_chooser.getSelectedFile());
  }
}
