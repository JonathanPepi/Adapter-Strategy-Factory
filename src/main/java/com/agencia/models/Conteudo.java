package com.agencia.models;

public class Conteudo {
    private String texto;
    private String urlImagem;
    private String urlVideo;

    // Construtor
    public Conteudo(String texto, String urlImagem, String urlVideo) {
        this.texto = texto;
        this.urlImagem = urlImagem;
        this.urlVideo = urlVideo;
    }

    // Getters e Setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
}
