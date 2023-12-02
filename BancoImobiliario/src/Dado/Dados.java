package Dado;

import java.util.Random;

public class Dados implements IDado {
    int valor;
    Random aleatorio;

    public Dados() {
        aleatorio = new Random();
        valor = 0;
    }
    
    public int girarDados() {
        valor = aleatorio.nextInt(13);
        return valor;
    }
}
