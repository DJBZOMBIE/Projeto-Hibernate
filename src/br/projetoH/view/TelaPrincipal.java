package br.projetoH.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaPrincipal extends JFrame{
	private JPanel pnBase = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btCli = new JButton("Clientes");
	private JButton btPro = new JButton("Produtos");
	private JButton btPed = new JButton("Pedidos");
	private JButton btEntrada = new JButton("Entrada de Estoque");
	
	public TelaPrincipal(){
		
	}
	
	public void init(){
		configurePnBase();
		configureBtProduto();
		configureBtPedido();
		configureBtEntrada();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		GBC gbc1 = new GBC(1,1);
		pnMain.add(pnBase,gbc1);
		
		super.setContentPane(pnMain);
		super.setTitle("Tela Principal");
		super.setVisible(true);
		super.setPreferredSize(new Dimension(300,260));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void configurePnBase(){
		configureBtCliente();
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc1 = new GBC(3,1).setSpan(3, 1);
		GBC gbc2 = new GBC(3,2).setSpan(3, 1);
		GBC gbc3 = new GBC(3,3).setSpan(3, 1);
		GBC gbc4 = new GBC(3,4).setSpan(3, 1);
		
		pnBase.add(btCli,gbc1);
		pnBase.add(btPro,gbc2);
		pnBase.add(btPed,gbc3);
		pnBase.add(btEntrada,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "MENU");
		pnBase.setBorder(border);
			
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	
	//tela cliente
	private void configureBtCliente() {
		ActionListener lstAutenticacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configureBtTelaCliente();
			}
		};
			
		btCli.addActionListener(lstAutenticacao);
	}
		
	private void configureBtTelaCliente(){
		TelaCliente cli = new TelaCliente();
		cli.init();
		
	}
	
	//tela produto
		private void configureBtProduto() {
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					configureBtTelaProduto();
				}
			};
				
			btPro.addActionListener(lstAutenticacao);
		}
			
		private void configureBtTelaProduto(){
			TelaProduto prod = new TelaProduto();
			prod.init();
			
		}
		
	//tela pedido
		private void configureBtPedido() {
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					configureBtTelaPedido();
				}
			};
				
			btPed.addActionListener(lstAutenticacao);
		}
			
		private void configureBtTelaPedido(){
			TelaPedido ped = new TelaPedido();
			ped.init();
			
		}
		//tela entrada estoque
		private void configureBtEntrada() {
			ActionListener lstAutenticacao = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					configureBtTelaEntrada();
				}
			};
				
			btEntrada.addActionListener(lstAutenticacao);
		}
			
		private void configureBtTelaEntrada(){
			TelaEntradaEstoque ent = new TelaEntradaEstoque();
			ent.init();
			
		}
}
