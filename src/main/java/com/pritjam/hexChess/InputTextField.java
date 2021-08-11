package com.pritjam.hexChess;

import java.awt.event.*;

import javax.swing.JTextField;

public class InputTextField extends JTextField {

    public InputTextField(int length) {
        super(length);
        this.addActionListener(new inputEventListener());
    }

    class inputEventListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String text = InputTextField.this.getText().toLowerCase();
            String[] command = text.split(" ");
            if (command[0].equals("mark")) {
                if (command.length != 2) {
                    throw new IllegalArgumentException(
                            "Must provide location to mark in qr coordinates, such as \"a1\"");
                }
                Main.board.mark(command[1], true);
            } else if (command[0].equals("clear")) {
                if (command.length != 2) {
                    throw new IllegalArgumentException(
                            "Must provide location to clear in qr coordinates, such as \"a1\"");
                }
                Main.board.mark(command[1], false);
            } else if (command.length == 1) {
                try {
                    Main.board.attemptMove(text);
                } catch (Exception e) {
                    InputTextField.this.setText(e.getMessage());
                }
            }
            
            Main.board.repaint();
            InputTextField.this.selectAll();
        }
    }
}
