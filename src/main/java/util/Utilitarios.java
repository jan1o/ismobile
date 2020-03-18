package util;

import model.Configuracao;

// Essa classe é destinada a implementação de métodos utilitários
public class Utilitarios {
	
	//Método para remoção de caracteres especiais.
	public String removerCaracteresEspeciais(String passa) {
		if (passa != null) {
	        passa = passa.replaceAll("[ÂÀÁÄÃ]","A");   
	        passa = passa.replaceAll("[âãàáä]","a");   
	        passa = passa.replaceAll("[ÊÈÉË&]","E");   
	        passa = passa.replaceAll("[êèéë]","e");   
	        passa = passa.replaceAll("ÎÍÌÏ","I");   
	        passa = passa.replaceAll("îíìï","i");   
	        passa = passa.replaceAll("[ÔÕÒÓÖ]","O");   
	        passa = passa.replaceAll("[ôõòóö]","o");   
	        passa = passa.replaceAll("[ÛÙÚÜ]","U");   
	        passa = passa.replaceAll("[ûúùü]","u");   
	        passa = passa.replaceAll("Ç","C");   
	        passa = passa.replaceAll("ç","c");    
	        passa = passa.replaceAll("[ýÿ]","y");   
	        passa = passa.replaceAll("Ý","Y");   
	        passa = passa.replaceAll("ñ","n");   
	        passa = passa.replaceAll("Ñ","N"); 
	        passa = passa.replaceAll("['<>\\|/°-]","");
	      }      
	      return passa.trim();
	}
	
	//Método para adicionar as configuracoes do Postgres 
	public Configuracao configuracaoPostgres() {
		Configuracao config = new Configuracao();
		config.setCaminhoDB("jdbc:postgresql://localhost/INSEALI");
		config.setDriverDB("org.postgresql.Driver");
		config.setLoginDB("postgres");
		config.setSenhaDB("123");
		return config;
	}
}
