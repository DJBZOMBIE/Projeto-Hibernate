package br.projetoH.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projetoH.controller.ProdutoController;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;
import br.projetoH.model.ProdutoTableModel;

public class TelaProduto extends JFrame{
	    private ProdutoController controller = new ProdutoController();
		private ArrayList<Produto> newList = new ArrayList<Produto>();
		private ProdutoTableModel model = new ProdutoTableModel(newList);
		
		
		private JTable table = new JTable(model);
		private JLabel lbCod = new JLabel("Pesquisar por (ID):");
		private JTextField txCod = new JTextField();
		private JPanel pnBase = new JPanel();
		private JPanel pnTab = new JPanel();
		
		private JButton btbuscar = new JButton("Buscar");
		private JButton btList = new JButton("Listar");
		private JButton btNovo = new JButton("Inserir");
		private JButton btAlt = new JButton("Alterar");
		private JButton btRemove = new JButton("Remover");
		
		public TelaProduto(){
			
		}
		
		public void init(){
			configurePnTab();
			configureBtListar();
			configureBtInserir();
			configureBtAlterar();
			configureBtRemover();
			configureBtPesquisar();
			
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
		
		//botao Listar
		private void configureBtListar(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						JButtomListarProdutos();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			btList.addActionListener(autenticacao);
		}
		private void JButtomListarProdutos() throws Exception{
			model.setColumnIdentifiers(new String[]{"Cod","Nome","Saldo"});
			this.newList = (ArrayList<Produto>) controller.listarProdutos();
			for(int i = 0; i< newList.size(); i++){
				model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(), this.newList.get(i).getSaldo()});
			}
			
		}
		
		//botao inserir
		private void configureBtInserir(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomInserirProduto();
					
				}
				
			};
			btNovo.addActionListener(autenticacao);
		}
		
		private void JButtomInserirProduto(){
			TelaCadastroProduto tlCad = new TelaCadastroProduto();
			tlCad.init();
		}
		
		//botao alterar
		private void configureBtAlterar(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomAlterarProduto();
					
				}
				
			};
			btAlt.addActionListener(autenticacao);
		}
		
		private void JButtomAlterarProduto(){
			TelaAlterarProduto tlAlt = new TelaAlterarProduto();
			tlAlt.init();
		}
		
		//botao remover
		private void configureBtRemover(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JButtomRemoverProdutos();
				}
				
			};
			btRemove.addActionListener(autenticacao);
		}
		
		private void JButtomRemoverProdutos(){
			Produto i = this.newList.get(table.getSelectedRow());
			
			try{
				controller.excluir(i.getCod());
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
		
		//botão pesquisar
		private void configureBtPesquisar(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						JButtonBuscar();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			btbuscar.addActionListener(autenticacao);
		}
		private void JButtonBuscar() throws Exception{
			int numero;
			String valor;
			model.setColumnIdentifiers(new String[]{"Cod","Nome","Saldo"});
			try{
				Produto prod = new Produto();
				
				try{
					valor = txCod.getText();
					numero = Integer.parseInt(valor);
					if(controller.buscarId2(numero)==1){
						prod =  controller.buscarId(numero);
					}else{
						throw new Exception("O id: "+numero+" não existe!");
					
					}
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Digite apenas números inteiros nos campos de números  " +ex);
				}
			
				model.addRow(new Object[]{prod.getCod(), prod.getNome(), prod.getSaldo()});
				txCod.setText("");
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Erro ao buscar " +ex);
			}
		}
}
