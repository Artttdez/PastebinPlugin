package com.Artttdez.pastebinsender.gui;

import javax.swing.*;

public class SettingsGui {

    private JPanel panel;
    private JTextField textField1;
    private JLabel label1;


    private void checkJLabel() {
    }


    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextField() {
        return textField1;
    }

    private void createUIComponents() {
        panel = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
    }
}
