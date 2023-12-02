package Efeito;
import Jogador.IJogador;

public interface IEfeito {

    public void aplicaEfeito(IJogador jogador);
    public String leEfeito(IJogador jogador);
    public float getValor();
    public float calcularPedagio();
} 