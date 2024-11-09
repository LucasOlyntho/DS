package Menu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Model.Cliente;
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.TelefoneDAO;

public class FrmCliente extends JDialog{
   	
	private JLabel lbNomeCliente, lbEmailCliente, lbCpfCliente, lbRua, lbNumero, lbBairro, lbCidade, lbEstado, lbTipoTelefone, lbNumeroTelefone;  
	private JTextField txNomeCliente, txEmailCliente,txCpfCliente, txRua, txNumero, txBairro, txCidade, txEstado, txNumeroTelefone;
	private JComboBox cbTipoTelefone;
	private JButton btCadastrar;
	
	Cliente cliente = new Cliente();
	TelefoneDAO telefonedao = new TelefoneDAO();
	EnderecoDAO enderecodao = new EnderecoDAO();
	ClienteDAO clientedao = new ClienteDAO();
	

   public FrmCliente(){     
     this.setTitle("Cadastro de Clientes");
     this.setModal(true);
     this.setSize(500,470);  
     this.setResizable(false);  
   
     Container janelacalc = this.getContentPane();
     setLocationRelativeTo(janelacalc);
     janelacalc.setLayout(null);
    
     //cria o JTabbedPane
     JTabbedPane tabbedpane = new JTabbedPane();
  
     //Primeira guia
  
     //tamanho e posicionamento do JTabbedPane
     tabbedpane.setBounds(0,0,500,470);     
  
	  JPanel painel1 = new JPanel();
	  painel1.setLayout(null);
	  
	  
	  lbNomeCliente = new JLabel("Nome:");
	  lbNomeCliente.setBounds(20,20,80,25);     
	  painel1.add(lbNomeCliente);   
	     
	  txNomeCliente = new JTextField();
	  txNomeCliente.setBounds(100, 15, 250, 25);
	  painel1.add(txNomeCliente);
	  
	  lbEmailCliente = new JLabel("E-mail:");
      lbEmailCliente.setBounds(20, 60, 80, 25);
      painel1.add(lbEmailCliente);

      txEmailCliente = new JTextField();
      txEmailCliente.setBounds(100, 60, 250, 25);
      painel1.add(txEmailCliente);
      
      
      lbCpfCliente = new JLabel("CPF:");
      lbCpfCliente.setBounds(20, 100, 80, 25);
      painel1.add(lbCpfCliente);

      txCpfCliente = new JTextField();
      txCpfCliente.setBounds(100, 100, 250, 25);
      painel1.add(txCpfCliente);
	  
	  btCadastrar = new JButton("Cadastrar");
	  btCadastrar.setBounds(170, 230, 120, 30);
	  painel1.add(btCadastrar);
	
	  EventoBotao evb = new EventoBotao();
	  btCadastrar.addActionListener(evb);
	  
	  tabbedpane.addTab("Aba 1", null,painel1,"Primeiro Painel");
	  
	  //segunda guia  
	  JPanel painel2 = new JPanel();
	  painel2.setLayout(null);
	  
	  lbRua = new JLabel("Rua:");
      lbRua.setBounds(20, 20, 80, 25);
      painel2.add(lbRua);

      txRua = new JTextField();
      txRua.setBounds(100, 20, 250, 25);
      painel2.add(txRua);

      lbNumero = new JLabel("Número:");
      lbNumero.setBounds(20, 60, 80, 25);
      painel2.add(lbNumero);

      txNumero = new JTextField();
      txNumero.setBounds(100, 60, 250, 25);
      painel2.add(txNumero);

      lbBairro = new JLabel("Bairro:");
      lbBairro.setBounds(20, 100, 80, 25);
      painel2.add(lbBairro);

      txBairro = new JTextField();
      txBairro.setBounds(100, 100, 250, 25);
      painel2.add(txBairro);

      lbCidade = new JLabel("Cidade:");
      lbCidade.setBounds(20, 140, 80, 25);
      painel2.add(lbCidade);

      txCidade = new JTextField();
      txCidade.setBounds(100, 140, 250, 25);
      painel2.add(txCidade);

      lbEstado = new JLabel("Estado:");
      lbEstado.setBounds(20, 180, 80, 25);
      painel2.add(lbEstado);

      txEstado = new JTextField();
      txEstado.setBounds(100, 180, 250, 25);
      painel2.add(txEstado);
      
      btCadastrar = new JButton("Cadastrar");
      btCadastrar.setBounds(140, 230, 120, 30);
      painel2.add(btCadastrar);
      
      EventoBotao2 evb2 = new EventoBotao2();
	  btCadastrar.addActionListener(evb2);
	 
	  
	  tabbedpane.addTab("Aba 2", null,painel2,"Segundo Painel");  
	  
	  //terceira guia
	  JPanel painel3 = new JPanel(); 
	  painel3.setLayout(null);
	  
	  lbTipoTelefone = new JLabel("Tipo:");
      lbTipoTelefone.setBounds(20, 20, 80, 25);
      painel3.add(lbTipoTelefone);

      String[] tipos = {"Residencial", "Celular"};
      cbTipoTelefone = new JComboBox<>(tipos);
      cbTipoTelefone.setBounds(100, 20, 150, 25);
      painel3.add(cbTipoTelefone);

      lbNumeroTelefone = new JLabel("Numero:");
      lbNumeroTelefone.setBounds(20, 60, 80, 25);
      painel3.add(lbNumeroTelefone);

      txNumeroTelefone = new JTextField();
      txNumeroTelefone.setBounds(100, 60, 250, 25);
      painel3.add(txNumeroTelefone);

      btCadastrar = new JButton("Cadastrar");
      btCadastrar.setBounds(140, 120, 120, 30);
      painel3.add(btCadastrar);
      
      EventoBotao3 evb3 = new EventoBotao3();
      btCadastrar.addActionListener(evb3);
	  
	  tabbedpane.addTab("Aba 3", null,painel3,"Terceiro Painel");  
	
	  janelacalc.add(tabbedpane);   

  }
   
