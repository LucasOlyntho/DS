package Menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Pedido;
import DAO.PedidoDAO;

public class FrmPedido extends JDialog {
	
	private JLabel lbNomeCliente, lbProduto, lbQuantidade, lbValor, lbData;
    private JTextField txNomeCliente, txProduto, txQuantidade, txValor, txData;
    private JButton btCadastrar;
    
    Pedido pedido = new Pedido();
    PedidoDAO pedidodao = new PedidoDAO();
    
    

    public FrmPedido() {
        this.setTitle("Cadastro de Pedido");
        this.setModal(true);
        this.setSize(500, 470);
        this.setResizable(false);
        
        Container janelacalc = this.getContentPane();
	     setLocationRelativeTo(janelacalc);
	     janelacalc.setLayout(null);
    
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 500, 470); 

        lbNomeCliente = new JLabel("Cliente:");
        lbNomeCliente.setBounds(20, 20, 80, 25);  
        painel.add(lbNomeCliente);

        txNomeCliente = new JTextField();
        txNomeCliente.setBounds(100, 20, 250, 25);
        painel.add(txNomeCliente);

        lbProduto = new JLabel("Produto:");
        lbProduto.setBounds(20, 60, 80, 25);
        painel.add(lbProduto);

        txProduto = new JTextField();
        txProduto.setBounds(100, 60, 250, 25);
        painel.add(txProduto);

        lbQuantidade = new JLabel("Quantidade:");
        lbQuantidade.setBounds(20, 100, 80, 25);
        painel.add(lbQuantidade);

        txQuantidade = new JTextField();
        txQuantidade.setBounds(100, 100, 250, 25);
        painel.add(txQuantidade);

        lbValor = new JLabel("Valor:");
        lbValor.setBounds(20, 140, 80, 25);
        painel.add(lbValor);

        txValor = new JTextField();
        txValor.setBounds(100, 140, 250, 25);
        painel.add(txValor);

        lbData = new JLabel("Data:");
        lbData.setBounds(20, 180, 80, 25);
        painel.add(lbData);

        txData = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        txData.setBounds(100, 180, 250, 25);
        painel.add(txData);

     
        btCadastrar = new JButton("Cadastrar");
        btCadastrar.setBounds(140, 230, 120, 30); 
        painel.add(btCadastrar);

        EventoBotao evb = new EventoBotao();
        btCadastrar.addActionListener(evb);
        
        janelacalc.add(painel); 

    }
    
    private class EventoBotao implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null,
                "Cliente: " + txNomeCliente.getText() + 
                "\nProduto: " + txProduto.getText() + 
                "\nQuantidade: " + txQuantidade.getText() + 
                "\nValor: " + txValor.getText() + 
                "\nData: " + txData.getText()
            );
            
            pedido.setNomePedido(txNomeCliente.getText());
            pedido.setProdutoPedido(txProduto.getText());
            pedido.setQuantidadePedido(Integer.parseInt(txQuantidade.getText()));
            pedido.setValorPedido(Float.parseFloat(txValor.getText()));
            pedido.setDataPedido(txData.getText());
            
            try {
				pedidodao.insert(pedido);
			} catch (SQLException e) {
				System.out.println("Erro: "+e);
			}
        }
    }


}
