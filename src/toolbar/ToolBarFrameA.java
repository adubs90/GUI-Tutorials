/*
 * Toolbars
 * Autumn 2011 TCSS 305
 */

package toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ToolBarFrameA extends JFrame
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
   * The pick color action.
   */
  private final PickColorAction my_pick_color = new PickColorAction();
  
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
  public ToolBarFrameA()
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
    bar.add(my_pick_color);
    bar.addSeparator();
    
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
    
    my_color_menu.add(my_pick_color);
    my_color_menu.addSeparator();
    
    file_menu.add(my_exit_action);
    menu_bar.add(file_menu);
    
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
    final ToolBarFrameA toolbar_frame = new ToolBarFrameA();
    toolbar_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    toolbar_frame.setVisible(true);
  }
  
  /**
   * An action that allows the user to add a new color.
   */
  private class PickColorAction extends AbstractAction
  {
    /**
     * Constructs a new PickColorAction.
     */
    public PickColorAction()
    {
      super("Add Color...");
      putValue(Action.SHORT_DESCRIPTION, "Add a new color to the menu and toolbar.");
    }
    
    /**
     * Handles an action event, by displaying a color chooser and then
     * an input dialog to get a color and a name from the user.
     * 
     * @param the_event The event, ignored.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      final Color chosen = 
        JColorChooser.showDialog(ToolBarFrameA.this, "Pick a Color", null);
      if (chosen != null && noDuplicateColors(chosen))
      {
        // they chose something!
        String name = "";
        
        do
        {
          name = JOptionPane.showInputDialog(ToolBarFrameA.this, "Name the Color");
          if (name == null)
          {
            JOptionPane.showMessageDialog(ToolBarFrameA.this, 
                                          "A name needs at least one character, moron!");
            name = "";
          }
          name = name.trim();
          final Iterator<ColorAction> it = my_color_actions.iterator();
          while (name.length() > 0 && it.hasNext())
          {
            final ColorAction ca = it.next();
            if (name.equals(ca.getValue(Action.NAME)))
            {
              JOptionPane.showMessageDialog(ToolBarFrameA.this,
                                            "You can't really be this dumb. " +
                                            "The color name exists already!");
              name = "";
            }
          }
        }
        while (name.length() == 0);
        
        final ColorAction a = new ColorAction(name, null, chosen);
        my_color_actions.add(a);
        
        final JToggleButton rb = new JToggleButton(a);
        my_tool_bar.add(rb);
        
        final JRadioButtonMenuItem item = new JRadioButtonMenuItem(a);
        my_color_menu.add(item);
        my_menu_group.add(item);
        pack();
      }
    }
    
    /**
     * Checks to see if the specified color already exists in
     * the list.
     * 
     * @param the_color The color.
     * @return true if the color does not exist in the list,
     * false otherwise.
     */
    private boolean noDuplicateColors(final Color the_color)
    {
      boolean result = true;
      final Iterator<ColorAction> it = my_color_actions.iterator();
      
      while (result && it.hasNext())
      {
        final ColorAction a = it.next();
        result = !a.getColor().equals(the_color);
      }
      
      if (!result)
      {
        JOptionPane.showMessageDialog(ToolBarFrameA.this, 
                                      "Hey dummy, choose another color!");
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
     * @return the color for this ColorAction.
     */
    public Color getColor()
    {
      return my_color;
    }
  }
}
