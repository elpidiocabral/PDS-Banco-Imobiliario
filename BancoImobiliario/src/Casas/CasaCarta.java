package Casas;
//import java.util.Scanner;

import Carta.*;
import Jogador.IJogador;
import Jogador.Jogador;

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
    public String leCasa(IJogador jogador) { 
        String le = "";
        le += nome;
        le += "\n--------------------\n";

        if(carta.getProprietario() != null) {
            if(carta.getProprietario().equals(jogador)) {
                le += jogador.getNome() + " você já é dono deste local, até a próxima\naperte ENTER para continuar.\n";
                return le;
            }

            le += jogador.getNome() + " pagaCARTAAA " + carta.calcularPedagio() + " para " + carta.getProprietario().getNome() + "\n";
            
            jogador.setCarteira(-carta.calcularPedagio());
            carta.getProprietario().setCarteira(carta.calcularPedagio());
            return le;
        }
        else {
            le += "valor: " + carta.getValor() + "\n" + "pedagio: " + carta.calcularPedagio() + "\n";
            return le;
            //System.out.println("Dejesa comprá-la?");

            // solicitar resposta e receber da view
            //Scanner sc = new Scanner(System.in);
            //String resp = sc.nextLine();
            //if(resp.equals("S") || resp.equals("s")) {
                //jogador.setCarteira(-carta.getValor());
                //carta.setProprietario(jogador);
                //return;
            //}
            //else {
                //return;
            //}

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
                return new CartaEmpresa(nome, 200000);
        }
    }

    public ICarta getCarta() {
        return carta;
    }
    public int getGrupo() {
        return grupo;
    }

    public IJogador getProprietario() {
        return carta.getProprietario();
    }

    public void setProprietario(IJogador jogador) {
        carta.setProprietario(jogador);
    }

    public float getValor() {
        return carta.getValor();
    }

    public float calcularPedagio() {
        return carta.calcularPedagio();
    }

}
