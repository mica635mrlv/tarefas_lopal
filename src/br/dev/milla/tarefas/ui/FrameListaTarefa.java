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
import br.dev.milla.tarefas.dao.TarefasDAO;
import br.dev.milla.tarefas.model.Funcionario;
import br.dev.milla.tarefas.model.Tarefa;

public class FrameListaTarefa {

	private JLabel lblTitulo;
	private JTable tblTabela;
	private JScrollPane scrollTabela;
	private JButton btnNovo, btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListaTarefa() {
		criarTela();
	}
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(553, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Cadastro de Tarefas");
		lblTitulo.setBounds(20, 25, 500, 20);
		lblTitulo.setFont(fontTitulo);
		
//		Criação da tabela
		String[] colunas = {"Código", "Titulo", "Responsável"};
		
		String[] coluna = new String[4];
		colunas[0] = "Código";
		colunas[1] = "Titulo";
		colunas[2] = "Responsável";
		
		// Obter lista de funcionários
		TarefasDAO dao = new TarefasDAO(null);
		
		List<Tarefa> tarefa = dao.showTask();
		
		Object[][] dados = new Object[tarefa.size()][3];
		
		int linha = 0;
		for(Tarefa t : tarefa) {
			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][7] = t.getResponsavel();
			linha++;
		}
		
		tblTabela = new JTable(dados, colunas);
		
		scrollTabela = new JScrollPane(tblTabela);
		scrollTabela.setBounds(20, 65, 500, 300);
//			
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(20, 380, 120, 40);
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 380, 120, 40);
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confima a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					tela.dispose();
				}
			}
		});
				
		painel.add(lblTitulo);
		painel.add(tblTabela);
		painel.add(scrollTabela);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		tela.setVisible(true);
		
	}

}