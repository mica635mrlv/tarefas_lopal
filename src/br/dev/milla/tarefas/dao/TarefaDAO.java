package br.dev.milla.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.milla.tarefas.factory.FileFactory;
import br.dev.milla.tarefas.model.Funcionario;
import br.dev.milla.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	private FileFactory ff = new FileFactory();
	private Funcionario funcionario;

	public TarefaDAO(Tarefa tarefas) {
		this.tarefa = tarefas;
	}

	public void gravar() {
		try {
			BufferedWriter bw = ff.getBufferedWriter();
			bw.write(tarefa.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Tarefa> showTask() {

		List<Tarefa> tarefas = new ArrayList<>();

		try {
			BufferedReader br = ff.getBufferedReader();
			String linha = br.readLine();

			do {
				linha = br.readLine();
				String[] tarefa = linha != null ? linha.split(",") : null;

				Tarefa t = new Tarefa();
				t.setCodigo(tarefa[0]);
				t.setTitulo(tarefa[1]);
				t.setResponsavel(tarefa[8]); //setDescrição

				tarefas.add(t);

			} while (linha != null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return tarefas;
	}

}