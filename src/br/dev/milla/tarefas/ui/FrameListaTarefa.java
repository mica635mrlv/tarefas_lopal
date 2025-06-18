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
import javax.swing.table.DefaultTableModel;

import br.dev.milla.tarefas.dao.FuncionarioDAO;
import br.dev.milla.tarefas.dao.TarefaDAO;
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
		
		btnNovo = new JButton("Nova Tarefa");
		btnNovo.setBounds(20, 380, 150, 40);
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa();
			}
		});
		
//		Criação da tabela
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Titulo";
		colunas[2] = "Responsável";
		
		// Obter lista de funcionários
		TarefaDAO dao = new TarefaDAO(null);
		
		List<Tarefa> tarefas = dao.showTask();
		
		Object[][] dados = new Object[tarefas.size()][3];
		
		int linha = 0;
		for(Tarefa t : tarefas) {
			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][8] = t.getResponsavel();
			linha++;
		}
		
		tblTabela = new JTable(dados, colunas);
		
		scrollTabela = new JScrollPane(tblTabela);
		scrollTabela.setBounds(20, 65, 500, 300);
		
		DefaultTableModel model = new DefaultTableModel(colunas, 0);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(178, 380, 150, 40);
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