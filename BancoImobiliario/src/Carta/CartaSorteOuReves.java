package Carta;
import java.util.Random;

//import Efeito.IEfeito;
import Jogador.IJogador;

public class CartaSorteOuReves implements ICarta{
    
    String nome;
    String mensagem;
    float valor;
    IJogador proprietario; //poderia ser só um nome mas isso dificultaria transações de valores.

    public CartaSorteOuReves(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
        this.valor = geraValor();
        this.proprietario = null;
    }

    public float calcularPedagio() {
        return valor;
    }
    public float getValor() {
        if(this.nome.equals("SORTE")) {
            return valor;
        } else {
            return -valor;
        }
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
        float valor = aleatorio.nextFloat() * (10.0f) * 10.0f; 
        valor =  (float) Math.floor(valor)*100;
        return valor;
    }

    public String getNome() {
        return "\n" + nome + "\n" + mensagem + valor;
    }

}
