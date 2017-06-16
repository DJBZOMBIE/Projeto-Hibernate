package br.projetoH.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projetoH.controller.ProdutoController;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;

public class TelaEntradaEstoque extends JFrame{
	private ProdutoController controller = new ProdutoController();
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	
	private JLabel lbCod = new JLabel("ID do Produto (Desejado):");
	private JLabel lbQuantidade = new JLabel("Quantidade :");
	
	private JTextField txCod = new JTextField(10);
	private JTextField txQuantidade = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	
	private JButton btSalvar = new JButton("Atualizar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public TelaEntradaEstoque(){
		
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		configureBtSalvar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,6);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Estoque");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.pack();
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
public void configurePnBase(){
		configureBtCancelar();
	
		GridBagLayout layoutData3 = new GridBagLayout();
		pnBase.setLayout(layoutData3);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(1, 3);
		GBC gbc3 = new GBC(1,4).setSpan(1, 3);
		GBC gbc4 = new GBC(2,4).setSpan(1, 3);
		
		pnBase.add(lbCod,gbc1);
		pnBase.add(txCod,gbc2);
		pnBase.add(lbQuantidade,gbc3);
		pnBase.add(txQuantidade,gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Entrada de Estoque");
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
	//botao salvar
	private void configureBtSalvar(){
		ActionListener lsAutenticacao = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButtonSalvarActionPerfomed();
				
			}
			
		};
		btSalvar.addActionListener(lsAutenticacao);
	}
	
	private void JButtonSalvarActionPerfomed(){
		int number,number2;
		String valor,valor2;
		try{
			Produto prod = new Produto();
			ProdutoDao prodDao = new ProdutoDao();
			try{
				valor2 = txCod.getText();
				number2 = Integer.parseInt(valor2);
				valor = txQuantidade.getText();
				number = Integer.parseInt(valor);
				try{
					prod = controller.buscarId(number2);
					prod.setSaldo(prod.getSaldo() + number);
					JOptionPane.showMessageDialog(null, "estoque de produto atualizado!");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"ID não encontrado"+e);
				}
				
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas números inteiros nos campos de números"+ex);
			}
			prodDao.alterar(prod);
			clearField();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, "Nao foi possivel atualizar estoque de produto!" + ex.getLocalizedMessage());
		}
	}
	
	//botao cancelar
	private void configureBtCancelar(){
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
	
	private void clearField(){
		txCod.setText("");
		txQuantidade.setText("");
	}
}
