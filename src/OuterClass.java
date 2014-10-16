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
public class OuterClass
{
  /**
   * The secret integer (shh!).
   */
  private int my_secret;

  /**
   * Constructs an instance with the specified secret integer.
   * 
   * @param the_secret The secret integer.
   */
  public OuterClass(final int the_secret)
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
   * Constructs and manipulates some instances of this class.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String[] the_args)
  {
    final OuterClass obj = new OuterClass(2);
    final OuterClass new_obj = new OuterClass(12);

    System.err.println("The first secret integer is " + obj.getSecret());
    System.err.println("The second secret integer is " + new_obj.getSecret());

    final OuterClass.InnerClass inner_obj = obj.new InnerClass();
    inner_obj.manipulateSecretInteger();
    
    final OuterClass.InnerClass inner_obj2 = new_obj.new InnerClass();
    inner_obj2.manipulateSecretInteger();
    
    final OuterClass.InnerClass inner_obj3 = new_obj.new InnerClass();
    inner_obj3.manipulateSecretInteger();
    
    System.err.println("The first secret integer is " + obj.getSecret());
    System.err.println("The second secret integer is " + new_obj.getSecret());
  }
  

  /**
   * A class that does sneaky things with the secret integer.
   * 
   * @author Daniel M. Zimmerman
   * @version 1.0
   */
  private class InnerClass
  {
    /**
     * Modifies the secret integer of my instance of NestedClass.
     */
    public void manipulateSecretInteger()
    {
      my_secret = my_secret << 1;
    }
  }
}
