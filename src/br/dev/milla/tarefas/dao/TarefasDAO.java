package br.dev.milla.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.milla.tarefas.factory.FileFactory;
import br.dev.milla.tarefas.model.Tarefa;

public class TarefasDAO {

    private Tarefa tarefa;
    private FileFactory ff = new FileFactory();

    // Construtor
    public TarefasDAO(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void gravar() {
        try {
            BufferedWriter bw = ff.getBufferedWriter();
            bw.write(tarefa.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Erro ao gravar tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> showTask() {
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            BufferedReader br = ff.getBufferedReader();
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dadosTarefa = linha.split(",");

                // Verifica se tem pelo menos o número mínimo de campos
                if (dadosTarefa.length >= 8) {
                    Tarefa t = new Tarefa();
                    t.setCodigo(0);
                    t.setTitulo(dadosTarefa[1]);
                    t.setDescricao(dadosTarefa[2]);
                    t.setDataInicio(null);
                    t.setPrazo(null);
                    t.setDataConclusao(null);
                    t.setStatus(null);
                    t.setResponsavel(null);

                    tarefas.add(t);
                } else {
                    System.out.println("Linha com formato inválido: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler tarefas: " + e.getMessage());
        }

        return tarefas;
    }
}