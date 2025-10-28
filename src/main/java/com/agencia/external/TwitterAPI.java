package com.agencia.external;

public class TwitterAPI {
    private String apiKey;

    public TwitterAPI(String apiKey) {
        this.apiKey = apiKey;
        System.out.println("TwitterAPI inicializada com a chave: " + apiKey.substring(0, 5) + "...");
    }

    // Método específico do Twitter
    public String tweet(String texto) {
        System.out.println("TWITTER API: Postando tweet: '" + texto + "'");
        // Simula uma resposta JSON da API
        return "{\"id\": \"tw123456789\", \"text\": \"" + texto + "\"}";
    }

    // Método específico para obter dados
    public String getTweetStats(String tweetId) {
        return "{\"id\": \"" + tweetId + "\", \"retweets\": 120, \"likes\": 500}";
    }
}