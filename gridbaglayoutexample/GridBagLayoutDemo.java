package gridbaglayoutexample;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutDemo extends JFrame{
    public void mostrarJanela() {
        // ## Caracteristicas da Janela Principal ##############################
        setTitle("Exemplo do Uso do GridBagLayout");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Definição do leiaute do painel principal ----------------------------
        setLayout(new GridBagLayout());
        // Objeto que mantém as propriedades do leiaute aplicado ao painel -----
        GridBagConstraints propriedades = new GridBagConstraints();
        
        // -- Definição do painel superior -------------------------------------
        JPanel pSuperior = new JPanel();
        pSuperior.setBackground(Color.green);
        pSuperior.setVisible(true);
        propriedades.fill = GridBagConstraints.BOTH; // Expansão tanto na horizontal quanto vertical
        propriedades.weightx = 1; //Mantém a largura do painel de acordo com a largura da janela
        propriedades.weighty = 0.25; //Mantém a altura do painel com 25% da altura da janela 
        propriedades.gridx = 0; //Posiciona o painel na primeira linha e coluna do gridlayout 
        propriedades.gridy = 0;
        propriedades.gridwidth = 2; // Estabelece que o painel ocupara duas células do grid
        add(pSuperior, propriedades);
        
        propriedades.gridwidth = 1; // Reestabelce que o gridwidth padrão é de uma coluna. Observe que o mesmo objeto de propriedades está sendo utilizado para todos os paineis.
        // -- Definição do painel esquerdo -------------------------------------
        JPanel pEsquerda = new JPanel();
        pEsquerda.setBackground(Color.ORANGE);
        pEsquerda.setVisible(true);
        propriedades.fill = GridBagConstraints.BOTH; // Expansão tanto na horizontal quanto vertical
        propriedades.weightx = 0.5; //Mantém a largura do painel com 50% da largura da janela
        propriedades.weighty = 0.75; //Mantém a altura do painel com 75% da altura da janela 
        propriedades.gridx = 0; //Posiciona o painel na segunda linha e primeira coluna do gridlayout 
        propriedades.gridy = 1;
        add(pEsquerda, propriedades);
        
        // -- Definição do painel esquerdo -------------------------------------
        JPanel pDireita = new JPanel();
        pDireita.setBackground(Color.CYAN);
        pDireita.setVisible(true);
        propriedades.fill = GridBagConstraints.BOTH; // Expansão tanto na horizontal quanto vertical
        propriedades.weightx = 0.5; //Mantém a largura do painel com 50% da largura da janela
        propriedades.weighty = 0.75; //Mantém a altura do painel com 75% da altura da janela 
        propriedades.gridx = 1; //Posiciona o painel na segunda linha e segunda coluna do gridlayout 
        propriedades.gridy = 1;
        add(pDireita, propriedades); 
        
        this.setVisible(true);
    }
    public static void main(String[] args) {
        GridBagLayoutDemo exemplo = new GridBagLayoutDemo();
        exemplo.mostrarJanela();
    }
}
