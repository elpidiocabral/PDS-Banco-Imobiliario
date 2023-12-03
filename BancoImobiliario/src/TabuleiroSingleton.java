import java.util.ArrayList;

import Casas.*;
import Iterator.IAgregador;
import Iterator.IIterador;
import Iterator.OrdemGanhadores;
import Iterator.OrdemSequencial;
import Jogador.*;

public class TabuleiroSingleton implements ITabuleiro, IAgregador {
    
    private static TabuleiroSingleton uniqueTabuleiroSingleton;
    private static ArrayList<ICasa> casas; 
    private static IFabricaCasa fabrica;
    
    private IIterador iterador;
    private ArrayList<IJogador> jogadores;
    private IJogador joga;
    private IJogador jogadorVez;
    private ICasa casa;

    int turnos;
    String comunica;
    int realRodadas; // verdadeiro numero de rodadas
    boolean sinaliza;
    
    
    private TabuleiroSingleton() {
        fabrica = new FabricaCasa();
        casas = new ArrayList<ICasa>();
        jogadores = new ArrayList<IJogador>();
        turnos = 1;
        realRodadas = 1;
        comunica = "";
        sinaliza = true;
    }

    public static TabuleiroSingleton getTabuleiro() {
        if(uniqueTabuleiroSingleton == null) {
            uniqueTabuleiroSingleton = new TabuleiroSingleton();
        }
        return uniqueTabuleiroSingleton;
    }

    public void adicionaJogadores(String nome) {
        IJogador jogador = new Jogador(nome);
        jogadores.add(jogador);
    }

    public void inicializaTabuleiro() {
        //casas de Efeito - grupo 0 casas de sorte ou revés grupo -1
        ICasa sorteOuReves = fabrica.criarCasa("Efeito", "SR", 0);
        ICasa prisao = fabrica.criarCasa("Efeito","Prisão", 0);
        ICasa inicial = fabrica.criarCasa("Efeito", "Início", 0);
         
        //Ceará - grupo 2
        ICasa aldeota = fabrica.criarCasa("Local","Aldeota", 2);
        ICasa meireles = fabrica.criarCasa("Local","Meireles", 2);
        ICasa cedro = fabrica.criarCasa("Local","Açude do Cedro", 2);
        ICasa companhiaFerro = fabrica.criarCasa("Empresa", "Companhia Ferroviária", 2);
        ICasa bezerra = fabrica.criarCasa("Local","Av Bezerra de Menezes", 2);
        ICasa praca = fabrica.criarCasa("Local","Praça do Ferreira", 2);
        ICasa mister = fabrica.criarCasa("Local","Av MisterHall", 2);
        ICasa beiramar = fabrica.criarCasa("Local","Av Beria Mar", 2);
        ICasa quixada = fabrica.criarCasa("Local","Quixadá - terra dos monólitos", 2);
        ICasa eusebio = fabrica.criarCasa("Local","Eusebio", 2);
        ICasa agua = fabrica.criarCasa("Empresa", "Cagece - companhia de abastecimento de água", 2);
        ICasa internet = fabrica.criarCasa("Empresa", "Brisanet Internet", 2);
     
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
    }

    public IIterador criaIterator(String tipo) {
        IJogador jog[] = new IJogador[this.jogadores.size()];
        switch (tipo) {
            case "ganha":
                return new OrdemGanhadores(this.jogadores.toArray(jog));

            default:
                return new OrdemSequencial(this.jogadores.toArray(jog));
        }
    }

    public void novaRodada() {
        String mensagem = ""; 
        
        if(this.turnos == 1) {
            this.iterador = criaIterator("rodada");   
            joga = iterador.leProximo();
        }

        for(int i = 0; i < jogadores.size(); i++) {
            mensagem += joga.getNome();
            int valor = 0;
            
            if(joga.getStatus().equals("falido") && (joga.getCarteira() > 0)) {
                // System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA DEPRESSAO");
                joga.setStatus("livre");
            }

            if(joga.getStatus().equals("livre")) {
                if(getSinaliza()) { //validação de dados sendo girados;
                    valor = girarDados(joga);
                    // retorna a string de resulta após mover o jogador
                    setComunica( andarCasas(joga, valor) );
                    
                    /*
                     * Acontece do solicitaProximo() fazer com que o primeiro jogador jogue 2x ao resetar
                     * por isso uso um if para perguntar "a rodada resetou?"
                     * se sim, e pego o 2º jogador
                     */
                    joga.setNumRodadas(); // incrementa a rodada do jogador
                    joga = solicitaProximo(iterador);
                    if( (this.turnos % jogadores.size()) == 0 ) joga = iterador.leProximo();

                    break;
                }
            }
            // JOGADOR PRESO ou FALIDO
            else {
                joga.setStatusRodadas();
                mensagem = "\n" + joga.getNome() + " não pode jogar pois está " + joga.getStatus();
                mensagem += "\naperte ENTER para continuar o jogo!";

                if(joga.getStatus().equals("de férias") && (joga.getStatusRodadas() > 2)) {
                    joga.setStatus("livre");
                    joga.resetStatusRodadas();
                }
                if(joga.getStatus().equals("preso") && (joga.getStatusRodadas() > 3)) {
                    joga.setStatus("livre");
                    joga.resetStatusRodadas();
                }

                setComunica(mensagem);

                joga = solicitaProximo(iterador);
                if( (this.turnos % jogadores.size()) == 0 ) joga = iterador.leProximo();
                
                break;
            }

            joga = solicitaProximo(iterador); 
        }
    }

