package salario; // Mantendo o nome do seu pacote

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter; // Importação necessária
import java.awt.event.MouseEvent; // Importação necessária
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class tela1 {

    private JFrame frame;
    private JButton btnSim; 
    private JButton btnNao;
    private Random random = new Random(); 

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tela1 window = new tela1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria a aplicação.
     */
    public tela1() {
        initialize();
    }

    /**
     * Inicializa o conteúdo do frame.
     */
    private void initialize() {
        frame = new JFrame("O Botão Fugitivo - Mouse");
        frame.setBounds(100, 100, 742, 591);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define Layout Manager como null
        frame.getContentPane().setLayout(null); 
        
        // Botão "Sim"
        btnSim = new JButton("Não");
        btnSim.setBounds(350, 474, 124, 67); 
        frame.getContentPane().add(btnSim);

        // Botão "Não"
        btnNao = new JButton("Sim");
        btnNao.setBounds(58, 474, 124, 67);
        frame.getContentPane().add(btnNao);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(tela1.class.getResource("/imagens/Ea__31zWsAAwjDT.png")));
        lblNewLabel.setBounds(30, 30, 586, 407);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Aumenta meu Salário?");
        lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(488, 30, 247, 108);
        frame.getContentPane().add(lblNewLabel_1);
        
        // ActionListener para o botão "Não" (ação de conclusão)
        btnNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tela2 tel = new tela2();
                tel.visivel();
                frame.dispose();
                
            }
        });

        // ==========================================================
        // === MUDANÇA PRINCIPAL: Usando MouseAdapter para capturar o mouse ===
        // ==========================================================
        btnSim.addMouseListener(new MouseAdapter() {
            
            // Este método é chamado toda vez que o ponteiro do mouse ENTRA na área do botão.
            @Override
            public void mouseEntered(MouseEvent e) {
                // As dimensões precisam ser recalculadas se o frame for redimensionado
                int frameWidth = frame.getContentPane().getWidth();
                int frameHeight = frame.getContentPane().getHeight();
                int buttonWidth = btnSim.getWidth();
                int buttonHeight = btnSim.getHeight();
                
                // Garantir que a largura e altura sejam maiores que zero antes de calcular
                if (frameWidth > buttonWidth && frameHeight > buttonHeight) {
                    
                    // Gerar nova posição X
                    int newX = random.nextInt(frameWidth - buttonWidth); 
                    
                    // Gerar nova posição Y
                    int newY = random.nextInt(frameHeight - buttonHeight);
                    
                    // Reposicionar o botão
                    btnSim.setBounds(newX, newY, buttonWidth, buttonHeight);
                    
                   
                }
            }
        });
    }
}