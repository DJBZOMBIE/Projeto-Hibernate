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

import br.projetoH.controller.ClienteController;
import br.projetoH.model.Cliente;
import br.projetoH.model.ClienteTableModel;

public class TelaCliente extends JFrame{
	private ClienteController controller = new ClienteController();
	private ArrayList<Cliente> newList = new ArrayList<Cliente>();
	private ClienteTableModel model = new ClienteTableModel(newList);
	
	
	private JTable table = new JTable(model);
	private JLabel lbCod = new JLabel("Pesquisar por (ID):");
	private JTextField txCod = new JTextField();
	private JPanel pnBase = new JPanel();
	private JPanel pnTab = new JPanel();
	
	private JButton btbuscar = new JButton("Buscar");
	private JButton btList = new JButton("Listar");
	private JButton btNovo = new JButton("Novo");
	private JButton btAlt = new JButton("Alterar");
	private JButton btRemove = new JButton("Remover");
	
	public TelaCliente(){
		
	}

	public void init(){
		configureBtInserir();
		configureBtAlterar();
		configurePnTab();
		configureBtListar();
		configureBtRemover();
		configureBtPesquisar();
		
		GridBagLayout layoutData = new GridBagLayout();
		pnBase.setLayout(layoutData);
		
		GBC gbc10 = new GBC(1,1);
		pnBase.add(pnTab,gbc10);
		
		super.setTitle("Tela Cliente");
		super.setSize(200, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //quando clicar em fechar n�o ir� fechar o form principal
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
			TitledBorder border = new TitledBorder(colorBorder, "Cliente");
			pnTab.setBorder(border);
			
			
			
			super.setSize(200, 300);
			super.setContentPane(pnTab);
			super.setVisible(true);
			super.pack();
		}
		
		//botao listar
		private void configureBtListar(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try{
						JButtomListarClientes();
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			};
			btList.addActionListener(autenticacao);
		}
		
		private void JButtomListarClientes() throws Exception{
			model.setColumnIdentifiers(new String[]{"Cod","Nome","Email"});
			this.newList = (ArrayList<Cliente>) controller.listarClientes();
			for(int i = 0; i< newList.size();i++){
				model.addRow(new Object[]{this.newList.get(i).getCod(), this.newList.get(i).getNome(),this.newList.get(i).getEmail()});
			}
		}
		
		//botao inserir
		private void configureBtInserir(){
			ActionListener autenticacao = new ActionListener(){
		
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomInserirCliente();
					
				}
				
			};
			btNovo.addActionListener(autenticacao);
		}
		
		private void JButtomInserirCliente(){
			TelaCadastroCliente tlCad = new TelaCadastroCliente();
			tlCad.init();
		}
		
		//botao alterar
		private void configureBtAlterar(){
			ActionListener autenticacao = new ActionListener(){
		
				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomAlterarCliente();
					
				}
				
			};
			btAlt.addActionListener(autenticacao);
		}
		
		private void JButtomAlterarCliente(){
			TelaAlterarCliente tlAlt = new TelaAlterarCliente();
			tlAlt.init();
		}
		//botao remover
		private void configureBtRemover(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JButtomRemoverClientes();
					
				}
				
			};
			btRemove.addActionListener(autenticacao);
		}
		
		private void JButtomRemoverClientes(){
			Cliente i = this.newList.get(table.getSelectedRow());
			try{
				controller.excluir(i.getCod());
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		//pesquisar
		private void configureBtPesquisar(){
			ActionListener autenticacao = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JButtonBuscar();
				}
				
			};
			btbuscar.addActionListener(autenticacao);
		}
		
		private void JButtonBuscar(){
			int numero;
			String valor;
			model.setColumnIdentifiers(new String[]{"Cod","Nome","Email"});
			try{
				Cliente cli = new Cliente();
				try{
					valor = txCod.getText();
					numero = Integer.parseInt(valor);
					if(controller.buscarId(numero)==1){
						cli = controller.buscarIdD(numero);
					}else{
						throw new Exception("O id: "+numero+" n�o existe!");
					}
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Digite apenas n�meros inteiros nos campos de n�meros  " +ex);
				}
				
				model.addRow(new Object[]{cli.getCod(),cli.getNome(),cli.getEmail()});
				txCod.setText("");
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Erro ao buscar " +ex);
			}
		}
}
