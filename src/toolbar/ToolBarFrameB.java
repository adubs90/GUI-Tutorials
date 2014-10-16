/*
 * Toolbars
 * Autumn 2011 TCSS 305
 */

package toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/** 
 * A frame that uses a menu bar and Toolbar to change colors.
 * 
 * @author Daniel M. Zimmerman, based on an original program by
 *         Cay Horstmann
 * @author TCSS 305A Class
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ToolBarFrameB extends JFrame
{ 
  /**
   * The default width of the frame.
   */
  public static final int DEFAULT_WIDTH = 300;
  
  /**
   * The default height of the frame.
   */
  public static final int DEFAULT_HEIGHT = 200;  

  /**
   * A constant for the string "Exit".
   */
  private static final String EXIT_STRING = "Exit";
  
  /**
   * The panel used inside the frame.
   */
  private final JPanel my_panel;
  
  /**
   * The "Color" menu, from the menu bar.
   */
  private JMenu my_color_menu;
  
  /**
   * The tool bar.
   */
  private final JToolBar my_tool_bar;
  
  /**
   * The exit action.
   */
  private Action my_exit_action;
  
  /**
   * The choose color action.
   */
  private final Action my_choose_color_action = new ColorChooser();
  
  /**
   * A list of color actions.
   */
  private List<ColorAction> my_color_actions;
  
  /**
   * The menu button group.
   */
  private ButtonGroup my_menu_group;
  
  // Constructor
  
  /**
   * Constructs a new ToolBarFrame with all its controls.
   */
  public ToolBarFrameB()
  {  
    super("Fun with Colors and Widgets");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    setupActions(); // initializes my_actions
    
    my_tool_bar = createToolBar();
    add(my_tool_bar, BorderLayout.NORTH);
    
    my_panel = new JPanel();  // for color changes
    my_panel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    add(my_panel, BorderLayout.CENTER);
      
    setJMenuBar(createMenuBar());
  }

  /**
   * Sets up all the Actions.
   */
  private void setupActions()
  {
    my_color_actions = new ArrayList<ColorAction>();

    my_color_actions.add(new ColorAction("Blue", 
                                         new ImageIcon("src/toolbar/blue-ball.gif"), 
                                         Color.BLUE));
    my_color_actions.add(new ColorAction("Yellow", 
                                         new ImageIcon("src/toolbar/yellow-ball.gif"), 
                                         Color.YELLOW));
    my_color_actions.add(new ColorAction("Red", 
                                         new ImageIcon("src/toolbar/red-ball.gif"), 
                                         Color.RED));
    
    my_exit_action = 
      new AbstractAction(EXIT_STRING, new ImageIcon("src/toolbar/exit.gif"))
      {  
        public void actionPerformed(final ActionEvent the_event)
        {  
          dispose();
        }
      };
  
    my_exit_action.putValue(Action.SHORT_DESCRIPTION, EXIT_STRING);
    my_exit_action.putValue(Action.ACCELERATOR_KEY, 
        KeyStroke.getKeyStroke('Q', java.awt.event.InputEvent.CTRL_MASK));
  }
  
  /**
   * @return a fully-stocked tool bar.
   */
  private JToolBar createToolBar()
  {
    final JToolBar bar = new JToolBar();
    
    bar.add(my_exit_action);
    bar.addSeparator();
    bar.add(my_choose_color_action);
    
    for (ColorAction a : my_color_actions)
    {
      final JToggleButton rb = new JToggleButton(a);
      bar.add(rb);
    }
    
    return bar;
  }
  
  /**
   * @return a fully-stocked menu bar.
   */
  private JMenuBar createMenuBar()
  {
    final JMenuBar menu_bar = new JMenuBar();
    final JMenu file_menu = new JMenu("File");
    my_menu_group = new ButtonGroup();
    my_color_menu = new JMenu("Color");
    
    file_menu.add(my_exit_action);
    menu_bar.add(file_menu);
    
    my_color_menu.add(my_choose_color_action);
    my_color_menu.addSeparator();
    for (ColorAction a : my_color_actions)
    {
      final JRadioButtonMenuItem item =
        new JRadioButtonMenuItem(a);
      my_color_menu.add(item);
      my_menu_group.add(item);
    }
    menu_bar.add(my_color_menu);
    
    return menu_bar;
  }
  
  /**
   * Creates and makes visible a ToolBarFrame.
   * 
   * @param the_args Command line arguments, ignored.
   */
  public static void main(final String... the_args)
  {
    final ToolBarFrameB toolbar_frame = new ToolBarFrameB();
    toolbar_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    toolbar_frame.setVisible(true);
  }
  
  /**
   * An action that allows the user to choose a new color.
   */
  private class ColorChooser extends AbstractAction
  {
    /**
     * Constructs a new ColorChooser action.
     */
    public ColorChooser()
    {
      super("Add Color...");
      putValue(Action.SHORT_DESCRIPTION, "Add a custom color");
      putValue(Action.ACCELERATOR_KEY, 
               KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK));
    }
    
    /**
     * Handles an ActionEvent by presenting a color chooser dialog,
     * then a dialog to get the name of the color.
     * 
     * @param the_event The event, ignored.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      final Color chosen = 
        JColorChooser.showDialog(ToolBarFrameB.this, "Choose a Color", null);
      final String existing_name = getColorName(chosen);
      if (chosen != null && existing_name == null)
      {
        String name = 
            JOptionPane.showInputDialog(ToolBarFrameB.this, 
                                        "What is the name of this color?");
        if (name == null)
        {
          return;
        }
        else if (name.trim().isEmpty() || duplicateName(name))
        {
          name = "R" + chosen.getRed() + "G" + chosen.getGreen() +
                 "B" + chosen.getBlue();
          JOptionPane.showMessageDialog(ToolBarFrameB.this,
                                        "Invalid color name changed to " + name);
        }
        
        final ColorAction ca = new ColorAction(name, null, chosen);
        my_color_actions.add(ca);
        final JToggleButton rb = new JToggleButton(ca);
        my_tool_bar.add(rb);
        final JRadioButtonMenuItem item =
            new JRadioButtonMenuItem(ca);
        my_color_menu.add(item);
        my_menu_group.add(item);
        pack();
      }
      else if (chosen != null)
      {
        JOptionPane.showMessageDialog(ToolBarFrameB.this, 
                                      "The chosen color is already available, and is named " + 
                                      existing_name);
      }
    }
    
    /**
     * Checks for an existing color and, if one is found,
     * returns its name.
     * 
     * @param the_color The color to check for.
     * @return the name of the color, or null if no matching
     * color is found.
     */
    private String getColorName(final Color the_color)
    {
      String result = null;
      for (ColorAction ca : my_color_actions)
      {
        if (ca.color().equals(the_color))
        {
          result = (String) ca.getValue(Action.NAME);
          break;
        }
      }
      return result;
    }
    
    /**
     * Checks to see if there is already a color with the
     * specified name.
     * 
     * @param the_name The name.
     * @return true if a color with the specified name exists,
     * false otherwise.
     */
    private boolean duplicateName(final String the_name)
    {
      boolean result = false;
      
      for (ColorAction ca : my_color_actions)
      {
        result = result || the_name.equals(ca.getValue(Action.NAME));
      }
      
      return result;
    }
  }
  
  /** 
   * Sets the background of the panel to the specified color.
   */
  private class ColorAction extends AbstractAction
  {  
    /**
     * The color to use.
     */
    private final Color my_color; 
    
    /**
     * Constructs an action with the specified name and icon
     * to set the panel to the specified color.
     * 
     * @param the_name The name.
     * @param the_icon The icon.
     * @param the_color The color.
     */
    public ColorAction(final String the_name, final Icon the_icon, final Color the_color)
    {  
      super(the_name, the_icon);
      putValue(Action.SHORT_DESCRIPTION, the_name + " background");
      putValue(Action.SELECTED_KEY, false);
      my_color = the_color;
    }
    
    /**
     * Sets the panel to the specified color.
     * 
     * @param the_event The event, ignored.
     */
    public void actionPerformed(final ActionEvent the_event)
    {  
      my_panel.setBackground(my_color);
    }
    
    /**
     * @return The color for this ColorAction.
     */
    public Color color()
    {
      return my_color;
    }
  }
}
