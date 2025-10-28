package com.agencia.external;

public class InstagramAPI {
    private String accessToken;

    public InstagramAPI(String accessToken) {
        this.accessToken = accessToken;
        System.out.println("InstagramAPI inicializada com o token: " + accessToken.substring(0, 5) + "...");
    }

    // Método específico do Instagram (simplificado)
    public int postarFoto(String urlImagem, String legenda) {
        System.out.println("INSTAGRAM API: Postando foto: " + urlImagem + " com legenda: '" + legenda + "'");
        // Simula uma resposta (ex: HTTP 201 Created)
        return 201;
    }
}