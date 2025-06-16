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
	
	public FrameInicial() {
		criarTela();
	}

	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Gerenciador de Tarefas");
		tela.setSize(400, 190);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Container painel = tela.getContentPane();
		
		lblInfo = new JLabel("Selecione a opção desejada:");
		lblInfo.setBounds(84, 35, 240, 20);
		lblInfo.setFont(fontTitulo);
	
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(37, 70, 150, 40);
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 15));
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(197, 70, 150, 40);
		btnTarefas.setFont(new Font("Arial", Font.BOLD, 15));
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaTarefa();
			}
		});	
		
		painel.add(lblInfo);
		painel.add(btnTarefas);
		painel.add(btnFuncionarios);
		
		tela.setVisible(true);
		
	}
	
}