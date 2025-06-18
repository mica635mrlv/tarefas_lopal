package br.dev.milla.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.milla.tarefas.dao.FuncionarioDAO;
import br.dev.milla.tarefas.dao.TarefaDAO;
import br.dev.milla.tarefas.model.Funcionario;
import br.dev.milla.tarefas.model.Tarefa;
import br.dev.milla.tarefas.utils.Utils;

public class FrameTarefa {
	
	JLabel lblTitulo, lblDescricao, lblDataInicial, lblPrazo, lblConclusao, lblStatus;
	JTextField txtTitulo, txtDescricao, txtDataInicial, txtPrazo, txtConclusao;

	JComboBox<String> boxStatus, boxFuncionario;
	JLabel lblFuncionario;
	
	JButton btnSalvar, btnSair;
	
	public FrameTarefa() {
		criarTela();
	}
	
	private void criarTela(){
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(395, 560);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(20, 10, 50, 40);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 45, 250, 30);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(20, 70, 150, 40);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 105, 340, 30);
		
		lblDataInicial = new JLabel("Data de início:");
		lblDataInicial.setBounds(20, 130, 150, 40);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 165, 250, 30);
		
		lblPrazo = new JLabel("Prazo:");
		lblPrazo.setBounds(20, 190, 150, 40);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 225, 250, 30);
		
		lblConclusao = new JLabel("Data de conclusão:");
		lblConclusao.setBounds(20, 250, 150, 40);
		txtConclusao = new JTextField();
		txtConclusao.setBounds(20, 285, 250, 30);
		
		lblStatus= new JLabel("Status:");
		lblStatus.setBounds(20, 310, 158, 40);
		boxStatus = new JComboBox<String>();
		boxStatus.setBounds(20, 345, 250, 30);
		boxStatus.addItem("NÃO_INICIADA");
		boxStatus.addItem("EM_ANDAMENTO");
		boxStatus.addItem("FINALIZADA");
		boxStatus.addItem("EM_ATRASO");
		
		lblFuncionario = new JLabel("Responsável:");
		lblFuncionario.setBounds(20, 370, 158, 40);
		boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(20, 405, 250, 30);
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.showEmployees();
		for (Funcionario f : funcionarios) {
			boxFuncionario.addItem(f.getNome());
		}
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 455, 120, 40);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(Utils.fazerUUID());
				tarefa.setTitulo(txtTitulo.getText());
				tarefa.setResponsavel(null);

				TarefaDAO dao = new TarefaDAO(tarefa);
				dao.gravar();

				JOptionPane.showMessageDialog(
					tela,
					txtTitulo.getText() + " gravado com sucesso",
					"Sucesso",
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 455, 120, 40);
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
		
		
		painel.add(lblTitulo);
		painel.add(txtTitulo);
		painel.add(lblDescricao);
		painel.add(txtDescricao);
		painel.add(lblDataInicial);
		painel.add(txtDataInicial);
		painel.add(lblPrazo);
		painel.add(txtPrazo);
		painel.add(lblConclusao);
		painel.add(txtConclusao);
		painel.add(lblStatus);
		painel.add(boxStatus);
		painel.add(lblFuncionario);
		painel.add(boxFuncionario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}

}