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

import br.projetoH.controller.ClienteController;
import br.projetoH.model.Cliente;

public class TelaCadastroCliente extends JFrame {
	private ClienteController controller = new ClienteController();
	
	private JLabel lbNome = new JLabel("Nome:");
	private JLabel lbEmail = new JLabel("E-Mail:");
	
	private JTextField txNome = new JTextField(20);
	private JTextField txEmail = new JTextField(20);
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBot = new JPanel();
	private JPanel pnMain = new JPanel();
	private JButton btSalvar = new JButton("Salvar");
	private JButton btCancelar = new JButton("Cancelar");
	
	public TelaCadastroCliente(){
		
	}
	
	public void init(){
		configurePnBase();
		configurePnBotao();
		configureBtSalvar();
		configureBtCancelar();
		GridBagLayout layoutData = new GridBagLayout();
		pnMain.setLayout(layoutData);
		
		GBC gbc10 = new GBC(2,2);
		GBC gbc11 = new GBC(2,3);
		pnMain.add(pnBase,gbc10);
		pnMain.add(pnBot,gbc11);
		
		super.setTitle("Novo Cliente");
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
		
		GBC gbc1 = new GBC(1,1).setSpan(1, 3);
		GBC gbc2 = new GBC(2,1).setSpan(4, 3);
		GBC gbc3 = new GBC(1,5).setSpan(1, 3);
		GBC gbc4 = new GBC(2,5).setSpan(3, 3);
		
		pnBase.add(lbNome,gbc1);
		pnBase.add(txNome, gbc2);
		pnBase.add(lbEmail, gbc3);
		pnBase.add(txEmail, gbc4);
		
		LineBorder colorBorder = new LineBorder(Color.darkGray);
		TitledBorder border = new TitledBorder(colorBorder, "Cadastro de Cliente");
		pnBase.setBorder(border);
		
		super.setSize(400, 300);
		super.setContentPane(pnBase);
		super.setVisible(true);
		super.pack();
	}
	
	public void configurePnBotao(){
		GridBagLayout layoutData2 = new GridBagLayout();
		pnBot.setLayout(layoutData2);
		
		GBC gbc9 = new GBC(3,8).setSpan(1, 1);
		GBC gbc10 = new GBC(4,8).setSpan(1, 1);
		
		pnBot.add(btSalvar,gbc9);
		pnBot.add(btCancelar,gbc10);
		
		super.setContentPane(pnBot);
		super.setVisible(true);
		super.pack();
		
	}
	//botao salvar
	private void configureBtSalvar(){
		ActionListener lstAutenticacao = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButtomSalvarActionPerformed();
				
			}
			
		};
		btSalvar.addActionListener(lstAutenticacao);
	}
	
	private void JButtomSalvarActionPerformed(){
		try{
			Cliente cli = new Cliente();
			cli.setNome(txNome.getText());
			cli.setEmail(txEmail.getText());
			controller.salvar(cli.getNome(), cli.getEmail());
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
			clearField();
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Nao foi possivel salvar produto!" + e.getLocalizedMessage());
		}
	}
	
	//botao cancelar
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
	
	private void clearField(){
		txNome.setText("");
		txEmail.setText("");
	}
}
