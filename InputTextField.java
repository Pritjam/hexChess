import java.awt.event.*;
import javax.swing.JTextField;

public class InputTextField extends JTextField {
    
    public InputTextField(int length) {
        super(length);
        this.addActionListener(new inputEventListener());
    }
    class inputEventListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String text = InputTextField.this.getText();
            try{
                Main.board.attemptMove(text);
            } catch(IllegalArgumentException e) {
                InputTextField.this.setText(e.getMessage());
            }
            Main.board.repaint();
            InputTextField.this.selectAll();
        }
    }
}
