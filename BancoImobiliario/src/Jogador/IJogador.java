package Jogador;

public interface IJogador {
    //public void leCasa();
    public void setCarteira(float valor);
    public float getCarteira();
    public void tornarProprietario();
    public int girarDados();
    public String getNome();
    public String getStatus();
    public void setStatus(String status);
    public int getLocaliza();
    public void setLocaliza(int local);
    public int getImoveis();
    public void setImoveis(int valor);
    public int getNumRodadas();
    public void setNumRodadas();

    public void setStatusRodadas();
    public void resetStatusRodadas();
    public int getStatusRodadas();
} 