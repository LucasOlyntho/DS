package Menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Model.Produto;
import DAO.ProdutoDAO;

public class FrmProduto extends JDialog {

	private JLabel lbNomeProduto, lbTipoProduto, lbQuantidadeProduto, lbMarcaProduto, lbValorProduto;
	private JTextField txNomeProduto, txTipoProduto, txQuantidadeProduto, txMarcaProduto, txValorProduto;
	private JButton btCadastrar;
	
	Produto produto = new Produto(); 
	ProdutoDAO produtodao = new ProdutoDAO();

	public FrmProduto() {
		this.setTitle("Cadastro de Produtos");
		this.setModal(true);
		this.setSize(500, 470);
		this.setResizable(false);

		Container janelacalc = this.getContentPane();
		setLocationRelativeTo(janelacalc);
		janelacalc.setLayout(null);

		JPanel painel1 = new JPanel();
		painel1.setLayout(null);
		painel1.setBounds(0, 0, 500, 470);

		lbNomeProduto = new JLabel("Nome do Produto:");
		lbNomeProduto.setBounds(20, 20, 150, 20);
		painel1.add(lbNomeProduto);

		txNomeProduto = new JTextField();
		txNomeProduto.setBounds(160, 20, 250, 25);
		painel1.add(txNomeProduto);

		lbTipoProduto = new JLabel("Tipo do Produto:");
		lbTipoProduto.setBounds(20, 60, 150, 20);
		painel1.add(lbTipoProduto);

		txTipoProduto = new JTextField();
		txTipoProduto.setBounds(160, 60, 250, 25);
		painel1.add(txTipoProduto);
		
		lbMarcaProduto = new JLabel("Marca do Produto:");
		  lbMarcaProduto.setBounds(20,100,150,20);     
		  painel1.add(lbMarcaProduto);   
		     
		  txMarcaProduto = new JTextField();
		  txMarcaProduto.setBounds(160, 100, 250, 25);
		  painel1.add(txMarcaProduto);
		
		lbQuantidadeProduto = new JLabel("Quantidade do Produto:");
		lbQuantidadeProduto.setBounds(20, 140, 150, 20);
		painel1.add(lbQuantidadeProduto);

		txQuantidadeProduto = new JTextField();
		txQuantidadeProduto.setBounds(160, 140, 250, 25);
		painel1.add(txQuantidadeProduto);
		
		lbValorProduto = new JLabel("Valor do Produto:");
		lbValorProduto.setBounds(20, 180, 150, 20);
		painel1.add(lbValorProduto);

		txValorProduto = new JTextField();
		txValorProduto.setBounds(160, 180, 250, 25);
		painel1.add(txValorProduto);
		

		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(170, 250, 120, 30);
		painel1.add(btCadastrar);

		EventoBotao evb = new EventoBotao();
		btCadastrar.addActionListener(evb);

		janelacalc.add(painel1);
	
	}

	private class EventoBotao implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null,
					"Nome: " + txNomeProduto.getText() + 
					"\nTipo de Produto: " + txTipoProduto.getText() + 
					"\nMarca de Produto: " + txMarcaProduto.getText() + 
					"\nQuantidade de Produto: " + txQuantidadeProduto.getText() +
					"\nValor do Produto: " + txValorProduto.getText());
			
			produto.setNomeProduto(txNomeProduto.getText());
			produto.setTipoProduto(txTipoProduto.getText());
			produto.setMarcaProduto(txMarcaProduto.getText());
			produto.setQuantidadeProduto(Integer.parseInt(txQuantidadeProduto.getText()));
			produto.setValorProduto(Float.parseFloat(txValorProduto.getText()));
			
			try {
				produtodao.insert(produto);
			} catch (SQLException e) {
				System.out.println("Erro: "+e);
			}
		}
	}
}
