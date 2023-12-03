package Casas;

import Jogador.IJogador;

import java.util.ArrayList;

import Efeito.*;

public class CasaEfeito implements ICasa {
    
    String nome;
    IEfeito efeito;
    int grupo;
    ArrayList<IJogador> cairam;

    CasaEfeito(String nome, int grupo) {
        this.nome = nome;
        this.grupo = grupo;
        this.efeito = criarEfeito(nome);
        cairam = new ArrayList<IJogador>();
    }

    public IEfeito criarEfeito(String nome) {
        switch (nome) {
            case"Férias":
                return new EfeitoFerias();

            case "Prisão":
                return new EfeitoCadeia();
            
            case "SR":
                return new EfeitoSR();

            default:
                return new EfeitoInicio();
        }
    }

    public String getNome() {
        return this.nome;
    }
    public String leCasa(IJogador jogador) {
        setProprietario(jogador);
        return efeito.leEfeito(jogador);
        // no caso da carta efeito, o nome guarda a mensagem de efeito
        // aplicar mecânica do fique sem jogar OU do ganhe, nesse caso preciso ter a classe jogador pra fazer isso
        //Casas de Sorte ou Reves serão assim, e o leCasa delas aplicará o efeito de puxar uma carta de corte ou Reves;

    }

    public int getGrupo() {
        return grupo;
    }

    public IJogador getProprietario() {
        return null;
    }

    public float getValor() {
        return efeito.getValor();
    }

    public float calcularPedagio() {
        return efeito.calcularPedagio();
    }

    public void setProprietario(IJogador jogador) {
        cairam.add(jogador);
    }
}
