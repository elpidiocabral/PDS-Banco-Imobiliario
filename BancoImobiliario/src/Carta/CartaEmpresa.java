package Carta;

import Jogador.IJogador;

public class CartaEmpresa implements ICarta{
    
    String nome;
    float valor;
    IJogador proprietario;

    public CartaEmpresa(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
        this.proprietario = null;
    }

    // rever isso aqui
    public float calcularPedagio() {
        float pedagio = (float)(getValor() * 0.5);
        return pedagio;
    }
    public float getValor() {
        return valor;
    }

    public IJogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(IJogador proprietario) {
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }
}
