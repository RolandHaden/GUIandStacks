/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: Main Class for the GUI
*/
package jsjf;

import javax.swing.*;

public class Interface {
    public static JFrame frame;
    public static MainPanel panel;
    public static ReversePanel rpanel;
    public static PushPopPanel pppanel;
    public static PushPopPanelCircle ppcpanel;
    public static JPanel currentPanel = null;
    public static void main(String[] args) {
        frame = new JFrame("Stack Interface");
        panel = new MainPanel();
        rpanel = new ReversePanel();
        pppanel = new PushPopPanel();
        ppcpanel = new PushPopPanelCircle();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    //Goes to the Reverse Panel
    public static void toRPanel() {
        frame.getContentPane().remove(panel);
        currentPanel = rpanel;
        frame.getContentPane().add(rpanel);
        frame.repaint();
        frame.revalidate();
    }
    //Goes to the PushPopPanel
    public static void toPPPanel() {
        frame.getContentPane().remove(panel);
        currentPanel = pppanel;
        frame.getContentPane().add(pppanel);
        frame.repaint();
        frame.revalidate();
    }
    //Goes to the PushPopPanelCircle
    public static void toPPCPanel() {
        frame.getContentPane().remove(panel);
        currentPanel = ppcpanel;
        frame.getContentPane().add(ppcpanel);
        frame.repaint();
        frame.revalidate();
    }
    //Goes back to the Main Panel
    public static void toMainPanel() {
        frame.getContentPane().remove(currentPanel);
        frame.getContentPane().add(panel);
        frame.repaint();
        frame.revalidate();
    }
}
