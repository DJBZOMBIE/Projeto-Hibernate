package br.projetoH.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projetoH.controller.PedidoController;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;
import br.projetoH.model.Pedido;
import br.projetoH.model.PedidoTableModel;

public class TelaPedido extends JFrame {
	private PedidoController controller = new PedidoController();
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	private ArrayList<Item> newList2 = new ArrayList<Item>();
	private ArrayList<Cliente> newListCli = new ArrayList<Cliente>();
	private PedidoTableModel model = new PedidoTableModel(newList);
	
	//private itemTableModel model2 = new itemTableModel(newList2);
	
	private JTable table = new JTable(/*model*/);
	private JTable table2 = new JTable(/*model2*/);
	private JLabel lbBuscar = new JLabel("Itens do Pedido (ID):");
	private JLabel lbBuscarP = new JLabel("Buscar Pedido (ID):");
	
	private JTextField txPesquisa = new JTextField();
	private JTextField txPesquisaP = new JTextField();
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	private JPanel pnTab2 = new JPanel();
	private JButton btbuscar = new JButton("Verificar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btRemove = new JButton("Remover");
	private JButton btBuscarP = new JButton("Buscar");
	
	public TelaPedido(){
		//this.controller = controller;
	}
	
	public void init(){
		congifurepnTab2();
		congifurepnTab();
		configureBtSalvar();
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		GBC gbc11 = new GBC(5,1);
		pnBase.add(pnTab,gbc11);
		pnBase.add(pnTab2,gbc10);
		
		super.setTitle("Tela Pedidos");
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
public void congifurepnTab2(){
		
		JScrollPane scroll = new JScrollPane(table);
		GridBagLayout layoutData = new GridBagLayout();
		pnTab2.setLayout(layoutData);
		
		GBC gbc1 = new GBC(0,9).setSpan(1, 1);
		GBC gbc2 = new GBC(2,9).setSpan(1, 1);
		GBC gbc8 = new GBC(1,9).setSpan(1, 1);
		GBC gbc3 = new GBC(0,6).setSpan(1, 1);//botoes
		GBC gbc4 = new GBC(1,6).setSpan(1, 1);
		GBC gbc6 = new GBC(2,6).setSpan(1, 1);//fim botoes
		GBC gbc7 = new GBC(0,3).setSpan(6,3);
		GBC gbc9 = new GBC(0,1).setSpan(1, 1);
		GBC gbc10 = new GBC(1,1).setSpan(1, 1);
		GBC gbc11 = new GBC(2,1).setSpan(1, 1);

		pnTab2.add(lbBuscar,gbc1);
		pnTab2.add(btbuscar,gbc2);
		pnTab2.add(txPesquisa,gbc8);
		pnTab2.add(btList, gbc3);
		pnTab2.add(btNovo, gbc4);
		pnTab2.add(btRemove, gbc6);
		pnTab2.add(scroll, gbc7);
		pnTab2.add(lbBuscarP,gbc9);
		pnTab2.add(txPesquisaP,gbc10);
		pnTab2.add(btBuscarP,gbc11);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Pedidos");
		pnTab2.setBorder(border);
		
		super.setContentPane(pnTab2);
		super.setVisible(true);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

//painel itens
	public void congifurepnTab(){
		JScrollPane scroll2 = new JScrollPane(table2);
		GridBagLayout layoutData2 = new GridBagLayout();
		pnTab.setLayout(layoutData2);
		GBC gbc9 = new GBC(1,8).setSpan(6, 3);
	
		pnTab.add(scroll2,gbc9);
	
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Itens do Pedido");
		pnTab.setBorder(border);

		super.setSize(300, 400);
		super.setContentPane(pnTab);
		super.setVisible(true);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
	
	//botao salvar
	
	private void configureBtSalvar(){
		ActionListener autenticao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButtomBtSalvarActionPerformed();
				
			}
			
		};
		btNovo.addActionListener(autenticao);
	}
	
	private void JButtomBtSalvarActionPerformed(){
		TelaCadastroPedido tlPed = new TelaCadastroPedido();
		tlPed.init();
	}
}
