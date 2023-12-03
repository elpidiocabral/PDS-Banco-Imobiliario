import Jogador.IJogador;

public class ControllerMonteSR {
    MonteSingletonSR monte;

    public ControllerMonteSR() {
        monte = monte.getMonteSingleton();
    }

    public void inicializarMonte() {
        monte.inicializarMonte();
    }

    public String retirarCarta(IJogador jogador) {
        return monte.retirarCarta(jogador);
    }
}
