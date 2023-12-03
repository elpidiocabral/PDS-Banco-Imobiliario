package Casas;

import Jogador.IJogador;

public class CasaSR implements ICasa{
    String nome;
    int grupo;

    CasaSR(String nome, int grupo) {
        this.nome = "Sorte ou Revés!";
        this.grupo = grupo;
    }

    public String getNome() {
        return this.nome;
    }
    public String leCasa(IJogador jogador) {
        return jogador.getNome() + " você caiu em uma casa de sorte ou revés, compre uma carta do monte e teste sua sorte \n" + "aperte ENTER para comprar";//
    }

    public int getGrupo() {
        return grupo;
    }

    public IJogador getProprietario() {
        return null;
    }

    public float getValor() {
        return 0f;
    }

    public float calcularPedagio() {
        return 0f;
    }

    public void setProprietario(IJogador jogador) {

    }
}
