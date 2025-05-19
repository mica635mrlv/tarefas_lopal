package br.dev.milla.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.milla.tarefas.dao.FuncionarioDAO;
import br.dev.milla.tarefas.model.Funcionario;
import br.dev.milla.tarefas.model.Tarefa;

public class Main {

	private static String path = "C:\\Users\\25133008\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<>();
		List<Funcionario> funcionarios = new ArrayList<>();
		List<Double> numeros = new ArrayList<>();
		
		frutas.add("manga");
		frutas.add("maça");
		frutas.add("banana");
		frutas.add("goiaba");
		
		numeros.add(4.9);
		numeros.add(9.9);


//		Integer a = 10;
//		Double b = 4.9;
//		b.M

		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(5);
		funcionario.setNome("Jorge Antonio");
		funcionario.setMatricula("4545454");
		funcionario.setEmail("jorge@email.com");

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setCodigo(8);
		funcionario2.setNome("Luana Mariana");
		funcionario2.setMatricula("96541");
		funcionario2.setEmail("luana@email.com");
		
		funcionarios.addAll(List.of(funcionario, funcionario2, funcionario, funcionario2));		
		
//		System.out.println(frutas);
//		System.out.println(funcionarios);		
		
		for (Funcionario f : funcionarios) {
			System.out.println(f.getNome() + " - " + f.getEmail());
		}
		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
//
//		System.out.println(funcionario.toString());

//		Funcionario f = new Funcionario();
//		Tarefa t = new Tarefa();
//		gravarArquivo();
//		lerArquivo();

	}

	private static void gravarArquivo() {

		FileWriter arquivo = null;
		BufferedWriter escritor = null;

		try {

			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);

			escritor.write("Essa é uma outra mais uma nova linha!!!!, por enquanto\n");
			escritor.flush();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

	private static void lerArquivo() {

		// Abrir o arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);

			String linha = buffer.readLine();

			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					System.out.println(linha);
				}

			}

		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ver o arquivo!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico!");
			System.out.println(erro.getMessage());
		}
	}

}
