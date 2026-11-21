import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThietKeGiaoDien extends JFrame {
    JFrame f = new JFrame("Factorial");

    JLabel lblNumN = new JLabel("Num n = ");
    JTextField tfNumN = new JTextField(5);

    JLabel lblResult = new JLabel("Result");
    JTextField tfResult = new JTextField(5);

    JButton btnFact = new JButton("Fact");

    public ThietKeGiaoDien(){
        f.setLayout(new GridLayout(3, 2, 10, 10));
        f.add(lblNumN);
        f.add(tfNumN);
        f.add(lblResult);
        f.add(tfResult);
        f.add(btnFact);
        f.pack();
        btnFact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(tfNumN.getText());
                int fact = 1;
                for (int i = 2; i<= n; i++){
                    fact *= i;
                tfResult.setText(String.valueOf(fact));
                }
            }
        });

        f.setSize(300, 200);
        f.setVisible(true);
    }
    static void main() {
        ThietKeGiaoDien thietkegiaodien = new ThietKeGiaoDien();
    }
}

