/*
 * Events/Inner Classes
 * Autumn 2011 TCSS 305
 */

/**
 * A class that stores a name, and prints that name and a message
 * to standard error when doSomething() is called.
 * 
 * @author Daniel M. Zimmerman
 * @version 1.0
 */
public class NamedObject
{
  /**
   * The name of this object.
   */
  private final String my_name;
  
  /**
   * Constructs a new object with the specified name.
   * 
   * @param the_name The name.
   */
  public NamedObject(final String the_name)
  {
    my_name = the_name;
  }
  
  /**
   * {@inheritDoc}
   */
  public String toString()
  {
    return my_name;
  }
  
  /**
   * Prints a message to standard error.
   */
  public void doSomething() 
  {
    System.err.println(this + " did something!");
  }
}
