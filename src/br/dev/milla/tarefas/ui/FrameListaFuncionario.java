package br.dev.milla.tarefas.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrameListaFuncionario {

	private JLabel lblTitulo;
	private JTable tblFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton bntNovo, bntExcluir, bntAtualizar, bntSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListaFuncionario() {
		criarTela();
	}
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Cadastro de Funcinários");
		lblTitulo.setBounds(30, 30, 500, 30);
		lblTitulo.setFont(fontTitulo);
		
		//Criação da tabela
		String[] colunas = {"Código", "Nome","E-mail"};
		
		Object[][] dados = {
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"XXXX", "XXX", "XX"},
				{"AAA", "AAAA", "AAA"},
				{"MM", "MMM", "MMM"}
		};
		
		tblFuncionarios = new JTable(dados, colunas);
		
		scrollFuncionarios = new JScrollPane(tblFuncionarios);
		scrollFuncionarios.setBounds(30, 80, 400, 300);
		
		
//		bntNovo = new JButton("Novo");
//		bntExcluir = new JButton("Excluir");
//		bntAtualizar = new JButton("Atualizar");
//		bntSair = new JButton("Sair");
				
		painel.add(lblTitulo);
		painel.add(scrollFuncionarios);
		
		tela.setVisible(true);
		
	}
	
	
}
