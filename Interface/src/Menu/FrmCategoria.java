package Menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Model.Categoria;
import DAO.CategoriaDAO;

public class FrmCategoria extends JDialog {
	
	private JLabel lbNomeCategoria, lbTipoCategoria;
	private JTextField txNomeCategoria, txTipoCategoria;
	private JButton btCadastrar;
	Categoria categoria = new Categoria();
    CategoriaDAO categoriadao = new CategoriaDAO();
	
	public FrmCategoria() {		
		this.setTitle("Cadastro de Categorias");
	    this.setModal(true);
	    this.setSize(500,470);  
	    this.setResizable(false);
	    
	    Container janelacalc = this.getContentPane();
	     setLocationRelativeTo(janelacalc);
	     janelacalc.setLayout(null);
	     
	     JPanel painel1 = new JPanel();
		  painel1.setLayout(null);
		  painel1.setBounds(0, 0, 500, 470);
		  
		  lbNomeCategoria = new JLabel("Nome:");
		  lbNomeCategoria.setBounds(20,20,150,20);     
		  painel1.add(lbNomeCategoria);   
		     
		  txNomeCategoria = new JTextField();
		  txNomeCategoria.setBounds(120, 20, 250, 25);
		  painel1.add(txNomeCategoria);
		  
		  lbTipoCategoria = new JLabel("Tipo de Produto:");
		  lbTipoCategoria.setBounds(20,60,150,20);     
		  painel1.add(lbTipoCategoria);   
		     
		  txTipoCategoria = new JTextField();
		  txTipoCategoria.setBounds(120, 60, 250, 25);
		  painel1.add(txTipoCategoria);
		  
		  btCadastrar = new JButton("Cadastrar");
		  btCadastrar.setBounds(170, 230, 120, 30);
		  painel1.add(btCadastrar);
		
		  EventoBotao evb = new EventoBotao();
		  btCadastrar.addActionListener(evb);
		  
		  janelacalc.add(painel1); 
		  
	}
	
	 private class EventoBotao implements ActionListener{
	       public void actionPerformed(ActionEvent event){
	    	   	JOptionPane.showMessageDialog(null,
	    	   			"Nome: "+txNomeCategoria.getText()+
	    	   			"\nTipo de Produto: "+txTipoCategoria.getText());
	    	   	
	    	   	categoria.setNomeCategoria(txNomeCategoria.getText());
				categoria.setTipoProdutoCategoria(txTipoCategoria.getName());
				
				try {
					categoriadao.insert(categoria);
				} catch (SQLException e) {
					System.out.println("Erro: "+e);
				}
	        }   
	   }   

}
