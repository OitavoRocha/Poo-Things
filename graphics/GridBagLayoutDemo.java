package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GridBagLayoutDemo extends JFrame {
    public void showWindow() {
        setTitle("Teste");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        // PANEL 1 CONFIGURATION
        JPanel pTop = new JPanel();
        pTop.setLayout(new GridBagLayout());
        pTop.setVisible(true);
        //pTop.setBackground(Color.red);

        JLabel lbl1 = new JLabel(" ENEMY");
        pTop.add(lbl1);
        pTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 0.1; // 10% height of panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(pTop, c);

        c.gridwidth = 2;
        // PANEL 2 CONFIGURATION
        JPanel pMid = new JPanel(new GridLayout(5, 5));
        pMid.setVisible(true);

        for( int i = 0 ; i<25 ; i++ ) {
            JButton btn = new JButton(String.valueOf(i));
            btn.setPreferredSize(new Dimension(1, 1));/* 
            btn.setForeground(Color.BLACK);
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 5, 5, 5)));*/
            pMid.add(btn);
        }
        pMid.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 0.80; // 80% height of panel
        c.gridx = 0;
        c.gridy = 1;
        add(pMid, c);

        // PANEL 3 CONFIGURATION
        JPanel pBottom = new JPanel(new GridBagLayout());
        pBottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pBottom.setVisible(true);

        JLabel lbl2 = new JLabel("PLAYER");
        pBottom.add(lbl2);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5; // 100% width of panel
        c.weighty = 0.1; // 10% height of panel
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(pBottom, c);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        GridBagLayoutDemo layout = new GridBagLayoutDemo();
        layout.showWindow();
    }
}
