import Jogador.IJogador;

public class ControllerMonteSR {
    MonteSR monte;

    public ControllerMonteSR() {
        monte = new MonteSR();
    }

    public void inicializarMonte() {
        monte.inicializarMonte();
    }

    public String retirarCarta(IJogador jogador) {
        return monte.retirarCarta(jogador);
    }


}
