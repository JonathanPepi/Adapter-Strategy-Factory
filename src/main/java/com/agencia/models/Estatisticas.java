package com.agencia.models;

public class Estatisticas {
    private long curtidas;
    private long compartilhamentos;
    private long comentarios;

    // Getters e Setters
    public long getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(long curtidas) {
        this.curtidas = curtidas;
    }

    public long getCompartilhamentos() {
        return compartilhamentos;
    }

    public void setCompartilhamentos(long compartilhamentos) {
        this.compartilhamentos = compartilhamentos;
    }

    public long getComentarios() {
        return comentarios;
    }

    public void setComentarios(long comentarios) {
        this.comentarios = comentarios;
    }
}
