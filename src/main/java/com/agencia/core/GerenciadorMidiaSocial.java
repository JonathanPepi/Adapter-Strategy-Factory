package com.agencia.core;

import com.agencia.models.Conteudo;
import com.agencia.models.PublicacaoResposta;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Cliente (Client)
 * Esta é a classe principal que o usuário final irá interagir.
 * Ela não conhece TwitterAPI, InstagramAPI, etc.
 * Ela só conhece a interface ISocialMediaAdapter.
 */
public class GerenciadorMidiaSocial {

    private final SocialMediaFactory factory;
    private final Configuracao config;

    public GerenciadorMidiaSocial(Configuracao config) {
        this.factory = new SocialMediaFactory();
        this.config = config;
    }

    /**
     * Publica conteúdo em uma plataforma específica.
     * Aqui, o Adapter (ISocialMediaAdapter) está sendo usado como uma Strategy.
     */
    public PublicacaoResposta publicarEm(Plataforma plataforma, Conteudo conteudo) {
        
        System.out.println("GERENCIADOR: Recebida ordem para postar em: " + plataforma);
        
        try {
            // 1. Usa a Factory para obter o Adapter/Strategy correto
            ISocialMediaAdapter adapter = factory.criarAdapter(plataforma, config);
            
            // 2. Executa a estratégia (chama a interface unificada)
            return adapter.postar(conteudo);

        } catch (Exception e) {
            System.err.println("GERENCIADOR: Erro ao processar " + plataforma + ": " + e.getMessage());
            PublicacaoResposta erro = new PublicacaoResposta();
            erro.setSucesso(false);
            erro.setMensagemErro("Erro interno no gerenciador: " + e.getMessage());
            return erro;
        }
    }

    /**
     * Publica o mesmo conteúdo em múltiplas plataformas.
     */
    public List<PublicacaoResposta> publicarEmMassa(List<Plataforma> plataformas, Conteudo conteudo) {
        List<PublicacaoResposta> respostas = new ArrayList<>();
        
        for (Plataforma p : plataformas) {
            PublicacaoResposta resposta = publicarEm(p, conteudo);
            respostas.add(resposta);
            System.out.println("--------------------"); // Separador
        }
        
        return respostas;
    }
}