package com.agencia;

import com.agencia.core.Configuracao;
import com.agencia.core.GerenciadorMidiaSocial;
import com.agencia.core.Plataforma;
import com.agencia.models.Conteudo;
import com.agencia.models.PublicacaoResposta;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE GERENCIAMENTO DE MÍDIA SOCIAL ===");

        // 1. Carregar configurações
        Configuracao config = new Configuracao();
        
        // 2. Inicializar o gerenciador
        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial(config);

        System.out.println("\n--- TESTE 1: POSTAGEM SIMPLES (TWITTER) ---");
        Conteudo postTwitter = new Conteudo("Olá mundo! Este é meu primeiro post unificado via Adapter!", null, null);
        PublicacaoResposta respTwitter = gerenciador.publicarEm(Plataforma.TWITTER, postTwitter);
        System.out.println("Resultado: " + respTwitter);

        System.out.println("\n--- TESTE 2: POSTAGEM COM IMAGEM (INSTAGRAM) ---");
        Conteudo postInstagram = new Conteudo("Confira nossa nova logo!", "http://site.com/logo.png", null);
        PublicacaoResposta respInsta = gerenciador.publicarEm(Plataforma.INSTAGRAM, postInstagram);
        System.out.println("Resultado: " + respInsta);

        System.out.println("\n--- TESTE 3: POSTAGEM COM FALHA (INSTAGRAM SEM IMAGEM) ---");
        Conteudo postInstaFalha = new Conteudo("Este post vai falhar", null, null);
        PublicacaoResposta respInstaFalha = gerenciador.publicarEm(Plataforma.INSTAGRAM, postInstaFalha);
        System.out.println("Resultado: " + respInstaFalha);
        
        System.out.println("\n--- TESTE 4: POSTAGEM EM MASSA (TWITTER E LINKEDIN) ---");
        Conteudo postMassa = new Conteudo("Anúncio importante da empresa!", "http://site.com/anuncio.jpg", null);
        List<Plataforma> plataformas = Arrays.asList(Plataforma.TWITTER, Plataforma.LINKEDIN);
        
        List<PublicacaoResposta> respostas = gerenciador.publicarEmMassa(plataformas, postMassa);
        
        System.out.println("=== RESULTADOS DA PUBLICAÇÃO EM MASSA ===");
        for(PublicacaoResposta r : respostas) {
            System.out.println(r);
        }
        System.out.println("==========================================");
    }
}