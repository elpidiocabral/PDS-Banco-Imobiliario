package Carta;
import Jogador.IJogador;

public class CartaLocal implements ICarta{
    
    String nome;
    float valor;
    IJogador proprietario;

    public CartaLocal(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
        this.proprietario = null;
    }

    public float calcularPedagio() {
        float pedagio = (float)(getValor() * 0.01);
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
}
