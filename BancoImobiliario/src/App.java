import Casas.*;
import Jogador.IJogador;
import Jogador.Jogador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import Carta.*;

public class App {
    //ArrayList<ICasa> casas = new ArrayList<ICasa>();
    //FabricaCasa fabrica = new FabricaCasa();
    public static void main(String[] args) throws Exception {
        
        //coisas que serão de tabuleiro
        ArrayList<ICasa> casas = new ArrayList<ICasa>();
        FabricaCasa fabrica = new FabricaCasa();
        ArrayList<IJogador> jogadores = new ArrayList<IJogador>();
        int dado = 0;
        
        //coisas que serão da view (eu acho)
        int rodada = 0;
        String init = ""; 
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random(); // função random

        ICasa marco25 = fabrica.criarCasa("Local","Av 25 de março", 2);
        ICasa julho9 = fabrica.criarCasa("Local","Av 9 de julho", 2);
        ICasa morumbi = fabrica.criarCasa("Local","Morumbi", 2);
        ICasa bangu = fabrica.criarCasa("Local","Bangu", 2);
        casas.add(marco25);
        casas.add(bangu);
        casas.add(morumbi);
        casas.add(julho9);

        //Ceará - grupo 2
        ICasa praca = fabrica.criarCasa("Local","Praça do Ferreira", 2);
        ICasa mister = fabrica.criarCasa("Local","Av MisterHall", 2);
        ICasa beiramar = fabrica.criarCasa("Local","Av Beria Mar", 2);
        ICasa quixada = fabrica.criarCasa("Local","Quixadá - terra dos monólitos", 2);
        ICasa pidao = fabrica.criarCasa("Local","Av Lobsomem Pidão", 2);
        casas.add(praca);
        casas.add(beiramar);
        casas.add(mister);
        casas.add(quixada);
        casas.add(pidao);


        //Rio Janeiro - grupo 3
        ICasa brasil = fabrica.criarCasa("Local","Av Brasil", 3);
        ICasa ipanema = fabrica.criarCasa("Local","Ipanema", 3);
        ICasa copacaba = fabrica.criarCasa("Local","Copacaba", 3);
        casas.add(brasil);
        casas.add(ipanema);
        casas.add(copacaba);

        //São Paulo - grupo 4
        ICasa paulista = fabrica.criarCasa("Local","Av Paulista", 4);
        ICasa brigadeiro = fabrica.criarCasa("Local","Av Brigaderio", 4);
        ICasa china = fabrica.criarCasa("Local","Bairro Liberdade", 4);
        ICasa se = fabrica.criarCasa("Local","Praça da Sé", 4);
        casas.add(paulista);
        casas.add(brigadeiro);
        casas.add(se);
        casas.add(china);

        IJogador mari = new Jogador("mari");
        IJogador lulu = new Jogador("lulu");
        IJogador caua = new Jogador("caua");
        IJogador pipi = new Jogador("pipi");
        IJogador alsinha = new Jogador("alsinha");
        IJogador renan = new Jogador("renan");
        jogadores.add(caua);
        jogadores.add(lulu);
        jogadores.add(mari);
        jogadores.add(pipi);
        jogadores.add(alsinha);
        jogadores.add(renan);

        System.out.println("Deseja começar o jogo? S/N");
        init = sc.nextLine(); 
        while(init.equals("S") || init.equals("s")){
            rodada++;
            System.out.println("rodada: " + rodada);
            for (IJogador joga : jogadores) {
                if(joga.getStatus().equals("livre")) {
                    System.out.println("\nJogador da vez: " + joga.getNome());
                    System.out.print("lançando os dados... ");
                    int valor = aleatorio.nextInt(1, 13);
                    dado = valor - 1; //pega o números
                    System.out.println(dado + "!! \n");
                    joga.setLocaliza((joga.getLocaliza() + valor) %  casas.size()); //manda ele pra lá
                    casas.get(joga.getLocaliza()).leCasa(joga); 
                }
                else {
                    System.out.println("ops, " + joga.getNome() + " não pode jogar ainda pois está em" + joga.getStatus() + "\n");
                }
 
            }
            System.out.println("\nDesejam jogar mais uma rodada? ");
            init = sc.nextLine();
        }
        System.out.println("\nFoi bom jogar com vocês, vejam os resultados: ");
        for (IJogador rank : jogadores) {
            System.out.println(rank.getNome() + "   saldo total: " + (rank.getCarteira() + rank.getImoveis()));
        }

        
    }

    public static int girarDados() {
        Random aleatorio = new Random(); // função random
        int valor = aleatorio.nextInt(1, 13);
        return valor;
    }

    //public void criarCasas(FabricaCasa fabrica, String tipo, String nome, int grupo) {
    //    this.casas.add(fabrica.criarCasa(tipo, nome, grupo));
   // }
}
