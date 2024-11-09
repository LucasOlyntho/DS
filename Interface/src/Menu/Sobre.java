package Menu;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Sobre extends JDialog {

	    public Sobre() {
	        this.setTitle("Desenvolvedores");
	        this.setModal(true);
	        this.setSize(600, 450);
	        this.setLayout(new BorderLayout());
	        
	        ImageIcon Lucas = new ImageIcon("src/images/lucas.jpg.jfif");
	        Image LucasRed = Lucas.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); //width, height e hint(hint seria o tipo de redimensionamento, nesse caso sendo o de melhor qualidade)
	        
	        ImageIcon Kaue = new ImageIcon("src/Images/kaue.jpg.jfif");
	        Image KaueRed = Kaue.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	        
	        Object[][] dados = {
	            {new ImageIcon(LucasRed), "Lucas Olyntho"},
	            {new ImageIcon(KaueRed), "Kaue Rodrigues"},
	        };

	        String[] colunas = {"Imagem", "Descricao"};
	        

	        DefaultTableModel sobre = new DefaultTableModel(dados, colunas) {
	        	
	        	 public boolean isCellEditable(int row, int column) {
	                 return false;
	              }
	        	 
	            public Class<?> getColumnClass(int column) {
	                if (column == 0) { 
	                    return ImageIcon.class;
	                } else {
	                    return String.class;
	                }
	            }
	        };

	        JTable tabela = new JTable(sobre);

	        // para centralizar o texto
	        DefaultTableCellRenderer centralizarRenderer = new DefaultTableCellRenderer();
	        centralizarRenderer.setHorizontalAlignment(SwingConstants.CENTER); 
	        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizarRenderer);
	 
	        tabela.setRowHeight(200); 
	        tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
	        this.add(tabela,  BorderLayout.CENTER);
	        this.setLocationRelativeTo(null);
	    }
	}
	
