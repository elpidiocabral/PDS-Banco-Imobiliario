package Iterator;

import Jogador.IJogador;

public class OrdemSequencial implements IIterador {
	private IJogador[] jogadores;
	private int atual;

	public OrdemSequencial(IJogador[] jogadores) {
		this.jogadores = jogadores;
		this.atual = 0;
	}
	
	public void ordenar() {
		// apenas implementando
	}

	public boolean temProximo() {
		if(jogadores.length == 0) {
			return false;
		} else {
			if(jogadores.length-1 >= atual) {
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

	public IJogador getAnterior() {
		if(jogadores[atual-1] == null) {
			System.out.println("ULTIMO");
			return getUltimo();
		} else {
			System.out.println("ANTERIOR");
			return jogadores[atual-1];
		}
	}
}
