package graphics;

import game.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicBoard extends JFrame {
    private Board bd;
    private Button btn[][];
    private Button previousButton;
    private Button enemyPieces[];
    private Button playerPieces[];

    public GraphicBoard() {
        bd = new Board();
        btn = new Button[5][5];
        enemyPieces = new Button[6];
        playerPieces = new Button[6];

        for( int i = 0 ; i<5 ; i++ ) {
            for( int j = 0 ; j<5 ; j++ ) {
                btn[i][j] = new Button(bd.getCell(i, j));
            }
        }

        getPiecesArray(true);
        getPiecesArray(false);
        
        previousButton = null;
    }

    public Board getBoard() {
        return bd;
    }

    public void updateCell(int x, int y) {
        btn[x][y].upgradeImage();
    }

    public void updateWindow() {
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                btn[i][j].upgradeImage();
            }
        }
    }

    public void showWindow() {
        
        setTitle("Combate");
        setSize(650, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        setLayout(new GridBagLayout());
        

        GridBagConstraints c = new GridBagConstraints();

        // ENEMY`S LEFT PIECES
        JPanel pTopButtons = new JPanel(new GridLayout());
        pTopButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pTopButtons.setVisible(true);

        for( int i = 0 ; i<6 ; i++ ) {
            pTopButtons.add(enemyPieces[i]);
        }
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 2; // 10% height of panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        add(pTopButtons, c);

        // PANEL 1 CONFIGURATION
        JPanel pTop = new JPanel();
        pTop.setLayout(new GridBagLayout());
        pTop.setVisible(true);

        JLabel lbl1 = new JLabel("Enemy");
        pTop.add(lbl1);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 1; // 10% height of panel
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(pTop, c);

        // BUTTONS` GRID CONFIGURATION
        BackgroundJPanel pMid = new BackgroundJPanel();
        pMid.setVisible(true);

        for( int i = 0 ; i<5 ; i++ ) {
            for( int j = 0 ; j<5 ; j++ ) {
                pMid.add(btn[i][j]);
            }
        }

        pMid.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 2; // 80% height of panel
        c.gridx = 0;
        c.gridy = 2;
        add(pMid, c);

        // PANEL 3 CONFIGURATION
        JPanel pBottom = new JPanel(new GridBagLayout());
        JLabel lblPlayerPieces = new JLabel("Player");
        pBottom.add(lblPlayerPieces);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(pBottom, c);

        // PLAYER`S LEFT PIECES
        JPanel pBottomButtons = new JPanel(new GridLayout());
        pBottomButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pBottomButtons.setVisible(true);

        for( int i = 0 ; i<6 ; i++ ) {
            pBottomButtons.add(playerPieces[i]);
        }
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1; // 100% width of panel
        c.weighty = 2; // 10% height of panel
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        add(pBottomButtons, c);

        //setContentPane((new JLabel(new ImageIcon(getClass().getResource("/images/jogocombate (1).png")))));
        //insert the background image in the frame, but this method puts the image above the other elements
        this.setVisible(true);
    }

    public void playGame() {
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                System.out.println("Button Pressed: x : " + button.getAssociatedCell().getPosx() + " y : " + button.getAssociatedCell().getPosy() + "\n");
                
                if(previousButton == null) { // nothing was pressed before, or a piece without a piece was chosen, or a enemy piece was chosen
                    setPreviousButton(button);
                    return;
                } else if(previousButton.getAssociatedCell().getPiece().getPlayerOwned()) {
                    if(button.getAssociatedCell().getPiece() == null) {
                        bd.moveOrAttack(previousButton.getAssociatedCell(), button.getAssociatedCell(), true);
                        updateCell(previousButton.getAssociatedCell().getPosx(), previousButton.getAssociatedCell().getPosy());
                        updateCell(button.getAssociatedCell().getPosx(), button.getAssociatedCell().getPosy());

                        setPreviousButton(null);
                    }
                } else if(!previousButton.getAssociatedCell().getPiece().getPlayerOwned()) {
                    setPreviousButton(null);
                }

            }
        };

        for(int i = 0 ; i < 5 ; i ++) {
            for ( int j = 0 ; j < 5 ; j ++) {
                btn[i][j].addActionListener(listener);
            }
        }
    }
    private void removeActionListeners(ActionListener e) {
        for(int i = 0 ; i < 5 ; i ++) {
            for ( int j = 0 ; j < 5 ; j ++) {
                btn[i][j].removeActionListener(e);
            }
        }
    
    }
    private void setPreviousButton (Button b) {
        if(b == null) {
            this.previousButton = null;
        } else if(b.getAssociatedCell().getPiece() == null) {
            this.previousButton = null;
        } else {
            this.previousButton = b;
        }

    }

    private void getPiecesArray(boolean playerOwned) {
        if(playerOwned == true) {
            playerPieces[0] = new Button(new PieceBomb(playerOwned));
            playerPieces[1] = new Button(new PieceFlag(playerOwned));
            playerPieces[2] = new Button(new PieceSoldier(playerOwned));
            playerPieces[3] = new Button(new PieceSpy(playerOwned));
            playerPieces[4] = new Button(new PieceMarshall(playerOwned));
            playerPieces[5] = new Button(new PieceCorporal(playerOwned));
        } else {
            enemyPieces[0] = new Button(new PieceBomb(playerOwned));
            enemyPieces[1] = new Button(new PieceFlag(playerOwned));
            enemyPieces[2] = new Button(new PieceSoldier(playerOwned));
            enemyPieces[3] = new Button(new PieceSpy(playerOwned));
            enemyPieces[4] = new Button(new PieceMarshall(playerOwned));
            enemyPieces[5] = new Button(new PieceCorporal(playerOwned));
        }
    }
}


