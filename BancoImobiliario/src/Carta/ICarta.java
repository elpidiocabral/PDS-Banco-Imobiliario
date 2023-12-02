package Carta;
import Jogador.IJogador;


public interface ICarta {

    public float calcularPedagio();
    public float getValor();
    public IJogador getProprietario();
    public void setProprietario(IJogador jogador);
    public String getNome();
    
}