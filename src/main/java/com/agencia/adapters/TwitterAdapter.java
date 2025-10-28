package com.agencia.adapters;

import com.agencia.core.ISocialMediaAdapter;
import com.agencia.external.TwitterAPI;
import com.agencia.models.Conteudo;
import com.agencia.models.Estatisticas;
import com.agencia.models.PublicacaoResposta;

/**
 * (Tarefa 1: Implementação dos Adapters)
 * Este é o Adapter para o Twitter.
 * Ele "traduz" a chamada unificada `postar(Conteudo)` para a chamada específica `twitterAPI.tweet(String)`.
 */
public class TwitterAdapter implements ISocialMediaAdapter {
    
    private final TwitterAPI twitterAPI;

    // O Adapter recebe a API real (Adaptee) no construtor
    public TwitterAdapter(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public PublicacaoResposta postar(Conteudo conteudo) {
        try {
            // Lógica de "tradução" de entrada
            // Twitter é focado em texto.
            String texto = conteudo.getTexto();
            if (texto == null || texto.isEmpty()) {
                return criarRespostaDeErro("Twitter exige um texto.");
            }
            // Lógica para anexar imagem (conteudo.getUrlImagem()) seria mais complexa
            // aqui, mas vamos focar no texto.

            String respostaJson = twitterAPI.tweet(texto);

            // "Tradução" da resposta
            // (Em um caso real, você usaria uma biblioteca JSON como Jackson/Gson)
            PublicacaoResposta resposta = new PublicacaoResposta();
            resposta.setSucesso(true);
            resposta.setIdPublicacao("tw123456789"); // Parsear do JSON
            resposta.setUrlPublicacao("https://twitter.com/user/status/tw123456789");
            return resposta;

        } catch (Exception e) {
            return criarRespostaDeErro(e.getMessage());
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        // Lógica similar:
        // 1. Chamar twitterAPI.getTweetStats(idPublicacao)
        // 2. Parsear a resposta JSON
        // 3. Traduzir para o modelo Estatisticas unificado
        String respostaJson = twitterAPI.getTweetStats(idPublicacao);
        
        Estatisticas stats = new Estatisticas();
        stats.setCurtidas(500); // Valor parseado do JSON
        stats.setCompartilhamentos(120); // Valor parseado do JSON
        stats.setComentarios(0); // API do Twitter não fornece comentários fácil
        
        return stats;
    }
    
    // (Tarefa 2: Sistema de Resposta Unificado)
    private PublicacaoResposta criarRespostaDeErro(String msg) {
        PublicacaoResposta resposta = new PublicacaoResposta();
        resposta.setSucesso(false);
        resposta.setMensagemErro("TwitterAdapter: " + msg);
        return resposta;
    }
}