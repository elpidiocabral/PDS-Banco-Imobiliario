package Efeito;

import Jogador.IJogador;

public class EfeitoCadeia implements IEfeito{
    
    String mensagem;
    int valor;

    public EfeitoCadeia() {
        this.mensagem = " foi preso, fique 3 rodadas sem jogar";
        this.valor = 3;
    }
    
    public String leEfeito(IJogador jogador) {
        aplicaEfeito(jogador);
        return mensagem;
    }

    public void aplicaEfeito(IJogador jogador) {
        jogador.setStatus("preso");
    }

    public float getValor() {
        return (int)valor;
    }

    public float calcularPedagio() {
        return getValor();
    }

}
