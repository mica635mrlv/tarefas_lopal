package br.dev.milla.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.dev.milla.tarefas.factory.FileFactory;
import br.dev.milla.tarefas.factory.TaskFileFactory;
import br.dev.milla.tarefas.model.Funcionario;
import br.dev.milla.tarefas.model.Status;
import br.dev.milla.tarefas.model.Tarefa;

public class TarefaDAO {
	
	private static String path = "C:\\Users\\milla\\OneDrive\\DS - SENAI\\tarefas.cvs";

	private Tarefa tarefa;
	private TaskFileFactory ff = new TaskFileFactory();
	
	public TarefaDAO(Tarefa tarefas) {
		this.tarefa = tarefas;
	}

	public void gravar() {

		try {
			BufferedWriter bw = ff.getBufferedWriter();
			bw.write(tarefa.formatarArquivo());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Tarefa> showTask() {

		List<Tarefa> tarefas = new ArrayList<>();

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(null);

		try {
			BufferedReader br = ff.getBufferedReader();
			String linha = br.readLine();

			do {
				linha = br.readLine();
				String[] tarefa = linha != null ? linha.split(",") : null;

				if (tarefa.length < 8) continue;
				
				Tarefa t = new Tarefa();
				t.setCodigo(tarefa[0]);
				t.setTitulo(tarefa[1]);
				
				Funcionario responsavel = funcionarioDAO.buscarCodigo(tarefa[7]);
				t.setResponsavel(responsavel);
				
				tarefas.add(t);

			} while (linha != null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return tarefas;
	}

}