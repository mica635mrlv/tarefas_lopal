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

	private JTable tblTabela;
	private JScrollPane scrollTabela;
	private JButton btnNovaTarefa, btnSair;

	public FrameListaTarefa() {
		criarTela();
	}

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(553, 500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Titulo";
		colunas[2] = "Responsável";

		TarefaDAO dao = new TarefaDAO(null);

		List<Tarefa> tarefas = dao.showTask();
		
		Object[][] dados = new Object[tarefas.size()][3];

		int linha = 0;
		for (Tarefa t : tarefas) {
			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][2] = t.getResponsavel().getCodigo();
			linha++;
		}

		tblTabela = new JTable(dados, colunas);
		scrollTabela = new JScrollPane(tblTabela);
		scrollTabela.setBounds(20, 20, 500, 365);

		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(20, 400, 150, 40);
		btnNovaTarefa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa();

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

		painel.add(scrollTabela);
		painel.add(btnNovaTarefa);
		painel.add(btnSair);

		tela.setVisible(true);
	}

}
