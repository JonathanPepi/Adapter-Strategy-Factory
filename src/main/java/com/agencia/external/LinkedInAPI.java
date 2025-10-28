package com.agencia.external;

public class LinkedInAPI {
    private String clientId;
    private String clientSecret;

    public LinkedInAPI(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        System.out.println("LinkedInAPI inicializada com clientId: " + clientId.substring(0, 5) + "...");
    }

    // Método específico do LinkedIn
    public String shareUpdate(String textUpdate) {
        System.out.println("LINKEDIN API: Compartilhando atualização: '" + textUpdate + "'");
        // Simula uma resposta
        return "urn:li:share:123456789";
    }
}
