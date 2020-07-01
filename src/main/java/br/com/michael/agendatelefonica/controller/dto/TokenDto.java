package br.com.michael.agendatelefonica.controller.dto;

public class TokenDto {

    private String token;
    private String metodoAutenticacao;

    public TokenDto(String token, String metodoAutenticacao) {
        this.token = token;
        this.metodoAutenticacao = metodoAutenticacao;
    }

    public String getToken() {
        return token;
    }

    public String getMetodoAutenticacao() {
        return metodoAutenticacao;
    }
}
