package Casas;

import Jogador.IJogador;

public interface ICasa {
    public String getNome();
    public String leCasa(IJogador jogador);
    public int getGrupo();
    public IJogador getProprietario();
    public void setProprietario(IJogador jogador);
    public float getValor();
    public float calcularPedagio();
}