   private class EventoBotao2 implements ActionListener {
       public void actionPerformed(ActionEvent event) {
           JOptionPane.showMessageDialog(null,
               "Rua: " + txRua.getText() +
               "\nNumero: " + txNumero.getText() + 
               "\nBairro: " + txBairro.getText() + 
               "\nCidade: " + txCidade.getText() +
               "\nEstado: " + txEstado.getText()
           );
           cliente.setNumeroEndereco(txNumero.getText());
           cliente.setBairroEndereco(txBairro.getText());
           cliente.setCidadeEndereco(txCidade.getText());
           cliente.setEstadoEndereco(txEstado.getText());
           
           try {
				clientedao.insert(cliente);
			} catch (SQLException e) {
				System.out.println("Erro: "+e);
			}
       }
   }
   
   private class EventoBotao implements ActionListener {
       public void actionPerformed(ActionEvent event) {
           JOptionPane.showMessageDialog(null, 
               "Nome: " + txNomeCliente.getText() +
               "\nE-mail: " + txEmailCliente.getText()
               + "\nCpf: " + txCpfCliente.getText()
               
           );
           cliente.setNomeCliente(txNomeCliente.getText());
           cliente.setEmailCliente(txEmailCliente.getText());
           cliente.setCpfCliente(txCpfCliente.getText());
           
           try {
				clientedao.insert(cliente);
			} catch (SQLException e) {
				System.out.println("Erro: "+e);
			}
       }
   }
   
   private class EventoBotao3 implements ActionListener {
       public void actionPerformed(ActionEvent event) {
           JOptionPane.showMessageDialog(null,
               "Tipo de Telefone: " + cbTipoTelefone.getSelectedItem() +
               "\nNumero: " + txNumeroTelefone.getText()
           );
           cliente.setTipoTelefone(cbTipoTelefone.getSelectedItem().toString());
           cliente.setNumeroTelefone(txNumeroTelefone.getText());
           
           try {
				clientedao.insert(cliente);
			} catch (SQLException e) {
				System.out.println("Erro: "+e);
			}
       }
   }
   
}