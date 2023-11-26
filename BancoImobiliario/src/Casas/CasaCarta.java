package Casas;
import java.util.Scanner;

import Carta.*;
import Jogador.IJogador;

public class CasaCarta implements ICasa {

    String nome;
    int grupo;
    ICarta carta;
    
    CasaCarta(String nome, int grupo) {
        this.nome = nome;
        this.grupo = grupo;
        this.carta = criaCarta();
    }

    public String getNome() {
        return this.nome;
    }
    public void leCasa(IJogador jogador) { 
        System.out.println(nome);
        System.out.println("--------------------");
        
        if(carta.getProprietario() != null) {
            if(carta.getProprietario().equals(jogador)) return;
            System.out.println(jogador.getNome() + " paga " + carta.calcularPedagio() + " para " + carta.getProprietario().getNome());
            if(jogador.getCarteira() < carta.calcularPedagio()) {
                carta.getProprietario().setCarteira(jogador.getCarteira());
                System.out.println(jogador.getNome() + " faliu!! não poderá jogar enquanto não tiver dinheiro");
                jogador.setStatus("falido");
            }
            jogador.setCarteira(-carta.calcularPedagio());
            carta.getProprietario().setCarteira(carta.calcularPedagio());
        }
        else {
            System.out.println("valor: " + carta.getValor());
            System.out.println("pedagio: " + carta.calcularPedagio() + "\n");
            System.out.println("Dejesa comprá-la?");
            Scanner sc = new Scanner(System.in);
            String resp = sc.nextLine();
            if(resp.equals("S") || resp.equals("s")) {
                jogador.setCarteira(-carta.getValor());
                carta.setProprietario(jogador);
                return;
            }
            else {
                return;
            }

        }

    }

    public ICarta criaCarta() {
        float valor = 0;
        switch (this.grupo) {
            case 1:
                valor = this.grupo * 100000;
                return new CartaLocal(getNome(), valor);

            case 2:
                valor = this.grupo * 100000;
                return new CartaLocal(getNome(), valor);

            case 3:
                valor = this.grupo * 100000;
                return new CartaLocal(getNome(), valor);
    
            case 4:
                valor = this.grupo * 100000;
                return new CartaLocal(getNome(), valor);

            default:
                return new CartaEmpresa(nome, 20000);
        }
    }

    public void ComprarCarta(IJogador jogador) {
        jogador.setCarteira(-carta.getValor());
        carta.setProprietario(jogador);

    }

    public ICarta getCarta() {
        return carta;
    }

}
