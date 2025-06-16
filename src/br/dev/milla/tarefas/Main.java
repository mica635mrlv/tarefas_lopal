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
import br.dev.milla.tarefas.ui.FrameFuncionario;
import br.dev.milla.tarefas.ui.FrameInicial;
import br.dev.milla.tarefas.ui.FrameListaFuncionario;
import br.dev.milla.tarefas.ui.FrameTarefa;
import br.dev.milla.tarefas.utils.Utils;

public class Main {

	private static String path = "C:\\Users\\25133008\\tarefa\\tarefas.txt";

	public static void main(String[] args) {

		new FrameInicial();

	}

}