import Casas.*;
import Jogador.IJogador;
import Jogador.Jogador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Carta.CartaSorteOuReves;
import Carta.ICarta;

//import Carta.*;

public class App {
    //ArrayList<ICasa> casas = new ArrayList<ICasa>();
    //FabricaCasa fabrica = new FabricaCasa();
    public static void main(String[] args) throws Exception {
        
        //coisas que serão de tabuleiro
        ArrayList<ICasa> casas = new ArrayList<ICasa>();
        ArrayList<ICarta> monteSorteReves = new ArrayList<ICarta>();
        FabricaCasa fabrica = new FabricaCasa();
        ArrayList<IJogador> jogadores = new ArrayList<IJogador>();
        int dado = 0;
        
        //coisas que serão da view (eu acho)
        int rodada = 0;
        String init = ""; 
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random(); // função random

        //cAsas de Efeito - grupo 0
        ICasa sorteOuReves = fabrica.criarCasa("SR", "Sorte ou Revés", -1);
        ICasa prisao = fabrica.criarCasa("Efeito","Prisão", 0);
        ICasa inicial = fabrica.criarCasa("Efeito", "Início", 0);
        
        //Ceará - grupo 2
        ICasa aldeota = fabrica.criarCasa("Local","Aldeota", 2);
        ICasa meireles = fabrica.criarCasa("Local","Meireles", 2);
        ICasa cedro = fabrica.criarCasa("Local","Açude do Cedro", 2);
        ICasa companhiaFerro = fabrica.criarCasa("Empresa", "Companhia Ferroviária", 0);
        ICasa bezerra = fabrica.criarCasa("Local","Av Bezerra de Menezes", 2);
        ICasa praca = fabrica.criarCasa("Local","Praça do Ferreira", 2);
        ICasa mister = fabrica.criarCasa("Local","Av MisterHall", 2);
        ICasa beiramar = fabrica.criarCasa("Local","Av Beria Mar", 2);
        ICasa quixada = fabrica.criarCasa("Local","Quixadá - terra dos monólitos", 2);
        ICasa eusebio = fabrica.criarCasa("Local","Eusebio", 2);
        ICasa agua = fabrica.criarCasa("Empresa", "Cagece - companhia de abastecimento de água", 2);
        ICasa internet = fabrica.criarCasa("Empresa", "Brisanet Internet", 0);
    
        //Rio Janeiro - grupo 3
        ICasa brasil = fabrica.criarCasa("Local","Av Brasil", 3);
        ICasa ipanema = fabrica.criarCasa("Local","Ipanema", 3);
        ICasa copacaba = fabrica.criarCasa("Local","Copacaba", 3);
        ICasa taxi = fabrica.criarCasa("Empresa", "Companhia Taxista do RJ", 3);
        ICasa petroleo = fabrica.criarCasa("Empresa", "Petrobrás - Petrolífera Nacional", 3);
        ICasa barra = fabrica.criarCasa("Local", "Barra da Tijuca", 3);
        ICasa leblon = fabrica.criarCasa("Local", "Leblon", 3);
        ICasa buzios = fabrica.criarCasa("Local", "Ilhas de Búzios", 3);
        
        //São Paulo - grupo 4
        ICasa paulista = fabrica.criarCasa("Local","Av Paulista", 4);
        ICasa brigadeiro = fabrica.criarCasa("Local","Av Brigaderio", 4);
        ICasa china = fabrica.criarCasa("Local","Bairro Liberdade", 4);
        ICasa se = fabrica.criarCasa("Local","Praça da Sé", 4);
        ICasa energia = fabrica.criarCasa("Empresa", "EletroPaulo: Companhia de Eletricidade", 4);
        ICasa jardins = fabrica.criarCasa("Local", "Jardim Paulista", 4);
        ICasa morumbi = fabrica.criarCasa("Local","Morumbi", 4);
        ICasa aviao = fabrica.criarCasa("Empresa", "Companhia Brasileira de Aviação", 4);

        //add na ordem de distribuição do tabuleiro original
        casas.add(inicial);
        casas.add(aldeota);
        casas.add(sorteOuReves);
        casas.add(meireles);
        casas.add(cedro);
        casas.add(companhiaFerro);
        casas.add(bezerra);
        casas.add(praca);
        casas.add(prisao);
        casas.add(mister);
        casas.add(sorteOuReves);
        casas.add(beiramar);
        casas.add(quixada);
        casas.add(internet);
        casas.add(sorteOuReves);
        casas.add(eusebio);
        casas.add(agua);
        casas.add(brasil);
        casas.add(ipanema);
        casas.add(sorteOuReves);
        casas.add(copacaba);
        casas.add(taxi);
        casas.add(petroleo);
        casas.add(buzios);
        casas.add(sorteOuReves);
        casas.add(leblon);
        casas.add(barra);
        casas.add(prisao);
        casas.add(china);
        casas.add(energia);
        casas.add(jardins);
        casas.add(morumbi);
        casas.add(aviao);
        casas.add(se);
        casas.add(sorteOuReves);
        casas.add(paulista);
        casas.add(brigadeiro);
       

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


        ICarta sorte1 = new CartaSorteOuReves("REVÉS"," quebrou as pernas e teve que arcar com custos médicos, pague ");
        ICarta sorte2 = new CartaSorteOuReves("SORTE"," ganhou na loteriaaa, ganhou "); 
        ICarta sorte3 = new CartaSorteOuReves("REVÉS"," bateu o carro e não tinha seguro, pague ");
        ICarta sorte4 = new CartaSorteOuReves("SORTE", " foi promovido, pague ");
        ICarta sorte5 = new CartaSorteOuReves("REVÉS", " bateu o carro, mas tinha seguro, ganhou ");
        ICarta sorte6 = new CartaSorteOuReves("SORTE", " conseguiu CAUSA GANHA! seu divórcio saiu, ganhe ");
        ICarta sorte7 = new CartaSorteOuReves("REVÉS", " FOI PROCESSADO! devido os gastos com os advogados, pague ");
        ICarta sorte8 = new CartaSorteOuReves("REVÉS", " PERDEU TUDO! uma sorte chuva afetou sua casa, os custos serão de ");
        ICarta sorte9 = new CartaSorteOuReves("REVÉS", " você foi a uma exposição de arte e quebrou a obra mais valiosa, pague ");
        ICarta sorte10 = new CartaSorteOuReves("REVÉS", " seu carro quebrou na estrada pague ");
        ICarta sorte11 = new CartaSorteOuReves("REVÉS","  investimnetos de alto risco na bolsa lhe fizeram perder dinheiro, pague ");
        ICarta sorte12 = new CartaSorteOuReves("REVÉS", " seu filho está entrando na faculdade - e não é na federal - pague ");
        ICarta sorte13 = new CartaSorteOuReves("SORTE", " ganhou na telesena, ganhe ");
        ICarta sorte14 = new CartaSorteOuReves("SORTE", " andando na rua encontrou uma moeda valiosa para colecionadores, ganhe ");
        ICarta sorte15 = new CartaSorteOuReves("REVÉS", " está devendo a um agiota, pague ");
        ICarta sorte16 = new CartaSorteOuReves("SORTE", " lançou um produto inovador no mercado, ganhe ");
        ICarta sorte17 = new CartaSorteOuReves("SORTE", " abriu um novo negócio e está fazendo sucesso ");
        ICarta sorte18 = new CartaSorteOuReves("REVÉS", " está inadimplente, regularize suas contas pagando ");
        ICarta sorte19 = new CartaSorteOuReves("SORTE"," não esperava, mas um tio distante sem herdeiros faleceu deixando a herança em seu nome, ganhe ");
        ICarta sorte20 = new CartaSorteOuReves("REVÉS", " uma de suas empresas faliu, pague ");
        
        monteSorteReves.add(sorte1);
        monteSorteReves.add(sorte2);
        monteSorteReves.add(sorte3);       
        monteSorteReves.add(sorte4);
        monteSorteReves.add(sorte5);
        monteSorteReves.add(sorte6);
        monteSorteReves.add(sorte7);
        monteSorteReves.add(sorte8);
        monteSorteReves.add(sorte9);
        monteSorteReves.add(sorte10);
        monteSorteReves.add(sorte11);
        monteSorteReves.add(sorte12);
        monteSorteReves.add(sorte13);
        monteSorteReves.add(sorte14);
        monteSorteReves.add(sorte15);
        monteSorteReves.add(sorte16);
        monteSorteReves.add(sorte17);
        monteSorteReves.add(sorte18);
        monteSorteReves.add(sorte19);
        monteSorteReves.add(sorte20);

        //view.inicializarJogo;
        
        System.out.println("Deseja começar o jogo? S/N");
        init = sc.nextLine(); 
        while(init.equals("S") || init.equals("s")){
            rodada++;
            System.out.println("rodada: " + rodada);
            for (IJogador joga : jogadores) {
                if(joga.getStatus().equals("livre")) {
                    System.out.println("\nJogador da vez: " + joga.getNome());
                    System.out.print("lançando os dados... ");
                    joga.setNumRodadas();
                    int valor = aleatorio.nextInt(1, 13);
                    dado = valor - 1; //pega o números
                    System.out.println(dado + "!! \n");
                    joga.setLocaliza((joga.getLocaliza() + valor) %  casas.size()); //manda ele pra lá
                    casas.get(joga.getLocaliza()).leCasa(joga); 
                }
                else {
                    System.out.println("ops, " + joga.getNome() + " não pode jogar ainda pois está em" + joga.getStatus() + "\n");
                    if(joga.getStatus() == "férias" && joga.getNumRodadas() == rodada - 2) joga.setStatus("livre");
                    else if (joga.getStatus() == "preso" && joga.getNumRodadas() == rodada - 3) joga.setStatus("livre");


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
