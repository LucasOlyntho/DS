package Menu;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Menu extends JFrame{
 
    public Menu(){   
              
    	this.setSize(800,600);
    	this.setTitle("Menu Cadastro");
    	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setExtendedState(MAXIMIZED_BOTH);

        JMenu arq = new JMenu("Arquivo");
        JMenu cad = new JMenu("Cadastrar");        
        JMenu aju = new JMenu("Ajuda");
               
        JMenuItem sair = new JMenuItem("Sair"); 
        JMenuItem cat = new JMenuItem("Categoria");
        JMenuItem prod = new JMenuItem("Produto");
        JMenuItem clie = new JMenuItem("Cliente");
        JMenuItem pedi = new JMenuItem("Pedido");
        JMenuItem sobre = new JMenuItem("Sobre");
                      
        arq.add(sair);
        cad.add(cat);
        cad.add(prod);
        cad.add(clie);
        cad.add(pedi);
        aju.add(sobre);
       
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(arq);
        bar.add(cad); 
        bar.add(aju);
             
       sair.addActionListener(
         new ActionListener(){
             public void actionPerformed(ActionEvent event){
               System.exit(0);
             }
         }
       );
       
       cat.addActionListener(
         new ActionListener(){
             public void actionPerformed(ActionEvent event){
            	 FrmCategoria frmCat = new FrmCategoria();
            	 frmCat.setVisible(true);
             }
         }
       );
       
       prod.addActionListener(
    	         new ActionListener(){
    	             public void actionPerformed(ActionEvent event){
    	            	 FrmProduto frmProd = new FrmProduto();
    	            	 frmProd.setVisible(true);
    	             }
    	         }
    	       );
       
       clie.addActionListener(
    	         new ActionListener(){
    	             public void actionPerformed(ActionEvent event){
    	            	 FrmCliente frmCli = new FrmCliente();
    	            	 frmCli.setVisible(true);
    	             }
    	         }
    	       );
       
       pedi.addActionListener(
    	         new ActionListener(){
    	             public void actionPerformed(ActionEvent event){
    	            	 FrmPedido frmPedi = new FrmPedido();
    	            	 frmPedi.setVisible(true);
    	             }
    	         }
    	       );
       
       sobre.addActionListener(
    	         new ActionListener(){
    	             public void actionPerformed(ActionEvent event){
    	            	 Sobre pagSobre = new Sobre();
    	            	 pagSobre.setVisible(true);
    	             }
    	         }
    	       );
       
      this.setVisible(true);
    } 
}