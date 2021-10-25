/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: Reverse panel for Main Panel. Reverses words while keeping the word order correct.
*/
package jsjf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static javax.swing.BoxLayout.PAGE_AXIS;

public class ReversePanel extends JPanel {
    private final JButton toMainPanel;
    private final JButton enterText;
    private final JTextArea output;
    private final JTextArea input;
    public ReversePanel(){
        //Creating Variables
        JLabel title = new JLabel("Reverse Text");
        JLabel instruct = new JLabel("Enter Text Here");
        JLabel outputText = new JLabel("Reversed Text");
        JPanel topBar = new JPanel();
        JPanel main = new JPanel();
        toMainPanel = new JButton("Main Menu");
        enterText = new JButton("Enter");
        output = new JTextArea();
        input = new JTextArea();
        //JScrollPane has to be below the JTextArea for it to work.
        JScrollPane textScroll = new JScrollPane(input);
        JScrollPane outputScroll = new JScrollPane(output);
        //Editing Objects/Variables
        //Buttons
        //toMainPanel --Goes to the main menu
        toMainPanel.addActionListener(new ButtonListener());
        //enterText --Submits text
        enterText.addActionListener(new ButtonListener());
        enterText.setAlignmentX(CENTER_ALIGNMENT);
        //Main Layout --contains everything
        main.setLayout(new BoxLayout(main, PAGE_AXIS));
        main.setBackground(Color.pink);
        main.setMaximumSize(new Dimension(500,500));
        //textScroll --For user input
        textScroll.setPreferredSize(new Dimension(200,50));
        textScroll.setMaximumSize(new Dimension(200,50));
        //outputScroll --For program output
        outputScroll.setPreferredSize(new Dimension(200,100));
        outputScroll.setMaximumSize(new Dimension(200,100));
        outputScroll.setBackground(Color.white);
        //topBar --Top part of the Panel (toMainMenu button and title)
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
        topBar.setBackground(Color.pink);
        topBar.setAlignmentX(LEFT_ALIGNMENT);
        topBar.setPreferredSize(new Dimension(500,50));
        //Labels
        //title --The Title
        title.setForeground(Color.white);
        title.setFont(new Font("Futura", Font.BOLD, 20));
        //instruct --Instructions for the user
        instruct.setForeground(Color.white);
        instruct.setFont(new Font("Futura", Font.PLAIN, 15));
        instruct.setAlignmentX(CENTER_ALIGNMENT);
        //outputText --Output from the program
        outputText.setFont(new Font("Futura", Font.PLAIN, 15));
        outputText.setAlignmentX(CENTER_ALIGNMENT);
        outputText.setForeground(Color.white);
        //Text Areas
        //input
        input.setColumns(20);
        input.setLineWrap(true);
        input.setAlignmentX(CENTER_ALIGNMENT);
        //output
        output.setForeground(Color.pink);
        output.setLineWrap(true);
        output.setEditable(false);
        output.setFont(new Font("Futura", Font.PLAIN, 15));
        output.setOpaque(false);
        output.setAlignmentX(CENTER_ALIGNMENT);
        //Adding to Panels --Box.createRigidAreas are spacers
        //topBar
        topBar.add(toMainPanel);
        topBar.add(Box.createRigidArea(new Dimension(65,0)));
        topBar.add(title);
        //Main Panel
        main.add(instruct);
        main.add(textScroll);
        main.add(Box.createRigidArea(new Dimension(0,50)));
        main.add(enterText);
        main.add(Box.createRigidArea(new Dimension(0,50)));
        main.add(outputText);
        main.add(outputScroll);
        //Main Panel --the ReversePanel
        add(topBar);
        add(main);
        add(Box.createRigidArea(new Dimension(0,250)));
        setBackground(Color.pink);
        setPreferredSize(new Dimension(500,500));
    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == toMainPanel){
                Interface.toMainPanel();
            }
            if(e.getSource() == enterText){
                ArrayStack<String> word = new ArrayStack<>();
                Scanner inputString = new Scanner(input.getText());
                while(inputString.hasNext()){
                    word.push(inputString.next());
                }
                inputString.close();
                output.setText(word.popReversed());
            }
        }

    }
}
