package Casas;

import Jogador.IJogador;

public class CasaEfeito implements ICasa {
    
    String nome;
    int grupo; //queria colocar que o grupo não é necessário
    //IEfeito efeito;

    CasaEfeito(String nome, int grupo) {
        this.nome = nome;
        this.grupo = grupo;
    }

    public String getNome() {
        return this.nome;
    }
    public void leCasa(IJogador jogador) {
        System.out.println(nome); // no caso da carta efeito, o nome guarda a mensagem de efeito
        // aplicar mecânica do fique sem jogar OU do ganhe, nesse caso preciso ter a classe jogador pra fazer isso
        //Casas de Sorte ou Reves serão assim, e o leCasa delas aplicará o efeito de puxar uma carta de corte ou Reves;
    }

}
