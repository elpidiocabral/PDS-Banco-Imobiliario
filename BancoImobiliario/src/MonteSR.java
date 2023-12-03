import java.util.ArrayList;

import Carta.CartaSorteOuReves;
import Carta.ICarta;
import Jogador.IJogador;

public class MonteSR {
    ArrayList<ICarta> sorteReves;

    public MonteSR() {
        sorteReves = new ArrayList<ICarta>();
    }

    public void inicializarMonte() {
        ICarta sorte1 = new CartaSorteOuReves("REVÉS","quebrou as pernas e teve que arcar com custos médicos, perdeu ");
        ICarta sorte2 = new CartaSorteOuReves("SORTE","ganhou na loteriaaa, ganhou "); 
        ICarta sorte3 = new CartaSorteOuReves("REVÉS","bateu o carro e não tinha seguro, perdeu ");
        ICarta sorte4 = new CartaSorteOuReves("SORTE", "foi promovido, ganhou ");
        ICarta sorte5 = new CartaSorteOuReves("REVÉS", "bateu o carro, mas tinha seguro, perdeu ");
        ICarta sorte6 = new CartaSorteOuReves("SORTE", "conseguiu CAUSA GANHA! seu divórcio saiu, ganhou ");
        ICarta sorte7 = new CartaSorteOuReves("REVÉS", "FOI PROCESSADO! devido os gastos com os advogados, perdeu ");
        ICarta sorte8 = new CartaSorteOuReves("REVÉS", "PERDEU TUDO! uma sorte chuva afetou sua casa, os custos pagos somam ");
        ICarta sorte9 = new CartaSorteOuReves("REVÉS", "você foi a uma exposição de arte e quebrou a obra mais valiosa, perdeu ");
        ICarta sorte10 = new CartaSorteOuReves("REVÉS", "seu carro quebrou na estrada perdeu ");
        ICarta sorte11 = new CartaSorteOuReves("REVÉS","investimnetos de alto risco na bolsa lhe fizeram perder dinheiro, perdeu ");
        ICarta sorte12 = new CartaSorteOuReves("REVÉS", "seu filho está entrando na faculdade - e não é na federal - perdeu ");
        ICarta sorte13 = new CartaSorteOuReves("SORTE", "ganhou na telesena, ganhou ");
        ICarta sorte14 = new CartaSorteOuReves("SORTE", "andando na rua encontrou uma moeda valiosa para colecionadores, ganhou ");
        ICarta sorte15 = new CartaSorteOuReves("REVÉS", "está devendo a um agiota, perdeu ");
        ICarta sorte16 = new CartaSorteOuReves("SORTE", "lançou um produto inovador no mercado, ganhou ");
        ICarta sorte17 = new CartaSorteOuReves("SORTE", "abriu um novo negócio e está fazendo sucesso, ganhou ");
        ICarta sorte18 = new CartaSorteOuReves("REVÉS", "está inadimplente, para regularizar suas contas você perdeu ");
        ICarta sorte19 = new CartaSorteOuReves("SORTE","não esperava, mas um tio distante sem herdeiros faleceu deixando a herança em seu nome, ganhou ");
        ICarta sorte20 = new CartaSorteOuReves("REVÉS", "uma de suas empresas faliu, perdeu ");
        
        sorteReves.add(sorte1);
        sorteReves.add(sorte2);
        sorteReves.add(sorte3);       
        sorteReves.add(sorte4);
        sorteReves.add(sorte5);
        sorteReves.add(sorte6);
        sorteReves.add(sorte7);
        sorteReves.add(sorte8);
        sorteReves.add(sorte9);
        sorteReves.add(sorte10);
        sorteReves.add(sorte11);
        sorteReves.add(sorte12);
        sorteReves.add(sorte13);
        sorteReves.add(sorte14);
        sorteReves.add(sorte15);
        sorteReves.add(sorte16);
        sorteReves.add(sorte17);
        sorteReves.add(sorte18);
        sorteReves.add(sorte19);
        sorteReves.add(sorte20);
    }

    public String retirarCarta(IJogador jogador) {
        ICarta carta = sorteReves.get(0);
        String confirmacao = carta.getNome();

        carta.setProprietario(jogador);
        jogador.setCarteira(carta.getValor());
        sorteReves.remove(0);
        
        return confirmacao;
    }
}
