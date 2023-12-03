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
			if(jogadores.length-1 >= atual) {
				System.out.println("AQUI ->> " +jogadores.length);
				return true;
			} 
			else {
				//System.out.println("RAPAZ MENINO GAROTO");
				return false;
			}
		}
	}

	public IJogador leProximo() {
		IJogador jogador = null;
		if(this.temProximo()) {
			jogador = this.jogadores[atual];
			atual++;
			//System.out.println("JOGADOR ITEROU VIU " + this.atual);
		} else {
			jogador = this.getPrimeiro();
			atual = 0;
		}
		return jogador;
	}

	public IJogador getUltimo() {
		return jogadores[jogadores.length-1];
	}

	public IJogador getPrimeiro() {
		atual = 0;
		return jogadores[atual];
	}

	public int getAtual() {
		return atual;
	}
}
