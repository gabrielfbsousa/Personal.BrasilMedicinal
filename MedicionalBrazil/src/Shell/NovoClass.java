/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class NovoClass implements  ListSelectionListener{

    JList boxes;
    JPanel[] boxArray = new JPanel[10];
    
    public JPanel createContentPane (){
        
        JPanel totalGUI = new JPanel();
        
        // Array for the names to be in the list.
        String names[] = {"Red", "Blue", "Green", "Orange", "Yellow",
                          "Pink", "Cyan", "Gray", "Black", "Magenta"};
        
        // Creation of the list.
        // We set the cells in the list to be 20px x 140px.
        // And set the 'selection mode' to single, so only one thing
        // can be selected at any time.
        // We finish by adding an event listener for the List.
        
        boxes = new JList(names);
        boxes.setVisibleRowCount(10);
        boxes.setFixedCellHeight(20);
        boxes.setFixedCellWidth(140);
        boxes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        boxes.addListSelectionListener(this);
        
        // We create a JPanel with the GridLayout.
        JPanel mainPanel = new JPanel(new GridLayout(3, 4, 10, 30));

        Font font = new Font("Courier", Font.BOLD,12);
        boxArray[0] = createSquareJPanel(Color.red, 50);
        boxArray[1] = createSquareJPanel(Color.blue, 50);
        boxArray[2] = createSquareJPanel(Color.green, 50);
        boxArray[3] = createSquareJPanel(Color.orange, 50);
        boxArray[4] = createSquareJPanel(Color.yellow, 50);
        boxArray[5] = createSquareJPanel(Color.pink, 50);
        boxArray[6] = createSquareJPanel(Color.cyan, 50);
        boxArray[7] = createSquareJPanel(Color.gray, 50);
        boxArray[8] = createSquareJPanel(Color.black, 50);
        boxArray[9] = createSquareJPanel(Color.magenta, 50);
        
        // This sets every JPanel in the array to be hidden,
        // and then adds it to the mainPanel JPanel.
        
        for(int i = 0; i < 10; i++)
        {
            boxArray[i].setVisible(false);
            mainPanel.add(boxArray[i]);
        }
        
        // This final bit of code uses a BoxLayout to space out the widgets
        // in the GUI.
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(boxes);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(mainPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        
        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // In this method, we create a square JPanel of a colour and set size
    // specified by the arguments.

    private JPanel createSquareJPanel(Color color, int size) {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    // valueChanged is the method that deals with a ListSelectionEvent.
    // This one sets the Visibility of the chosen box to true, and the
    // rest to false.

    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting() == false) {
            if (e.getSource() == boxes) {
                for(int i = 0; i < 10; i++)
                {
                    if (i == boxes.getSelectedIndex())
                    {
                         boxArray[i].setVisible(true);
                    }
                    else
                    {
                         boxArray[i].setVisible(false);
                    }
                } 
            }
        }
    }

    private static void createAndShowGUI() {
    
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JListExample [=]");

        NovoClass demo = new NovoClass();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}