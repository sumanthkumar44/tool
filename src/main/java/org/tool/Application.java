package org.tool;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.*;
import java.awt.*;

public class Application {

    public static void main (String [] args) {
        // Create a JFrame object
        JFrame frame = new JFrame ("Tree Menu Example");
        // Set the default close operation
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        frame.setSize (1000, 1000);

        // Set the window header color to sky blue
        UIManager.put("activeCaption", new ColorUIResource(135, 206, 235) {
        });

        // Create a root node for the tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode ("Menu");
        // Create some branch nodes for the root node
        DefaultMutableTreeNode file = new DefaultMutableTreeNode ("File");
        DefaultMutableTreeNode edit = new DefaultMutableTreeNode ("Edit");
        DefaultMutableTreeNode help = new DefaultMutableTreeNode ("Help");
        // Add the branch nodes to the root node
        root.add (file);
        root.add (edit);
        root.add (help);
        // Create some leaf nodes for the branch nodes
        DefaultMutableTreeNode newFile = new DefaultMutableTreeNode ("New");
        DefaultMutableTreeNode open = new DefaultMutableTreeNode ("Open");
        DefaultMutableTreeNode save = new DefaultMutableTreeNode ("Save");
        DefaultMutableTreeNode exit = new DefaultMutableTreeNode ("Exit");
        DefaultMutableTreeNode cut = new DefaultMutableTreeNode ("Cut");
        DefaultMutableTreeNode copy = new DefaultMutableTreeNode ("Copy");
        DefaultMutableTreeNode paste = new DefaultMutableTreeNode ("Paste");
        DefaultMutableTreeNode about = new DefaultMutableTreeNode ("About");
        // Add the leaf nodes to the branch nodes
        file.add (newFile);
        file.add (open);
        file.add (save);
        file.add (exit);
        edit.add (cut);
        edit.add (copy);
        edit.add (paste);
        help.add (about);

        // Create a JTree object with the root node
        JTree tree = new JTree (root);
        // Set the tree to show the root handle
        tree.setShowsRootHandles (true);
        // Set the tree to be single selection only
        tree.getSelectionModel ().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setBackground(Color.DARK_GRAY);
        tree.setForeground(Color.WHITE);
        tree.setCellRenderer (new MyTreeCellRenderer ());
        // Create a JTextArea object
        JTextArea textArea = new JTextArea ();
        // Set the text of the text area
        textArea.setText ("This is the right side content.");
        // Set the text area to be read-only
        textArea.setEditable (false);
        UIManager.put ("Menu.background", Color.GRAY);
        // Set the foreground color for menus to white
        UIManager.put ("Menu.foreground", Color.WHITE);


        // Get the content pane of the frame
        Container contentPane = frame.getContentPane ();
        // Set the layout manager to BorderLayout
        contentPane.setLayout (new BorderLayout ());
        // Add the tree to the west region of the content pane
        contentPane.add (tree, BorderLayout.WEST);
        // Add the text area to the center region of the content pane
        contentPane.add (textArea, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible (true);
    }

    // Create a custom tree cell renderer class
    static class MyTreeCellRenderer extends DefaultTreeCellRenderer {

        // Create some icons for the nodes
        private Icon nodeIcon = new ImageIcon (">.png");
        private Icon leafIcon = new ImageIcon ("*.png");

        // Override the getTreeCellRendererComponent method
        @Override
        public Component getTreeCellRendererComponent (JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            // Call the super method to get the default component
            super.getTreeCellRendererComponent (tree, value, selected, expanded, leaf, row, hasFocus);
            // Set the icon and the horizontal text position of the node
            if (leaf) {
                setIcon (leafIcon);
            } else {
                setIcon (nodeIcon);
                setHorizontalTextPosition (SwingConstants.LEFT);
            }
            // Return the component
            return this;
        }
    }
}
