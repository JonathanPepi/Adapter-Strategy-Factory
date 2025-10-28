package com.agencia.core;

import java.util.Properties;

// (Hint #4: Configuração por ambiente)
public class Configuracao {
    private Properties props = new Properties();
    
    public Configuracao() {
        // Simulação de carregamento de um arquivo .properties ou variáveis de ambiente
        // Você pode ter "dev.properties", "prod.properties"
        System.out.println("Carregando configurações (simulado)...");
        props.setProperty("TWITTER_API_KEY", "key_secreta_twitter_123");
        props.setProperty("INSTAGRAM_ACCESS_TOKEN", "token_secreto_insta_abc");
        props.setProperty("LINKEDIN_CLIENT_ID", "id_cliente_linkedin_xyz");
        props.setProperty("LINKEDIN_CLIENT_SECRET", "segredo_cliente_linkedin_xyz");
    }
    
    public String getProperty(String key) {
        return props.getProperty(key);
    }
}
