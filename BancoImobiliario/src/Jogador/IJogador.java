package Jogador;

import Casas.ICasa;

public interface IJogador {
    //public void leCasa();
    public void setCarteira(float valor);
    public float getCarteira();
    public void tornarProprietario();
    public void girarDados();
    public String getNome();
    public String getStatus();
    public void setStatus(String status);
    public int getLocaliza();
    public void setLocaliza(int local);
    public int getImoveis();
    public void setImoveis(int valor);

    
} 