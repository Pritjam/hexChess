import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;


public class Main {
    static protected BoardPanel board;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("HexChess Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridBagLayout());
        board = new BoardPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        f.add(board, c);

        JTextField inputField = new InputTextField(50);
        inputField.setText("Input your move here!");
        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 0;
        d.gridy = 1;
        f.add(inputField, d);
        f.pack();
        f.setVisible(true);
    }
}