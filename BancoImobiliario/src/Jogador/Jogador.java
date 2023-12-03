package Jogador;

import Dado.ControllerDados;

public class Jogador implements IJogador {
    
    String nome;
    float carteira;
    float imoveis;
    int localiza;
    String status;
    int numRodadas;
    ControllerDados dados;
    int statusRodadas;

    
    public Jogador(String nome) {
        this.nome = nome;
        //this.carteira = 2558000;
        this.carteira = 350000;
        this.imoveis = 0; // aqui vamos salvar o que esse jogador tem de ações em imóveis, pra facilitar o ranking final
        this.localiza = 1; // a pendência servirá em casos de punições como "fique 3 rodadas sem jogar, como um contador, apesar de que eu creio que daria pra fazer de um jeito melhor pensando um pouco mais"
        this.status = "livre"; // o status vai dizer onde ele está = de férias, na prisão ou livre;
        numRodadas = 0;
        statusRodadas = 0;
        dados = new ControllerDados();
    }

    public void setCarteira(float valor) {
        carteira += valor;
    }

    public float getCarteira() {
        return carteira;
    }
    public int girarDados() {
        setNumRodadas();
        return dados.girarDados();
    }
    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }

    public int getLocaliza() {
        return localiza;
    }

    public void setLocaliza(int local) {
        localiza = local;
    }

    public void setImoveis(float valor) {
        imoveis += valor;
    }

    public float getImoveis() {
        return imoveis;
    }

    public int getNumRodadas() {
        return numRodadas;
    }

    public void setNumRodadas() {
        numRodadas++;
    }

    public void setStatusRodadas() {
        statusRodadas++;
    }

    public void resetStatusRodadas() {
        statusRodadas = 0;
    }

    public int getStatusRodadas() {
        return statusRodadas;
    }

    public void falido() {
        status = "falido";
        carteira = 0;
    }
}
