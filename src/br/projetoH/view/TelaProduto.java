package br.projetoH.view;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaProduto extends JFrame{
	//private produtoController controller = new produtoController();
		//private ArrayList<Produto> newList = new ArrayList<Produto>();
		//private ProdutoTableModel model = new ProdutoTableModel(newList);
		
		private JTable table = new JTable(/*model*/);
		private JLabel lbCod = new JLabel("Pesquisar por (ID):");
		private JTextField txCod = new JTextField();
		private JPanel pnBase = new JPanel();
		private JPanel pnTab = new JPanel();
		
		private JButton btbuscar = new JButton("Buscar");
		private JButton btList = new JButton("Listar");
		private JButton btNovo = new JButton("Novo");
		private JButton btAlt = new JButton("Alterar");
		private JButton btRemove = new JButton("Remover");
		
		public TelaProduto(){
			
		}
		
		public void init(){
			configurePnTab();
			GridBagLayout layoutData = new GridBagLayout();
			pnBase.setLayout(layoutData);
			
			GBC gbc10 = new GBC(1,1);
			pnBase.add(pnTab,gbc10);
			
			super.setTitle("Tela Produto");
			super.setSize(200, 300);
			super.setContentPane(pnBase);
			super.setVisible(true);
			super.pack();
			super.setLocationRelativeTo(null);
			super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar não irá fechar o form principal
		}
		
		public void configurePnTab(){
			
			JScrollPane scroll = new JScrollPane(table);
			GridBagLayout layoutData = new GridBagLayout();
			
			
			pnTab.setLayout(layoutData);
			
			GBC gbc1 = new GBC(1,1).setSpan(1, 1);
			GBC gbc2 = new GBC(2,1).setSpan(3, 1);
			GBC gbc8 = new GBC(5,1).setSpan(1, 1);
			GBC gbc3 = new GBC(1,8).setSpan(1, 1);//botoes
			GBC gbc4 = new GBC(2,8).setSpan(1, 1);
			GBC gbc5 = new GBC(3,8).setSpan(1, 1);
			GBC gbc6 = new GBC(4,8).setSpan(1, 1);//fim botoes
			GBC gbc7 = new GBC(1,3).setSpan(6, 3);
			pnTab.add(lbCod, gbc1);
			pnTab.add(txCod, gbc2);
			pnTab.add(btList, gbc3);
			pnTab.add(btNovo, gbc4);
			pnTab.add(btAlt, gbc5);
			pnTab.add(btRemove, gbc6);
			pnTab.add(scroll, gbc7);
			pnTab.add(btbuscar,gbc8);
			
			LineBorder colorBorder = new LineBorder(Color.darkGray);
			TitledBorder border = new TitledBorder(colorBorder, "Produto");
			pnTab.setBorder(border);
			
			
			
			super.setSize(200, 300);
			super.setContentPane(pnTab);
			super.setVisible(true);
			super.pack();
		}
}
