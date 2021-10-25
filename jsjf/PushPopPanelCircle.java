/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: PushPopPanelCircle for Main Panel. Pushes and pops from a stack in a circle with visual representation.
*/
package jsjf;

import jsjf.exceptions.EmptyCollectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushPopPanelCircle extends JPanel{
    //Creating Objects
    JButton push;
    JButton pop;
    JButton toMainPanel;
    JPanel pushPanel;
    JPanel popPanel;
    JPanel buttonPanel;
    JPanel topBar;
    JTextField input;
    JTextField output;
    JLabel title;
    JTextArea array;
    CircleStack<String> strings = new CircleStack<String>();
    public PushPopPanelCircle(){
        //Defining Objects
        //Labels
        title = new JLabel("Push and Pop Circle!");
        //Text Areas
        array = new JTextArea("Array: ");
        //ScrollPanes
        JScrollPane outputScroll = new JScrollPane(array);
        //Buttons
        toMainPanel = new JButton("Main Menu");
        push = new JButton("Push!");
        pop = new JButton("Pop!");
        //TextFields
        input = new JTextField();
        output = new JTextField();
        //Panels
        topBar = new JPanel();
        pushPanel = new JPanel();
        popPanel = new JPanel();
        buttonPanel = new JPanel();
        //Editing Objects
        //title
        title.setForeground(Color.white);
        title.setFont(new Font("Futura", Font.BOLD, 20));
        //array --What is displayed to represent the stack/array
        array.setLineWrap(true);
        array.setEditable(false);
        array.setForeground(new Color(171, 227, 255));
        array.setFont(new Font("Futura", Font.BOLD, 15));
        array.setAlignmentX(CENTER_ALIGNMENT);
        //outputScroll --Allows user to scroll through the output
        outputScroll.setPreferredSize(new Dimension(400,100));
        outputScroll.setMaximumSize(new Dimension(400,100));
        //toMainPanel --Goes to main panel
        toMainPanel.addActionListener(new ButtonListener());
        push.addActionListener(new ButtonListener());
        pop.addActionListener(new ButtonListener());
        input.setColumns(8);
        output.setColumns(8);
        //Top Panel
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
        topBar.setOpaque(false);
        topBar.add(toMainPanel);
        topBar.add(Box.createRigidArea(new Dimension(40,0)));
        topBar.add(title);
        topBar.add(Box.createRigidArea(new Dimension(200,0)));
        //Push Panel
        pushPanel.add(input);
        pushPanel.add(push);
        pushPanel.setOpaque(false);
        pushPanel.setPreferredSize(new Dimension(110,60));
        //Pop Panel
        popPanel.add(output);
        popPanel.add(pop);
        popPanel.setOpaque(false);
        popPanel.setPreferredSize(new Dimension(110,60));
        //Button Panel
        buttonPanel.add(pushPanel);
        buttonPanel.add(popPanel);
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        //Final Panel
        add(Box.createRigidArea(new Dimension(0,10)));
        add(topBar);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(outputScroll);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(buttonPanel);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(171, 227, 255));
        setPreferredSize(new Dimension(500,500));
    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Goes to MainPanel
            if(e.getSource() == toMainPanel){
                Interface.toMainPanel();
            }
            //Pushes a value into the stack
            if(e.getSource() == push){
                strings.push(input.getText());
                array.setText("Array: " + strings);
                input.setText("");
            }
            //Pops the top value of the stack and inputs it in the the output textfield
            if(e.getSource() == pop){
                try {
                    output.setText(strings.pop());
                    array.setText("Array: " + strings);
                } catch (EmptyCollectionException emptyCollectionException) {
                    array.setText("Array: ");
                }
            }
        }
    }
}
