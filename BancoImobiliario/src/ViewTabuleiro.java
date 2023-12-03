import java.util.Scanner;

public class ViewTabuleiro {
    ControllerTabuleiro controllerTab;
    ControllerMonteSR controllerMonteSR;
    Scanner sc;
    String resp;


    public ViewTabuleiro() {
        controllerTab = new ControllerTabuleiro();
        controllerMonteSR = new ControllerMonteSR();
        sc = new Scanner(System.in);
        resp = "";
    }

    public void cadastrarJogador() {
        System.out.println("- - RESPONDA S/N COM LETRAS MAIUSCULAS ");
        System.out.print("\nPRIMEIRO PASSO: cadastro de jogadores");
        boolean controle = true;
        while(controle) {
            System.out.println("\nDigite o nome do jogador...");
            resp = sc.nextLine(); 
            controllerTab.cadastrarJogador(resp);
            System.out.println("\nVocê deseja cadastrar outro jogador? S/N");
            resp = sc.nextLine();
            if(resp.equals("N")) controle = false;
        }
        System.out.println("\nCadastro finalizado, à todos uma boa partida\n");
        Jogar();
    }

    public void inicializarJogo() {
        System.out.println("Desejaria inicializar o jogo? S/N");
        resp = sc.nextLine();
        if(resp.equals("S") || resp.equals("s")) {
            controllerTab.inicializarJogo();
            controllerMonteSR.inicializarMonte();
            cadastrarJogador();
        }
        else {
            System.out.println("\nAté a próxima, bye bye...");
        }
    }

    public void novaRodada() {
        controllerTab.novaRodada();
        
        System.out.println(controllerTab.retornoTabuleiro()); 

        resp = sc.nextLine();
        switch (resp) {
            case "S":
                System.out.println(controllerTab.solicitaCompra());
                break;

            case "C":
                System.out.println(controllerMonteSR.retirarCarta(controllerTab.getJogadorVez()));
                break;

            default:
                //System.out.println("aperte ENTER para continuar o jogo!");
                break;
        }
    }

    public void Jogar() {
        boolean controle = true;
        while(controle) {
            novaRodada();
            System.out.println("Ir para o próximo jogador S/N");
            controle = captarEntrada();

            controllerTab.incrementaRodada();
        }
        System.out.println(" - - - FIM DE JOGO - - - \n");
        System.out.println("\nRANKING--------------\n" + controllerTab.encerraJogo());
    }

    public boolean captarEntrada() {
        resp = sc.nextLine();
        if(resp.equals("S") || resp.equals("s")) {
            return true;
        }
        else {
            return false;
        }
    }
}
