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

import br.projetoH.bi.PedidoBI;
import br.projetoH.bi.PedidoException;
import br.projetoH.controller.ClienteController;
import br.projetoH.controller.PedidoController;
import br.projetoH.controller.ProdutoController;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;
import br.projetoH.model.Pedido;
import br.projetoH.model.Produto;

public class TelaCadastroPedido extends JFrame {
	private PedidoController controller = new PedidoController();
	private ClienteController controllerCliente = new ClienteController();
	private ProdutoController controllerProd = new ProdutoController();
	
	private JLabel lbCodCliente = new JLabel("ID do Cliente:");
	private JLabel lbCodProduto = new JLabel("ID do Produto:");
	private JLabel lbCodPedido = new JLabel("ID do Pedido:");
	
	private JLabel lbCodQuantidade = new JLabel("Quantidade de Itens:");
	
	private JTextField txCodCliente = new JTextField(8);
	private JTextField txCodProduto = new JTextField(8);
	private JTextField txQuantidade = new JTextField(10);
	private JTextField txCodPedido = new JTextField(8);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	private JButton btSalvarPedido = new JButton("Salvar Pedido");
	
	private JPanel pnMain = new JPanel();
	private JPanel pnBase= new JPanel();
	private JPanel pnBot= new JPanel();
	private JPanel pnPed = new JPanel();
	
	public TelaCadastroPedido(){
		
	}
	public void init(){
		configurePnBotao();
		configurePnBase();
		configureBtSalvar();
		configureBtCancelar();
		configurePnPedido();
		configureBtSalvarP();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		GBC gbc9 = new GBC(2,1);
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,3);
		
		pnMain.add(pnPed, gbc9);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Novo Pedido");
		super.setContentPane(pnMain);
		super.setVisible(true);
		super.setPreferredSize(new Dimension(420,250));
		super.setLocationRelativeTo(null);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	public void configurePnBase(){
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,5).setSpan(1, 3);
		GBC gbc2 = new GBC(2,5).setSpan(4, 3);
		GBC gbc3 = new GBC(1,8).setSpan(1, 3);
		GBC gbc4 = new GBC(2,8).setSpan(3, 3);
		GBC gbc5 = new GBC(1,11).setSpan(1, 3);
		GBC gbc6 = new GBC(2,11).setSpan(3, 3);
		
		pnBase.add(lbCodPedido, gbc1);
		pnBase.add(txCodPedido, gbc2);
		pnBase.add(lbCodProduto, gbc3);
		pnBase.add(txCodProduto, gbc4);
		pnBase.add(lbCodQuantidade, gbc5);
		pnBase.add(txQuantidade, gbc6);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastrar Itens do Pedido");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnPedido(){
		GridBagLayout layoutData = new GridBagLayout();
		pnPed.setLayout(layoutData);
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		
		pnPed.add(lbCodCliente, gbc1);
		pnPed.add(txCodCliente, gbc2);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastrar Pedido");
		pnPed.setBorder(border);
		
		super.setContentPane(pnPed);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,14).setSpan(1, 1);
		GBC gbc10 = new GBC(4,14).setSpan(1, 1);
		GBC gbc11 = new GBC(2,14).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		pnBot.add(btSalvarPedido, gbc11);
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
		
		
	}
	
	//botao salvarItem
	private void configureBtSalvar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JButtomSalvarItemActionPerformed();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		btSalvar.addActionListener(lstAutenticacao);
	}
	//botao salvarPedido
	private void configureBtSalvarP(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JButtomSalvarPedidoActionPerformed();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		};
		btSalvarPedido.addActionListener(lstAutenticacao);
	}
	private void JButtomSalvarPedidoActionPerformed()throws Exception{
		int codCli;
		String valorCli;
		
		try{
			Cliente cliente = new Cliente();
			try{
				valorCli = txCodCliente.getText();
				codCli = Integer.parseInt(valorCli);
				if(controllerCliente.buscarId(codCli)==1){
					cliente = controllerCliente.buscarIdD(codCli);
				}else{
					throw new Exception("Erro: O id "+codCli+" não existe");
				}
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas números inteiros nos campos de números  " +ex);
			}
			PedidoBI.criarPedido(cliente);
			txCodCliente.setText("");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro o id do cliente não existe");
		}
	}
	
	private void JButtomSalvarItemActionPerformed() throws Exception{
		int codPed, codProd,quantidade;
		String valorPed, valorProd,valorQuant;
		try{
			Pedido ped = new Pedido();
			
			Produto produto = new Produto();
			ProdutoDao prod = new ProdutoDao();
			
			ArrayList<Item> itens = new ArrayList<Item>();
			Item item1 = new Item();
			
			try{
				valorPed = txCodPedido.getText();
				codPed = Integer.parseInt(valorPed);
				if(controller.buscarId2(codPed)==1){
					ped = controller.buscarId(codPed); //passa o id do pedido
				}else{
					JOptionPane.showMessageDialog(null,"Erro: O id "+codPed+" não existe!");
					throw new Exception("Erro: O id "+codPed+" não existe!");
				}
				
				valorProd = txCodProduto.getText();
				codProd = Integer.parseInt(valorProd);
				if(controllerProd.buscarId2(codProd)==1){
					produto = prod.findById(codProd);
				}else{
					JOptionPane.showMessageDialog(null,"Erro: O id "+codProd+" não existe!");
					throw new Exception("Erro: O id "+codProd+" não existe!");
				}
				
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas números inteiros nos campos de números  " +ex);
			}
			item1.setProduto(produto);
			try{
				valorQuant = txQuantidade.getText();
				quantidade = Integer.parseInt(valorQuant);
				item1.setQuantidade(quantidade);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Digite apenas números inteiros nos campos de números  " +ex);
			}
			itens.add(item1);
			PedidoBI.createPedidoItem(ped, itens);
			JOptionPane.showMessageDialog(null, "Itens do Pedido: "+ped.getCod()+ "Cadastrados");
		}catch(PedidoException exception){
			JOptionPane.showMessageDialog(this, "Produto " + exception.getProduct().getNome() + " não tem saldo suficiente para a venda de " + exception.getQuantity() + " itens");
		}
	}
	
	private void configureBtCancelar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButtomCancelarActionPerformed();
				
			}
			
		};
		btCancelar.addActionListener(lstAutenticacao);
	}
	
	private void JButtomCancelarActionPerformed(){
		this.dispose();
	}
	
}

