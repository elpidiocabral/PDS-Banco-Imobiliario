package Dado;

public class ControllerDados {
    IDado dados;

    public ControllerDados() {
        dados = new Dados();
    }

    public int girarDados() {
        return dados.girarDados();
    }
}
