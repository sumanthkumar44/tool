package org.tool;
import javax.swing.*;
import java.awt.*;

public class ApplicationV2 {

    public static void main (String [] args) {
        // Create a JFrame object
        JFrame frame = new JFrame ("Swing Example");
        // Set the default close operation
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        frame.setSize (400, 300);

        // Create a JMenuBar object
        JMenuBar menuBar = new JMenuBar ();
        // Create a JMenu object
        JMenu menu = new JMenu ("File");
// Create a JMenuItem object with an icon and text
        JMenuItem item = new JMenuItem ("New");
        item.setIcon (new ImageIcon (">.png"));
        item.setHorizontalTextPosition (SwingConstants.LEFT);
// Create another JMenu object as a submenu
        JMenu submenu = new JMenu ("Project");
// Add some menu items to the submenu
        submenu.add (new JMenuItem ("Java"));
        submenu.add (new JMenuItem ("Python"));
// Add the submenu to the menu item
        item.add (submenu);
// Add the menu item to the menu
        menu.add (item);
        // Add the menu to the menu bar
        menuBar.add (menu);
        menuBar.setBackground (Color.DARK_GRAY);
        menu.setForeground (Color.WHITE);

        // Create a JTextArea object
        JTextArea textArea = new JTextArea ();
        // Set the text of the text area
        textArea.setText ("This is the right side content.");
        // Set the text area to be read-only
        textArea.setEditable (false);

        // Get the content pane of the frame
        Container contentPane = frame.getContentPane ();
        // Set the layout manager to BorderLayout
        contentPane.setLayout (new BorderLayout ());
        // Add the menu bar to the west region of the content pane
        contentPane.add (menuBar, BorderLayout.WEST);
        // Add the text area to the center region of the content pane
        contentPane.add (textArea, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible (true);
    }
}

// Set the icon to the > symbol
//item.setIcon (new ImageIcon (">.png"));
//// Set the horizontal text position to the left of the icon
//        item.setHorizontalTextPosition (SwingConstants.LEFT);