    public String andarCasas(IJogador jogador, int valor) {
        jogadorVez = jogador;
        int index = ((valor + jogadorVez.getLocaliza()) % casas.size());
        
        //System.out.println(jogador.getNome());
        String base = "\n" + jogadorVez.getNome() + " andará " + valor + " casas...\n\n";

        casa = casas.get(index);
        jogadorVez.setLocaliza(index);

        //cartas locais e de empresa tem grupo maior que 0, só casas de efeito tem grupo 0
        if(casa.getGrupo() > 0 && casa.getProprietario() == null) {
            base += casas.get(index).leCasa(jogadorVez) + "\nDeseja comprar esta casa S/N?";
            return base;
        }
        else if(casa.getGrupo() > 0 && casa.getProprietario() != null) {
            base += casas.get(index).leCasa(jogadorVez);

            if(casa.getProprietario().equals(jogadorVez)) {
                return base;
            }
            else if(!casa.getProprietario().equals(jogadorVez)) {
                float custo = casa.calcularPedagio();
                base += "\n" + jogadorVez.getNome() + " paga " + custo + " para " + casa.getProprietario().getNome() + "\n";

                setComunica(base);

                if(jogadorVez.getCarteira() < custo) {
                    casa.getProprietario().setCarteira(jogadorVez.getCarteira());
                    jogadorVez.falido();
                    
                    base += jogadorVez.getNome() + " acabou de falir, PERDEU TUDOO!!\nsó voltará a jogar quando tiver dinheiro";
                    return base;
                } 
                
                jogadorVez.setCarteira(-custo);
                casa.getProprietario().setCarteira(custo);

                return base;
            }
        }
        else if(casa.getGrupo() == -1) {
            base += casas.get(index).leCasa(jogadorVez);
            return base;

        }
        // IF das cartas
        else if(casa.getGrupo() == 0) {
            jogadorVez = jogador;
            base += casas.get(index).leCasa(jogadorVez);
            return base;
        }
        return "";
    }
    // fim andar casas

    public String solicitaCompra(IJogador jogador, ICasa casa) {
        if(jogadorVez.getCarteira() < casa.getValor()) {
            return "---você não tem saldo suficiente para esta compra---\n";
        } 

        casa.setProprietario(jogadorVez); 
        jogadorVez.setCarteira(-(casa.getValor()));
        
        if(jogadorVez.getCarteira() < 1) {
            jogadorVez.falido();
        }
        jogadorVez.setImoveis(casa.getValor());
        return "---compra realizada com sucesso!---\n";
    }

    public int girarDados(IJogador jogador) {
        int valor = jogador.girarDados();
        return valor;
    }

    public IJogador solicitaProximo(IIterador iterador) {
        if( (turnos % jogadores.size()) == 0 ) {
            this.realRodadas++;
            return iterador.getPrimeiro();
        } 
        else if(iterador.temProximo() == true) {
            return iterador.leProximo();
        } 
        else { // estamos no ultimo
            return iterador.getUltimo();
        }
    }

    public String encerraJogo() {
        String ranking = "";
        iterador = criaIterator("ganha");
        iterador.ordenar();
        
        for(int i = 0; i < jogadores.size(); i++) {
            joga = iterador.leProximo();
            ranking += (i+1) + "º: " + joga.getNome() + "\n$$: " + joga.getCarteira()+ "\n---------------------\n";
            //ranking += (i+1) + "º: " + joga.getNome() + "\n$$: " + ( joga.getCarteira() + joga.getImoveis() ) + "\n---------------------\n";
        }

        return ranking;
    }

    public int getNumRodadas() {
        return turnos;
    }

    public void setSinaliza(boolean ok) {
        sinaliza = ok;
    }

    public boolean getSinaliza() {
        return sinaliza;
    } 

    public void setComunica(String string) {
        comunica = string;
    }

    public String retornoTabuleiro() {
        return comunica;
    }

    public IJogador getJogador() {
        return joga;
    }

    public ICasa getCasa() {
        return casa;
    }

    public int getNumJogadores() {
        return jogadores.size();
    }

    public void incrementaRodada() {
        this.turnos++;
    }

    public IJogador getJogadorVez() {
        return jogadorVez;
    }
}
