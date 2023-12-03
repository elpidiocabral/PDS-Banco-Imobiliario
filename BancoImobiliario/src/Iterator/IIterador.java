package Iterator;

import Jogador.IJogador;

public interface IIterador {
	public void ordenar();
    public boolean temProximo();
	public IJogador leProximo();
	public IJogador getUltimo();
	public IJogador getPrimeiro();
} 