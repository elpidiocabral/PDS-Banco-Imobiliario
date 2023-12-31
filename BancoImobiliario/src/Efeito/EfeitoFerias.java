package Efeito;

import Jogador.IJogador;

public class EfeitoFerias implements IEfeito {
    String mensagem;
    int valor;

    public EfeitoFerias() {
        this.mensagem = " está de FERIAS, fique 2 rodadas sem jogar";
        this.valor = 2;
    }

    public String leEfeito(IJogador jogador) {
        aplicaEfeito(jogador);
        return jogador.getNome() + mensagem + "\naperte ENTER para continuar";
    }

    public void aplicaEfeito(IJogador jogador) {
        jogador.setStatus("de férias");
    }

    public float getValor() {
        return (int)valor;
    }
    public float calcularPedagio() {
        return getValor();
    }
}
