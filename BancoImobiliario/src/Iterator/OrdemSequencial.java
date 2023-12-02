package Iterator;

import Jogador.IJogador;

public class OrdemSequencial implements IIterador {
	private IJogador[] jogadores;
	private int atual;

	public OrdemSequencial(IJogador[] jogadores) {
		this.jogadores = jogadores;
		this.atual = 0;
	}
	
	public boolean temProximo() {
		if(jogadores.length == 0) {
			return false;
		} else {
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
			System.out.println("JOGADOR ITEROU VIU " + this.atual);
		}
		return jogador;
	}

}
