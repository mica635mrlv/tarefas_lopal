package br.dev.milla.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.milla.tarefas.dao.FuncionarioDAO;
import br.dev.milla.tarefas.model.Funcionario;

public class FrameInicial {

	private JLabel lblInfo;
	private JButton btnFuncionarios, btnTarefas, btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 15);
	
	public FrameInicial(JFrame telaInicial) {
		criarTela(telaInicial);
	}

	public void criarTela(JFrame telaInicial) {
		JFrame tela = new JDialog(telaInicial, "Menu Inicial", false);
		tela.setTitle("Menu Inicial");
		tela.setSize(400, 230);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaInicial);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Container painel = tela.getContentPane();
		
		lblInfo = new JLabel("Selecione a opção desejada:");
		lblInfo.setBounds(84, 25, 240, 20);
		lblInfo.setFont(fontTitulo);
	
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(37, 60, 150, 50);
//		btnTarefas.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new FrameListaTarefa();
//			}
//		});
				
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(197, 60, 150, 50);
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(130, 125, 120, 40);

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confima a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION
				);
				
				if (resposta == 0) {
					tela.dispose();
				}
			}
		});
		
		painel.add(lblInfo);
		painel.add(btnTarefas);
		painel.add(btnFuncionarios);
		painel.add(btnSair);
		
		tela.setVisible(true);
		
	}
	
}
