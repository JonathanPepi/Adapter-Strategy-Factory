package com.agencia.adapters;

import com.agencia.core.ISocialMediaAdapter;
import com.agencia.external.InstagramAPI;
import com.agencia.models.Conteudo;
import com.agencia.models.Estatisticas;
import com.agencia.models.PublicacaoResposta;

public class InstagramAdapter implements ISocialMediaAdapter {
    
    private final InstagramAPI instagramAPI;

    public InstagramAdapter(InstagramAPI instagramAPI) {
        this.instagramAPI = instagramAPI;
    }

    @Override
    public PublicacaoResposta postar(Conteudo conteudo) {
        // Lógica de "tradução" de entrada
        // O Instagram requer uma imagem
        if (conteudo.getUrlImagem() == null || conteudo.getUrlImagem().isEmpty()) {
            return criarRespostaDeErro("Instagram exige uma imagem (urlImagem).");
        }
        
        try {
            int statusCode = instagramAPI.postarFoto(conteudo.getUrlImagem(), conteudo.getTexto());
            
            // "Tradução" da resposta
            PublicacaoResposta resposta = new PublicacaoResposta();
            if (statusCode == 201) {
                resposta.setSucesso(true);
                resposta.setIdPublicacao("ig987654321"); // API real retornaria isso
                resposta.setUrlPublicacao("https://instagram.com/p/ig987654321");
            } else {
                resposta.setSucesso(false);
                resposta.setMensagemErro("API do Instagram retornou status: " + statusCode);
            }
            return resposta;

        } catch (Exception e) {
            return criarRespostaDeErro(e.getMessage());
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        // Simulado
        System.out.println("INSTAGRAM ADAPTER: Buscando estatísticas para " + idPublicacao);
        Estatisticas stats = new Estatisticas();
        stats.setCurtidas(2500);
        stats.setComentarios(80);
        stats.setCompartilhamentos(15); // Instagram Insights
        return stats;
    }

    private PublicacaoResposta criarRespostaDeErro(String msg) {
        PublicacaoResposta resposta = new PublicacaoResposta();
        resposta.setSucesso(false);
        resposta.setMensagemErro("InstagramAdapter: " + msg);
        return resposta;
    }
}