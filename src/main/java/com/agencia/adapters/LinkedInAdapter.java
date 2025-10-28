package com.agencia.adapters;

import com.agencia.core.ISocialMediaAdapter;
import com.agencia.external.LinkedInAPI;
import com.agencia.models.Conteudo;
import com.agencia.models.Estatisticas;
import com.agencia.models.PublicacaoResposta;

public class LinkedInAdapter implements ISocialMediaAdapter {

    private final LinkedInAPI linkedInAPI;

    public LinkedInAdapter(LinkedInAPI linkedInAPI) {
        this.linkedInAPI = linkedInAPI;
    }

    @Override
    public PublicacaoResposta postar(Conteudo conteudo) {
        // Lógica de "tradução" de entrada
        // LinkedIn é focado em texto profissional
        if (conteudo.getTexto() == null || conteudo.getTexto().isEmpty()) {
            return criarRespostaDeErro("LinkedIn exige um texto.");
        }
        
        try {
            // Poderia haver lógica aqui para formatar o texto, adicionar a imagem, etc.
            String textoPostagem = conteudo.getTexto();
            if (conteudo.getUrlImagem() != null) {
                textoPostagem += "\n[Imagem anexa: " + conteudo.getUrlImagem() + "]";
            }

            String postId = linkedInAPI.shareUpdate(textoPostagem);

            // "Tradução" da resposta
            PublicacaoResposta resposta = new PublicacaoResposta();
            resposta.setSucesso(true);
            resposta.setIdPublicacao(postId);
            resposta.setUrlPublicacao("https://linkedin.com/feed/update/" + postId);
            return resposta;

        } catch (Exception e) {
            return criarRespostaDeErro(e.getMessage());
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        // Simulado
        System.out.println("LINKEDIN ADAPTER: Buscando estatísticas para " + idPublicacao);
        Estatisticas stats = new Estatisticas();
        stats.setCurtidas(150); // "Reactions"
        stats.setComentarios(20);
        stats.setCompartilhamentos(30);
        return stats;
    }

    private PublicacaoResposta criarRespostaDeErro(String msg) {
        PublicacaoResposta resposta = new PublicacaoResposta();
        resposta.setSucesso(false);
        resposta.setMensagemErro("LinkedInAdapter: " + msg);
        return resposta;
    }
}