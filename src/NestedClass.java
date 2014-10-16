/*
 * Nested and Inner Classes
 * Autumn 2011 TCSS 305
 */

/**
 * A class that illustrates nested class concepts.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class NestedClass
{
  /**
   * The secret integer (shh!).
   */
  private int my_secret;

  /**
   * Constructor that sets the initial secret integer.
   * 
   * @param the_secret The secret integer.
   */
  public NestedClass(final int the_secret)
  {
    my_secret = the_secret;
  }

  /**
   * @return the secret integer (yes, it's not that closely guarded a 
   * secret).
   */
  public int getSecret()
  {
    return my_secret;
  }

  /**
   * Creates and manipulates some instances of this class.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final NestedClass obj = new NestedClass(2);
    final NestedClass another_obj = new NestedClass(12);
    
    System.err.println("The first secret integer is " + obj.getSecret());
    System.err.println("The second secret integer is " + another_obj.getSecret());

    final NestedClass.InsideNestedClass inside_obj =
      new NestedClass.InsideNestedClass();

    inside_obj.manipulateSecretInteger(obj);
    inside_obj.manipulateSecretInteger(another_obj);

    System.err.println("The first secret integer is " + obj.getSecret());
    System.err.println("The second secret integer is " + another_obj.getSecret());
  }
  
  /**
   * A class that does sneaky things with the secret integer.
   * 
   * @author Daniel M. Zimmerman
   * @version 1.0
   */
  public static class InsideNestedClass
  {
    /**
     * Modifies the secret integer of the specified instance of 
     * NestedClass.
     * 
     * @param the_instance The instance.
     */
    public void manipulateSecretInteger(final NestedClass the_instance)
    {
      the_instance.my_secret = the_instance.my_secret << 1;
    }
  }
}
