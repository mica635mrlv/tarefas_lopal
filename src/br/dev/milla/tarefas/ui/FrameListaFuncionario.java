package br.dev.milla.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.dev.milla.tarefas.dao.FuncionarioDAO;
import br.dev.milla.tarefas.model.Funcionario;

public class FrameListaFuncionario {

	private JTable tblFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo, btnSair;
	
	public FrameListaFuncionario() {
		criarTela();
	}
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Funcionários");
		tela.setSize(553, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		//Criação da tabela
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Nome";
		colunas[2] = "E-mail";
		
		// Obter lista de funcionários
		FuncionarioDAO dao = new FuncionarioDAO(null);
		
		List<Funcionario> funcionarios = dao.showEmployees();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		for(Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;
		}
		
		tblFuncionarios = new JTable(dados, colunas);
		
		scrollFuncionarios = new JScrollPane(tblFuncionarios);
		scrollFuncionarios.setBounds(20, 20, 500, 365);
			
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(20, 400, 150, 40);
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 400, 150, 40);
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confirma a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					tela.dispose();
				}
			}
		});
				
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		tela.setVisible(true);
		
	}
	
	
}
