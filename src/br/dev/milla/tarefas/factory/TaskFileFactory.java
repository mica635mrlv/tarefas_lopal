package br.dev.milla.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskFileFactory {
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	private FileReader fr;
	private BufferedReader br;
	
	private String pathTarefas = "C:\\Users\\milla\\OneDrive\\DS - SENAI\\tarefas.cvs";
	
	public BufferedReader getBufferedReader() throws FileNotFoundException, IOException {
		
		fr = new FileReader(pathTarefas);
		br = new BufferedReader(fr);
		return br;
		
	}

	public BufferedWriter getBufferedWriter() throws FileNotFoundException, IOException {

		fw = new FileWriter(pathTarefas, true);
		bw = new BufferedWriter(fw);
		return bw;

	}

}
