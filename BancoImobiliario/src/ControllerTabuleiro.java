import Casas.ICasa;
import Jogador.IJogador;

public class ControllerTabuleiro {
    TabuleiroSingleton tabuleiro;

    public ControllerTabuleiro() {
        tabuleiro = tabuleiro.getTabuleiro();
    }

    public void cadastrarJogador(String nome) {
        tabuleiro.adicionaJogadores(nome);
    }

    public void inicializarJogo() {
        tabuleiro.inicializaTabuleiro();
    }

    public void novaRodada() {
        tabuleiro.novaRodada();
    }

    public int getNumRodadas(){
        return tabuleiro.getNumRodadas();
    };

    public void preparaReceber(boolean ok) {
        tabuleiro.setSinaliza(ok);
    }

    public String retornoTabuleiro() {
        return tabuleiro.retornoTabuleiro();
    }

    public IJogador getJogador() {
        return tabuleiro.getJogador(); 
    }

    public String solicitaCompra() {
        return tabuleiro.solicitaCompra(getJogador(), getCasa());
    }

    public ICasa getCasa() {
        return tabuleiro.getCasa();
    }

    public int numIteracoes() {
        return tabuleiro.getNumJogadores();
    }

    public void incrementaRodada() {
        tabuleiro.incrementaRodada();
    }

    public String encerraJogo() {
        return tabuleiro.encerraJogo();
    }

    public IJogador getJogadorVez() {
        return tabuleiro.getJogadorVez();
    }
}
