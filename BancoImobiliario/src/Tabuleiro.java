import java.util.ArrayList;

import Casas.*;
import Iterator.IAgregador;
import Iterator.IIterador;
import Iterator.OrdemGanhadores;
import Iterator.OrdemSequencial;
import Jogador.*;

public class Tabuleiro implements ITabuleiro, IAgregador {
    ArrayList<ICasa> casas; 
    IFabricaCasa fabrica;
    ArrayList<IJogador> jogadores;
    int rodadas;
    int realRodadas; // verdadeiro numero de rodadas
    IIterador iterador;
    
    
    IJogador joga;
    ICasa casa;
    String comunica;
    boolean sinaliza;
    
    
    public Tabuleiro() {
        casas = new ArrayList<ICasa>();
        fabrica = new FabricaCasa();
        jogadores = new ArrayList<IJogador>();
        rodadas = 1;
        realRodadas = 0;
        comunica = "";
        sinaliza = true;
    }

    public void adicionaJogadores(String nome) {
        IJogador jogador = new Jogador(nome);
        jogadores.add(jogador);
    }

    public void inicializaTabuleiro() {
        //casas de Efeito - grupo 0 casas de sorte ou revés grupo -1
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

        System.out.println("TURNOS --> " + this.rodadas);
        System.out.println("RODADAS -> " + this.realRodadas);

        if(this.rodadas == 1) {
            this.iterador = criaIterator("rodada");   
            joga = iterador.leProximo();
            System.out.println("Ó O NOME => " + joga.getNome());
        }
        
        //if( (this.rodadas % jogadores.size()) == 0 ) joga = iterador.leProximo();
        
        for(int i = 0; i < jogadores.size(); i++) {
            mensagem += joga.getNome();
            int valor = 0;
            
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
                    joga = solicitaProximo(iterador);
                    if( (this.rodadas % jogadores.size()) == 0 ) joga = iterador.leProximo();

                    break;
                }
            }
            else {
                mensagem =  "não pode jogar pois está " + joga.getStatus();
                if(joga.getStatus().equals("de férias") && rodadas - joga.getNumRodadas() == 2) {
                    joga.setStatus("livre");
                }
                if(joga.getStatus().equals("preso") && rodadas - joga.getNumRodadas() == 3) {
                    joga.setStatus("livre");
                }
                setComunica(mensagem);
            }
                       
            joga = solicitaProximo(iterador);
        }
    }

    public String andarCasas(IJogador jogador, int valor) {
        int index = (casas.size() % valor + 1) + jogador.getLocaliza();

        System.out.println(jogador.getNome());
        String base = jogador.getNome() + " andará " + valor + " casas...\n\n";

        casa = casas.get(index);
        jogador.setLocaliza(index);

        //cartas locais e de empresa tem grupo maior que 0, só casas de efeito tem grupo 0
        if(casa.getGrupo() > 0 && casa.getProprietario() == null) {
            base += casas.get(index).leCasa(jogador) + "\nDeseja comprar esta casa?";

            return base;
        }
        else if(casa.getGrupo() > 0 && casa.getProprietario() != null) {
            base += casas.get(index).leCasa(jogador);

            if(casa.getProprietario().equals(jogador)) base += "  \nlar doce lar";

            float custo = casa.calcularPedagio();
            base += "\n" + jogador.getNome() + " paga " + valor + " para " + casa.getProprietario().getNome() + "\n";
            
            setComunica(base);

            jogador.setCarteira(-custo);
            casa.getProprietario().setCarteira(custo);

            return base;
        }
        else if(casa.getGrupo() == -1) {
            base += casas.get(index).leCasa(jogador);
            return base;

        }
        else if(casa.getGrupo() == 0) {
            return base;
        }
        return "";
    }
    // fim andar casas

    public String solicitaCompra(IJogador jogador, ICasa casa) {
        casa.setProprietario(jogador); 
        return "---compra realizada com sucesso!---\n\n";
    }

    public String solicitaGirarDados() {
        return "gire os dados apertando ENTER";
    }

    public int girarDados(IJogador jogador) {
        int valor = jogador.girarDados();
        return valor;
    }

    public IJogador solicitaProximo(IIterador iterador) {
        //return iterador.leProximo();
        
        double rod = rodadas; // TURNO
        double jog = jogadores.size();
        
        System.out.println("TESTE => % " + rodadas % jogadores.size());

        if( (rodadas % jogadores.size()) == 0 ) {
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

    public int getNumRodadas() {
        return rodadas;
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
        this.rodadas++;
    }
}
