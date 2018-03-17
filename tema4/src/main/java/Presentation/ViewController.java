package Presentation;

import javax.swing.*;

public class ViewController {
    private Frame frame;
    private AccountPanel accPanel;
    private PersonPanel persPanel;

    public void showFrame() {
        frame = new Frame();
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void showAccountPanel() {
        frame.getContentPane().removeAll();
        accPanel = new AccountPanel();
        frame.add(accPanel);
        frame.revalidate();
    }

    public void showPersonPanel() {
        frame.getContentPane().removeAll();
        persPanel = new PersonPanel();
        frame.add(persPanel);
        frame.revalidate();
    }

    public AccountPanel getAccPanel() {
        return accPanel;
    }

    public PersonPanel getPersPanel() {
        return persPanel;
    }

}
