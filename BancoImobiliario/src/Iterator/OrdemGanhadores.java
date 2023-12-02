package Iterator;

import Jogador.IJogador;

public class OrdemGanhadores implements IIterador{
	private IJogador[] jogadores;
	private int atual;
	public OrdemGanhadores(IJogador[] jogadores) {
		this.jogadores = jogadores;
        this.ordenar();
		atual = 0;
	}

    private void ordenar() {
		for(int i = 0; i < jogadores.length; i++){
            for(int j = i + 1; j<jogadores.length; j++){
                //if(alunos[i].compareTo(alunos[j])>0){
            	if((jogadores[i].getCarteira() + jogadores[i].getImoveis()) < (jogadores[j].getCarteira() + jogadores[j].getImoveis()) ){
                    //troca
                    IJogador temporario = jogadores[i];
                    jogadores[i] = jogadores[j];
                    jogadores[j] = temporario;
                }
            }
        }
	}
	
	public boolean temProximo() {
		if(jogadores.length == 0) {
			return false;
		} 
		else {
			
			if(jogadores.length > atual) {
				return true;
			} 
			else {
				return false;
			}
		}
	}
	public IJogador leProximo() {
		IJogador jogador = null;
		if(this.temProximo()) {
			jogador = this.jogadores[atual];
			atual++;
		}
		return jogador;
	}
}