package Jogador;

public class Jogador implements IJogador {
    
    String nome;
    float carteira;
    int imoveis;
    int localiza;
    String status;

    public Jogador(String nome) {
        this.nome = nome;
        this.carteira = 2558000;
        this.imoveis = 0; // aqui vamos salvar o que esse jogador tem de ações em imóveis, pra facilitar o ranking final
        this.localiza = 0; // a pendência servirá em casos de punições como "fique 3 rodadas sem jogar, como um contador, apesar de que eu creio que daria pra fazer de um jeito melhor pensando um pouco mais"
        this.status = "livre"; // o status vai dizer onde ele está = de férias, na prisão ou livre;
    }
    

    public void setCarteira(float valor) {
        this.carteira += valor;
    }

    public float getCarteira() {
        return carteira;
    }

    public void tornarProprietario() {
        //tornarProprietarioView(getNome()); algo do tipo
    }
    public void girarDados() {
        // girarDadosView();
    }
    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }


    public int getLocaliza() {
        return localiza;
    }

    public void setLocaliza(int local) {
        this.localiza = local;
    }

    public void setImoveis(int valor) {
        imoveis += valor;
    }

    public int getImoveis() {
        return imoveis;
    }

    
}
