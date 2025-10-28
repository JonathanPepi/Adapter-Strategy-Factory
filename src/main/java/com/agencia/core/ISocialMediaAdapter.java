package com.agencia.core;

import com.agencia.models.Conteudo;
import com.agencia.models.Estatisticas;
import com.agencia.models.PublicacaoResposta;

/**
 * Interface Alvo (Target)
 * Esta é a interface unificada que o GerenciadorMidiaSocial (Cliente) usará.
 * Também atua como a "Strategy" no Padrão Strategy.
 */
public interface ISocialMediaAdapter {
    PublicacaoResposta postar(Conteudo conteudo);
    Estatisticas obterEstatisticas(String idPublicacao);
    // Outros métodos unificados:
    // boolean deletar(String idPublicacao);
}