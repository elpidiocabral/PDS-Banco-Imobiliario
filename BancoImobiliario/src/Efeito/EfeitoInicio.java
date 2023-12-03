package Efeito;

import Jogador.IJogador;

public class EfeitoInicio implements IEfeito {
    String mensagem;
    int valor;

    public EfeitoInicio() {
        this.mensagem = "  caiu denovo no inicio, ganhe 200.000";
        this.valor = 200000;
    }

    public void aplicaEfeito(IJogador jogador) {
        jogador.setCarteira(valor);

    }
    public String leEfeito(IJogador jogador) {
        aplicaEfeito(jogador);
        return jogador.getNome() + mensagem + "\naperte ENTER para continuar";
    }

    public float getValor() {
        return valor;
    }
    public float calcularPedagio() {
        return valor;

    }


}
