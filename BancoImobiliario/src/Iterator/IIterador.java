package Iterator;

import Jogador.IJogador;

public interface IIterador {
    public boolean temProximo();
	public IJogador leProximo();
	public IJogador getUltimo();
	public IJogador getPrimeiro();
} 