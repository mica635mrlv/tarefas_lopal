package br.dev.milla.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private FileWriter fw;
	private BufferedWriter bw;

	private FileReader fr;
	private BufferedReader br;

	private String pathFuncionarios = "C:\\Users\\milla\\OneDrive\\DS - SENAI\\funcionarios.csv";

	public BufferedReader getBufferedReader() throws FileNotFoundException, IOException {

		fr = new FileReader(pathFuncionarios);
		br = new BufferedReader(fr);
		return br;

	}

	public BufferedWriter getBuferredWriter() throws FileNotFoundException, IOException {

		fw = new FileWriter(pathFuncionarios, true);
		bw = new BufferedWriter(fw);
		return bw;
	}

}