package br.projetoH.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projetoH.controller.ProdutoController;
import br.projetoH.model.Produto;

public class TelaAlterarProduto extends JFrame{
	private ProdutoController controller = new ProdutoController();
	private JLabel lbCod = new JLabel("ID do produto:");
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbSaldo = new JLabel("Saldo:");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txNome = new JTextField(20);
	private JTextField txSaldo = new JTextField(15);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public TelaAlterarProduto(){
		
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		configureBtSalvar();
		configuteBtCancelar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,5);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Altera��o de Produto");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void configurePnBase(){
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc0 = new GBC(1,1).setSpan(1, 3);
		GBC gbc01 = new GBC(2,1).setSpan(3, 3);
		GBC gbc1 = new GBC(1,5).setSpan(1, 3);
		GBC gbc2 = new GBC(2,5).setSpan(4, 3);
		GBC gbc3 = new GBC(1,8).setSpan(1, 3);
		GBC gbc4 = new GBC(2,8).setSpan(3, 3);
		
		pnBase.add(lbCod,gbc0);
		pnBase.add(txCod,gbc01);
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome,gbc2);
		pnBase.add(lbSaldo,gbc3);
		pnBase.add(txSaldo,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Altera��o de Produto");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,10).setSpan(1, 1);
		GBC gbc10 = new GBC(4,10).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
	}
	
	//botao cancelar
	private void configuteBtCancelar(){
		ActionListener lsAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonCancelarActionPerfomed();
			}

		};
		btCancelar.addActionListener(lsAutenticacao);
	}
	
	private void JButtonCancelarActionPerfomed(){
		this.dispose();
	}
	
	//botao salvar
	private void configureBtSalvar(){
		ActionListener lsAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButtonSalvarActionPerfomed();
			}
			
		};
		btSalvar.addActionListener(lsAutenticacao);
	}
	
	private void JButtonSalvarActionPerfomed(){
		int number1, number2;
		String valor1, valor2;
		
		try{
			Produto prod = new Produto();
			try{
				valor1 = txCod.getText();
				number1 = Integer.parseInt(valor1);
				prod.setCod(number1);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas n�meros inteiros nos campos de n�meros"+ex);
			}
			prod.setNome(txNome.getText());
			try{
				valor2 = txSaldo.getText();
				number2 = Integer.parseInt(valor2);
				prod.setSaldo(number2);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas n�meros inteiros nos campos de n�meros"+ex);
			}
			controller.alterar(prod.getCod(),prod.getNome(),prod.getSaldo());
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
			clearField();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, "Nao foi possivel alterar produto!" + ex.getLocalizedMessage());
		}
	}
	
	private void clearField(){
		txCod.setText("");
		txNome.setText("");
		txSaldo.setText("");
	}
}
