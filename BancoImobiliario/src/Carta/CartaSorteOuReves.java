package Carta;
import java.util.Random;

import Jogador.IJogador;

public class CartaSorteOuReves implements ICarta{
    
    String nome;
    float valor;
    IJogador proprietario; //poderia ser só um nome mas isso dificultaria transações de valores.

    public CartaSorteOuReves(String nome, float valor) {
        this.nome = nome;
        this.valor = geraValor();
        this.proprietario = null;
    }

    public float calcularPedagio() {
        return valor;
    }
    public float getValor() {
        if(this.nome == "Sorte") {
            return valor;
        }
        return -valor;
    }

    public IJogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(IJogador proprietario) {
        this.proprietario = proprietario;
    }

    public float geraValor() {
        // criando valor aleatório para o sorte ou reves
        Random aleatorio = new Random(); // função random
        float valor = aleatorio.nextFloat(1, 10)*10; 
        valor =  (float) Math.floor(valor)*100;
        return valor;

    }
}
