/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: Main Panel for the GUI. Main Menu
*/
package jsjf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    //Creating Objects
    JButton ReverseButton = new JButton("Reverse Text");
    JButton PushPopButton = new JButton("Push & Pop");
    JButton PushPopCircleButton = new JButton("Push & Pop Circle");
    public MainPanel() {
        //More Objects
        JPanel buttons = new JPanel();
        JLabel title = new JLabel("Main Menu");
        //Editing Objects/Variables
        ReverseButton.addActionListener(new ButtonListener());
        PushPopButton.addActionListener(new ButtonListener());
        PushPopCircleButton.addActionListener(new ButtonListener());
        //Title
        title.setForeground(Color.white);
        title.setFont(new Font("Futura", Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        //Buttons
        buttons.add(ReverseButton);
        buttons.add(PushPopButton);
        buttons.add(PushPopCircleButton);
        buttons.setOpaque(false);
        buttons.setAlignmentX(CENTER_ALIGNMENT);
        //Adding to MainPanel Panel
        add(Box.createRigidArea(new Dimension(0,10)));
        add(title);
        add(buttons);
        setBackground(new Color(54, 141, 126));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(500, 500));
    }
    //Button Listener --switches between panels
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == ReverseButton){
                Interface.toRPanel();
            }
            if(e.getSource() == PushPopButton){
                Interface.toPPPanel();
            }
            if(e.getSource() == PushPopCircleButton){
                Interface.toPPCPanel();
            }
        }
    }
}
