package br.dev.milla.tarefas.utils;

import java.util.UUID;

public class Utils {
	
	public static String gerarUUID() {
		
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString().substring(0, 8);
		
		return uuidStr;
		
	}
	
}
