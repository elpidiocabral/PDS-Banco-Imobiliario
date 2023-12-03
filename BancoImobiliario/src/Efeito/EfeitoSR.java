package Efeito;

import Jogador.IJogador;

public class EfeitoSR implements IEfeito {
    String mensagem;
    int valor;

    public EfeitoSR() {
        this.mensagem = " você caiu em uma casa de Sorte ou Revés, compre uma carta do monte e teste sua sorte \n";
        this.valor = 0;
    }

    public String leEfeito(IJogador jogador) {
        return jogador.getNome() + mensagem + "\naperte C para comprar";
    }

    public void aplicaEfeito(IJogador jogador) {
        
    }

    public float getValor() {
        return (int)valor;
    }
    public float calcularPedagio() {
        return getValor();
    }
}