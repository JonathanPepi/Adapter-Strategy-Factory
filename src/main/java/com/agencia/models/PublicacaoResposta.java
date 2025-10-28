package com.agencia.models;

public class PublicacaoResposta {
    private boolean sucesso;
    private String idPublicacao;
    private String urlPublicacao;
    private String mensagemErro;

    // Getters e Setters
    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(String idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getUrlPublicacao() {
        return urlPublicacao;
    }

    public void setUrlPublicacao(String urlPublicacao) {
        this.urlPublicacao = urlPublicacao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    @Override
    public String toString() {
        if (sucesso) {
            return "PublicacaoResposta [sucesso=" + sucesso + ", idPublicacao=" + idPublicacao + ", url=" + urlPublicacao + "]";
        } else {
            return "PublicacaoResposta [sucesso=" + sucesso + ", mensagemErro=" + mensagemErro + "]";
        }
    }
}